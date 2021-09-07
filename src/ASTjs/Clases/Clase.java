/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTjs.Clases;

import java.util.ArrayList;

/**
 *
 * @author Carlos Martinez
 */
public class Clase {
    public String IdClase;
    public ArrayList<Instrucciones> instrucciones; 
    public int LineasClase;
    
    public Clase(String IdClase, ArrayList<Instrucciones> instrucciones){
        this.IdClase = IdClase;
        this.instrucciones = instrucciones;
       
    }

    /**
     * @return the IdClase
     */
    public String getIdClase() {
        return IdClase;
    }

    /**
     * @param IdClase the IdClase to set
     */
    public void setIdClase(String IdClase) {
        this.IdClase = IdClase;
    }

    /**
     * @return the listaVariables
     */
   
    /**
     * @return the LineasClase
     */
    public int getLineasClase() {
        return LineasClase;
    }

    /**
     * @param LineasClase the LineasClase to set
     */
    public void setLineasClase(int LineasClase) {
        this.LineasClase = LineasClase;
    }
    
    
   
        /**
     * @return the instrucciones
     */
    public ArrayList<Instrucciones> getInstrucciones() {
        return instrucciones;
    }

    /**
     * @param instrucciones the instrucciones to set
     */
    public void setInstrucciones(ArrayList<Instrucciones> instrucciones) {
        this.instrucciones = instrucciones;
    }
    
    public int getCantidadInstrucciones(ArrayList<Instrucciones> instrucciones){
        return instrucciones.size();
    }
    
    public int getCantidadMetodos(){
        ArrayList<Metodo> instMet = new ArrayList<>();
        
        for (int i = 0; i < this.instrucciones.size(); i++) {
            if(instrucciones.get(i).tipo == Instruccion.DECLARACIONMETODO){
                instMet.add(this.instrucciones.get(i).getMetodo());
            }
        }
        return instMet.size();
    }
    public int getCantidadVariables(){
        ArrayList<Variable> instVar = new ArrayList<>();
        
        for (int i = 0; i < this.instrucciones.size(); i++) {
            if(instrucciones.get(i).tipo == Instruccion.DECLARACIONVARIABLE){
                instVar.add(this.instrucciones.get(i).getVariable());
            }
        }
        return instVar.size();
    }

    public String getInsMjs(){
        String mensaje = "\nCanitdad de instrucciones de la clase: " + getCantidadInstrucciones(this.instrucciones) + "\n";
        for (int i = 0; i < this.instrucciones.size(); i++) {
            if(this.instrucciones.get(i) != null){
                mensaje = mensaje + this.instrucciones.get(i).getInstruccionesMsj() + "\n";
            }
        }
        return mensaje;
    }
   
    public String getClasesMsj(){
        return "Se detecto la clase: " + this.IdClase + "\n"+ 
                "con un total de: " + getLineasClase() + " lineas \n"+
                "una cantidad de: "+ getCantidadMetodos() + " metodos"+ "\n"+
                "una cantidad de: "+ getCantidadVariables() + " variables"+ "\n"+
                "Con las siguientes instrucciones: "+ "\n" +getInsMjs();
    }


}
