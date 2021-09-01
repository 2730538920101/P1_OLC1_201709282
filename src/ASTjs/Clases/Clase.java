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

    public String getInsMjs(){
        String mensaje = "\nCANTIDAD DE INSTRUCCIONES ALMACENADAS: " + this.instrucciones.size() + "\n";
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
                "Con las siguientes instrucciones: "+ "\n" +getInsMjs();
    }


}
