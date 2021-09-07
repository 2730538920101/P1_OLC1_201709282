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
public class Carac {

    /**
     * @return the tipo
     */
    public Caracteristicas getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Caracteristicas tipo) {
        this.tipo = tipo;
    }
    public Caracteristicas tipo;
    public Carac(Caracteristicas tipo){
        this.tipo = tipo;
    }
    
    public String getCaracteristicasMsj(){
        switch(getTipo()){
            case TITULO:
                return "Titulo";
            case EJEX:
                return "Ejex";
            case VALORES:
                return "Valores";
            case ARCHIVO:
                return "Archivo";
            case TITULOX:
                return "TituloX";
            case TITULOY:
                return "TituloY";
            default:
                return "";
        }   
    }
}
