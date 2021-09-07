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
public class PuntajeEspecifico {
    public String valor;
    public String nombreArchivo;
    public String tipo;
    public String nombreClase;

    public PuntajeEspecifico(String valor, String nombreArchivo, String tipo, String nombreClase){
        this.valor = valor;
        this.nombreArchivo = nombreArchivo;
        this.tipo = tipo;
        this.nombreClase = nombreClase;
    }
    
    public PuntajeEspecifico(String valor, String nombreArchivo, String tipo){
        this.valor = valor;
        this.nombreArchivo = nombreArchivo;
        this.tipo = tipo;
       
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
     * @return the nombreArchivo
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * @param nombreArchivo the nombreArchivo to set
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the nombreClase
     */
    public String getNombreClase() {
        return nombreClase;
    }

    /**
     * @param nombreClase the nombreClase to set
     */
    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }
    
    public String getEspecificoMsj(){
        if(getTipo().equalsIgnoreCase("comentario")){
            return this.valor + "en el archivo: " + getNombreArchivo() + " Valor que desea buscar: " + getTipo() + "\n";
        }else{
            return this.valor + "en el archivo: " + getNombreArchivo() + " Valor que desea buscar: " + getTipo() + " en la clase: " + getNombreClase() + "\n";
        }
        
    }
    
    
}
