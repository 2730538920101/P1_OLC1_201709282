/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTjs.Erroresjs;



/**
 *
 * @author Carlos Martinez
 */
public class MiErrorjs {
    public MiErrorjs(int linea, int columna, TipoErrorjs tipo, String mensaje, String valor) {
        this.linea = linea+1;
        this.columna = columna+1;
        this.tipo = tipo;
        this.mensaje = mensaje;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Error "+this.tipo.toString().toLowerCase()+": "+this.mensaje+" en línea "+this.linea+" y columna "+this.columna;
    }
    
    public String generarEtiqueta(String nombreArchivo){
        String resultado = "";
        resultado = resultado + "<tr>\n";
        resultado = resultado + "<td>"+valor+"</td>\n";
        resultado = resultado + "<td>"+String.valueOf(tipo)+"</td>\n";
        resultado = resultado + "<td>"+String.valueOf(linea)+"</td>\n";
        resultado = resultado + "<td>"+String.valueOf(columna)+"</td>\n";
        resultado = resultado + "<td>"+nombreArchivo+"</td>\n";
        resultado = resultado + "</tr>\n";
        return resultado;
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
    public TipoErrorjs getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoErrorjs tipo) {
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
    private TipoErrorjs tipo; 
    private String mensaje; 
    public String valor;

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
}
