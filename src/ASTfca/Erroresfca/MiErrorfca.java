/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTfca.Erroresfca;

/**
 *
 * @author Carlos Martinez
 */
public class MiErrorfca {
    public MiErrorfca(int linea, int columna, TipoErrorfca tipo, String mensaje) {
        this.linea = linea+1;
        this.columna = columna+1;
        this.tipo = tipo;
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Error "+this.tipo.toString().toLowerCase()+": "+this.mensaje+" en línea "+this.linea+" y columna "+this.columna;
    }
    
    

    
    /**
     * @return the linea
     */
    public int getLinea() {
        return linea;
    }

    /**
     * @param linea the linea to set
     */
    public void setLinea(int linea) {
        this.linea = linea;
    }

    /**
     * @return the columna
     */
    public int getColumna() {
        return columna;
    }

    /**
     * @param columna the columna to set
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * @return the tipo
     */
    public TipoErrorfca getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoErrorfca tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    private int linea; 
    private int columna; 
    private TipoErrorfca tipo; 
    private String mensaje; 
}
