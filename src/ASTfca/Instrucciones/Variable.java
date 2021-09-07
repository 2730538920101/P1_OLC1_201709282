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
public class Variable {

    /**
     * @return the tipo
     */
    public TipoVariable getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoVariable tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
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
     * @return the valorp
     */
    public Puntaje getValorp() {
        return valorp;
    }

    /**
     * @param valorp the valorp to set
     */
    public void setValorp(Puntaje valorp) {
        this.valorp = valorp;
    }
    public TipoVariable tipo;
    public String id;
    public String valor;
    public Puntaje valorp;
    
    
    public Variable(TipoVariable tipo, String id, String valor){
        this.tipo = tipo;
        this.id = id;
        this.valor = valor;
    }
    public Variable(TipoVariable tipo, Puntaje valorp){
        this.tipo = tipo;
        this.valorp = valorp;
    }
    
    public String getVarMsj(){
        switch(this.tipo){
            case STRING:
                return "Tipo String: " + this.getValor()+ " con el identificador: " + getId() + "\n";
            case DOUBLE:
                return "Tipo double: " + this.getValor()+ " con el identificador: " + getId() + "\n";
            case PUNTAJE:
                return getValorp().getPuntajesMsj();
            default:
                return "";
        }
    }
}
