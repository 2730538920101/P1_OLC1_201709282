/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTfca.Instrucciones;

import java.util.ArrayList;

/**
 *
 * @author Carlos Martinez
 */
public class InstruccionesBarras {

    /**
     * @return the tipo
     */
    public Carac getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Carac tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the parametro
     */
    public ArrayList<Parametro> getParametro() {
        return parametro;
    }

    /**
     * @param parametro the parametro to set
     */
    public void setParametro(ArrayList<Parametro> parametro) {
        this.parametro = parametro;
    }
    public Carac tipo;
    public ArrayList<Parametro> parametro;
    public InstruccionesBarras(Carac tipo, ArrayList<Parametro> parametro){
        this.tipo = tipo;
        this.parametro = parametro;
    }
    
}
