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
public class Instrucciones {
    public Variable variable;
    public Metodo metodo;
    public Instruccion tipo;
   
    
    public Instrucciones(Instruccion tipo, Variable variable){
        this.tipo = tipo;
        this.variable = variable;
        
    }
    
    public Instrucciones(Instruccion tipo, Metodo metodo){
        this.tipo = tipo;
        this.metodo = metodo;
      
    }

    /**
     * @return the variable
     */
    public Variable getVariable() {
        return variable;
    }

    /**
     * @param variable the variable to set
     */
    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    /**
     * @return the metodo
     */
    public Metodo getMetodo() {
        return metodo;
    }

    /**
     * @param metodo the metodo to set
     */
    public void setMetodo(Metodo metodo) {
        this.metodo = metodo;
    }

    /**
     * @return the tipo
     */
    public Instruccion getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Instruccion tipo) {
        this.tipo = tipo;
    }

    
    public String getInstruccionesMsj(){
        String mensaje = "";
        switch(this.tipo){
            case DECLARACIONVARIABLE:
                mensaje = mensaje + this.variable.getVarMsj() + "\n";
                return mensaje;
            case DECLARACIONMETODO:
                mensaje = mensaje + this.metodo.getMetMsj() + "\n";
                return mensaje;
           
            default:
                return mensaje;
        }
        
    }


}
