/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTfca.Instrucciones;




import Control.Funciones;
import Vista.Principal;
import java.util.ArrayList;

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
    public TipoDato tipo;
    public PuntajeGeneral pgeneral;
    public Funciones funciones = Principal.func;
    public Parametro(TipoDato tipo, String valor){
        this.tipo = tipo;
        this.valor = valor;
    }
    
    public Parametro(TipoDato tipo, PuntajeEspecifico pespecifico){
        this.tipo = tipo;
        this.pespecifico = pespecifico;
    }
    public Parametro(TipoDato tipo, PuntajeGeneral pgeneral){
        this.tipo = tipo;
        this.pgeneral = pgeneral;
    }
    public String getParamMsj(){
        switch(getTipo()){
            case IDENTIFICADOR:
                return "Parametro tipo: " + getTipo() + " valor: " + getValor() + "\n";
            case DECIMAL:
                return "Parametro tipo: " + getTipo() + " valor: " + getValor() + "\n";
            case CADENA:
                return "Parametro tipo: " + getTipo() + " valor: " + getValor() + "\n";
            case PUNTAJE_ESPECIFICO:
                return "Parametro tipo: " + getTipo() +" "+ getPespecifico().getEspecificoMsj();
            case PUNTAJE_GENERAL:
                return "Parametro tipo: " + getTipo() +" "+ getPgeneral().getGeneralMsj();
            default:
                return "";
        }
    }
    public ArrayList<Variable> varlist = Instrucciones.varlist;
    public String getValorParam(){
        switch(getTipo()){
            case IDENTIFICADOR:
                for (int i = 0; i < varlist.size(); i++) {
                    if(getValor().equalsIgnoreCase(varlist.get(i).getId())){
                        setValor(varlist.get(i).getValor().replace("\"", ""));   
                    }
                }
                return getValor();
            case DECIMAL:
                return getValor();
            case CADENA:
                return getValor().replace("\"", "");
            case PUNTAJE_ESPECIFICO:
                Puntaje punt = new Puntaje(TipoPuntaje.ESPECIFICO, getPespecifico());
                setValor(punt.getPuntajes());
                return getValor();
            case PUNTAJE_GENERAL:
                Puntaje punt2 = new Puntaje(TipoPuntaje.GENERAL, getPgeneral());
                setValor(punt2.getPuntajes());
                return getValor();
            default:
                return "";
        }
    }

    /**
     * @return the tipo
     */
    public TipoDato getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoDato tipo) {
        this.tipo = tipo;
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
    
    
}
