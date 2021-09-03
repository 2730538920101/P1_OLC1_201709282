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
public class PuntajeGeneral {

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
    public String valor;
    public PuntajeGeneral(String valor){
        this.valor = valor;
    }
}
