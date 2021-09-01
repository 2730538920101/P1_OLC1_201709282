/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTjs.Clases;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Carlos Martinez
 */
public class Metodo {
    String IdMetodo;
    ArrayList<Parametros> Params;
    public int LineasMetodo;
    public TipoMetodo tipomet;
    public int cantidadParams;
    
    public Metodo(TipoMetodo tipomet, String IdMetodo,ArrayList<Parametros>  Params){
        this.IdMetodo = IdMetodo;
        this.Params = Params;
        this.tipomet = tipomet;
       
    }
    
    public Metodo(TipoMetodo tipomet,String IdMetodo){
        this.IdMetodo = IdMetodo;
        this.tipomet = tipomet;
    }
    
    public void setIdMetodo(String IdMetodo){
        this.IdMetodo = IdMetodo;
    }
    
    public String getIdMetodo(){
        return this.IdMetodo;
    }
    
    public void setParams(ArrayList<Parametros> Params){
        this.Params = Params;
    }
    public ArrayList<Parametros> getParams(){
        return this.Params;
    }
    
    public void setLineasMetodo(int LineasMetodo){
        this.LineasMetodo = LineasMetodo;
    }
    
    public String mensajeParams(){
        String mensaje = "";
        for(int i = 0; i<this.Params.size();i++){
            mensaje = mensaje + this.Params.get(i).getParamsMsj();
        }
        return mensaje;
    }
    /**
     * @return the LineasMetodo
     */
    public int getLineasMetodo() {
        return LineasMetodo;
    }

    /**
     * @return the tipomet
     */
    public TipoMetodo getTipomet() {
        return tipomet;
    }

    /**
     * @param tipomet the tipomet to set
     */
    public void setTipomet(TipoMetodo tipomet) {
        this.tipomet = tipomet;
    }
    
    
    

    
    public String getMetMsj(){
        switch(this.tipomet){
            case CONPARAMETROS:
                return "Se ha detectado el metodo: " + this.IdMetodo + "\n" + mensajeParams() + "\n"+
                        "Con la cantidad de: " + getLineasMetodo() +" lineas"+ "\n";
            case SINPARAMETROS:
                return "Se ha detectado el metodo: " + this.IdMetodo + " sin parametros"+
                        "Con la cantidad de: " + getLineasMetodo()+ " lineas" + "\n";
            default:
                return "";
        }
        
    }

    /**
     * @return the cantidadParams
     */
    public int getCantidadParams() {
        return cantidadParams;
    }

    /**
     * @param cantidadParams the cantidadParams to set
     */
    public void setCantidadParams(ArrayList<Parametros> Params) {
        this.cantidadParams = Params.size();
    }

}   