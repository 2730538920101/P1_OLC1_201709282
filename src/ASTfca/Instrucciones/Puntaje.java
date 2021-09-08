/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTfca.Instrucciones;

import Control.Funciones;
import Vista.Principal;

/**
 *
 * @author Carlos Martinez
 */
public class Puntaje {

    /**
     * @return the tipo
     */
    public TipoPuntaje getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoPuntaje tipo) {
        this.tipo = tipo;
    }
    public PuntajeGeneral pgeneral;
    public PuntajeEspecifico pespecifico;
    public String id;
    public TipoPuntaje tipo;
    public Funciones funciones = Principal.func;
    public String valorg, valoresp;
    public Puntaje(TipoPuntaje tipo, String id, PuntajeGeneral pgeneral){
        this.tipo = tipo;
        this.id = id;
        this.pgeneral = pgeneral;
    }
    
    public Puntaje(TipoPuntaje tipo, String id, PuntajeEspecifico pespecifico){
        this.tipo = tipo;
        this.id = id;
        this.pespecifico = pespecifico;
    }
    
    public Puntaje(TipoPuntaje tipo, PuntajeGeneral pgeneral){
        this.tipo = tipo;
        this.pgeneral = pgeneral;
    }
    
    public Puntaje(TipoPuntaje tipo, PuntajeEspecifico pespecifico){
        this.tipo = tipo;
        this.pespecifico = pespecifico;
    }
    /**
     * @return the pgeneral
     */
    public PuntajeGeneral getPgeneral() {
        return pgeneral;
    }

    /**
     * @param pgeneral the pgeneral to set
     */
    public void setPgeneral(PuntajeGeneral pgeneral) {
        this.pgeneral = pgeneral;
    }

    /**
     * @return the pespecifico
     */
    public PuntajeEspecifico getPespecifico() {
        return pespecifico;
    }

    /**
     * @param pespecifico the pespecifico to set
     */
    public void setPespecifico(PuntajeEspecifico pespecifico) {
        this.pespecifico = pespecifico;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
    
    
    public String getPuntajesMsj(){
        switch(this.tipo){
            case GENERAL:
                return "Puntaje de tipo: " + getPgeneral().getGeneralMsj();
            case ESPECIFICO:
                return "Puntaje de tipo: " + getPespecifico().getEspecificoMsj();
            default:
                return "";
        }
    }
    
    public String getPuntajes(){
        switch(this.tipo){
            case GENERAL:
                return funciones.ObtenerPuntajeGeneral();
            case ESPECIFICO:
                String buscar = getPespecifico().getTipo().toLowerCase().replace("\"","");
                String nombreArchivo = getPespecifico().getNombreArchivo();
                String nombreClase = getPespecifico().getNombreClase();
                if(null != buscar)switch (buscar) {
                    case "clases":
                        return funciones.EspecificoClase(nombreArchivo, nombreClase);
                    case "variable":
                        return funciones.EspecificoVariable(nombreArchivo, nombreClase);
                    case "metodo":
                        return funciones.EspecificoMetodo(nombreArchivo, nombreClase);
                    case "comentario":
                        return funciones.EspecificoComentario(nombreArchivo);
                    default:
                        return "";
                }
                
                
                
            default:
                return "NO ENCONTRADO";
           
        }
    }
    

    /**
     * @return the valorg
     */
    public String getValorg() {
        return valorg;
    }

    /**
     * @param valorg the valorg to set
     */
    public void setValorg(String valorg) {
        this.valorg = valorg;
    }

    /**
     * @return the valoresp
     */
    public String getValoresp() {
        return valoresp;
    }

    /**
     * @param valoresp the valoresp to set
     */
    public void setValoresp(String valoresp) {
        this.valoresp = valoresp;
    }
    
    
    
    
}
