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
public class Parametro {

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
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
    public String valor;
    public PuntajeEspecifico pespecifico;
    
    public Parametro(String valor){
        this.valor = valor;
    }
    
    public Parametro(PuntajeEspecifico pespecifico){
        this.pespecifico = pespecifico;
    }
    
}
