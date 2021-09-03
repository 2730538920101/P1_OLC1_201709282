/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTfca.Instrucciones;

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
    
    
}
