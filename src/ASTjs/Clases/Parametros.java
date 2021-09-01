/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTjs.Clases;

/**
 *
 * @author Carlos Martinez
 */
public class Parametros {
    
    public String valor;
 
    public Parametros(String valor){
        this.valor = valor;
    }

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
     * @return the cantidad
     */
   
    
    public String getParamsMsj(){
        return "Se detecto el parametro: " + this.valor + "\n";
    }
}
