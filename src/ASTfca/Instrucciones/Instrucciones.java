/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTfca.Instrucciones;

import Vista.Principal;
import java.util.ArrayList;

/**
 *
 * @author Carlos Martinez
 */
public class Instrucciones{
    public String token;
    public Instruccion tipo;
    public ArrayList<Variable> varlist;
    public ArrayList<InstruccionesBarras> instb;
    public ArrayList<InstruccionesPie> instp;
    public ArrayList<InstruccionesLineas> instl;
    
    public Instrucciones(String token, Instruccion tipo){
        this.token = token;
        this.tipo = tipo;
        this.varlist = varlist;        
    }

    public String setInstruccionMsj(){
        String msj = "";
        switch(this.getTipo()){
            case CARGAR_PROYECTO:
                msj = "Se detecto la instruccion: " + getToken() +"\n";
                System.out.println(msj);
                //FUNCION COMPARE
                return msj;
            case DEFINIR_GLOBALES:
                msj = "Se detecto la instruccion: " + getToken() +"\n";
                System.out.println(msj);
                //FUNCION PARA DEFINIR VARIABLES
                return msj;
            case GRAFICA_BARRAS:
                msj = "Se detecto la instruccion: " + getToken() +"\n";
                System.out.println(msj);
                //FUNCION PARA GRAFICA DE BARRAS
                return msj;
            case GRAFICA_PIE:
                msj = "Se detecto la instruccion: " + getToken() +"\n";
                System.out.println(msj);
                //FUNCION PARA GRAFICA DE PIE
                return msj;
            case GRAFICA_LINEAS:
                msj = "Se detecto la instruccion: " + getToken() +"\n";
                System.out.println(msj);
                //FUNCION PARA GRAFICA DE LINEAS
                return msj;
            default:
                return msj;
        }
        
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
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

    /**
     * @return the varlist
     */
    public ArrayList<Variable> getVarlist() {
        return varlist;
    }

    /**
     * @param varlist the varlist to set
     */
    public void setVarlist(ArrayList<Variable> varlist) {
        this.varlist = varlist;
    }

    /**
     * @return the instb
     */
    public ArrayList<InstruccionesBarras> getInstb() {
        return instb;
    }

    /**
     * @param instb the instb to set
     */
    public void setInstb(ArrayList<InstruccionesBarras> instb) {
        this.instb = instb;
    }

    /**
     * @return the instp
     */
    public ArrayList<InstruccionesPie> getInstp() {
        return instp;
    }

    /**
     * @param instp the instp to set
     */
    public void setInstp(ArrayList<InstruccionesPie> instp) {
        this.instp = instp;
    }

    /**
     * @return the instl
     */
    public ArrayList<InstruccionesLineas> getInstl() {
        return instl;
    }

    /**
     * @param instl the instl to set
     */
    public void setInstl(ArrayList<InstruccionesLineas> instl) {
        this.instl = instl;
    }
}
