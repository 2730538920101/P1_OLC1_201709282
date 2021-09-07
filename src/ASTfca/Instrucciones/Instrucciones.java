/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTfca.Instrucciones;

import Control.Archivo;
import Control.Funciones;
import Graficas.Barras;
import Vista.Principal;
import java.util.ArrayList;

/**
 *
 * @author Carlos Martinez
 */
public class Instrucciones{
    public String token;
    public Instruccion tipo;

    public Compare comparar;
    public Funciones funciones = Principal.func;
    public ArrayList<Archivo> archivo1;
    public ArrayList<Archivo> archivo2;
    public static ArrayList<Variable> varlist;
    ArrayList<InstruccionesBarras> instb;
    ArrayList<InstruccionesPie> instp;
    ArrayList<InstruccionesLineas> instl;
    public Instrucciones(String token, Instruccion tipo){
        this.token = token;
        this.tipo = tipo;        
    }

    public String setInstruccionMsj(){
        String msj = "";
        switch(this.getTipo()){
            case CARGAR_PROYECTO:
                msj = "Se detecto la instruccion: " + getToken() +"\n" + getComparar().getCompararMsj();
                System.out.println(msj);
                //FUNCION COMPARE
                return msj;
            case DEFINIR_GLOBALES:
                msj = "Se detecto la instruccion: " + getToken() +"\n" + getMensajeVars();
                System.out.println(msj);
                //FUNCION PARA DEFINIR VARIABLES
                return msj;
            case GRAFICA_BARRAS:
                msj = "Se detecto la instruccion: " + getToken() +"\n" + getMensajeBars();
                System.out.println(msj);
                //FUNCION PARA GRAFICA DE BARRAS
                return msj;
            case GRAFICA_PIE:
                msj = "Se detecto la instruccion: " + getToken() +"\n" + getMensajePies();
                System.out.println(msj);
                //FUNCION PARA GRAFICA DE PIE
                return msj;
            case GRAFICA_LINEAS:
                msj = "Se detecto la instruccion: " + getToken() +"\n" + getMensajeLines();
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

    /**
     * @return the comparar
     */
    public Compare getComparar() {
        return comparar;
    }

    /**
     * @param comparar the comparar to set
     */
    public void setComparar(Compare comparar) {
        this.comparar = comparar;
    }
    

    
    public String getMensajeVars(){
        String mensaje = "";
        for (int i = 0; i < getVarlist().size(); i++) {
            mensaje = mensaje + "Variable reconocida: \n" + this.varlist.get(i).getVarMsj();
        }
        return mensaje;
    }
    
    public String getMensajeBars(){
        String mensaje = "";
        for (int i = 0; i < getInstb().size(); i++) {
            mensaje = mensaje + "Instruccion de grafica de barras reconocida: \n" + getInstb().get(i).getInsBarrasMsj();
        }
        return mensaje;
    }
    
    public String getMensajePies(){
        String mensaje = "";
        for (int i = 0; i < getInstp().size(); i++) {
            mensaje = mensaje + "Instruccion de grafica de pie reconocida: \n" + getInstp().get(i).getInsPieMsj();
        }
        return mensaje;
    }
    
    public String getMensajeLines(){
        String mensaje = "";
        for (int i = 0; i < getInstl().size(); i++) {
            mensaje = mensaje + "Instruccion de grafica de lineas reconocida: \n" + getInstl().get(i).getInsLineasMsj();
        }
        return mensaje;
    }
    
    public void Accion(){
        try{
            
            switch(getTipo()){
                case CARGAR_PROYECTO:
                    String ruta1 = this.comparar.getRuta1();
                    String ruta2 = this.comparar.getRuta2();
                    funciones.Compare(ruta1,ruta2);
                    archivo1 = funciones.getProyecto1();
                    archivo2 = funciones.getProyecto2();
                    funciones.GenerarComparador();
                    break;
                case DEFINIR_GLOBALES:
                    
                    for (int i = 0; i < varlist.size(); i++) {
                        
                        String var = "";
                        String valor = "";
                        switch(varlist.get(i).getTipo()){
                               
                            case PUNTAJE:
                                var = varlist.get(i).getValorp().getId();
                                valor = varlist.get(i).getValorp().getPuntajes();
                                varlist.get(i).setValor(valor);
                                break;
                        }
                        
                        
                    }
                    break;
                case GRAFICA_BARRAS:
                    Barras bar = new Barras();
                    for (int i = 0; i < instb.size(); i++) {
                        switch(instb.get(i).getTipo().getTipo()){
                            case TITULO:
                                String res = "";
                                for (int j = 0; j < instb.get(i).getParametro().size(); j++) {
                                    res = res + instb.get(i).getParametro().get(j).getValorParam() + ";";
                                }
                                String[] respuesta = res.split(";");
                                for (int j = 0; j < respuesta.length; j++) {
                                    System.out.println("res: " + respuesta[j]);
                                }
                                bar.setTitulo(respuesta);
                                break;
                            
                            case EJEX:
                                String res2 = "";
                                for (int j = 0; j < instb.get(i).getParametro().size(); j++) {
                                    res2 = res2 + instb.get(i).getParametro().get(j).getValorParam() + ";";
                                }
                                String[] respuesta2 = res2.split(";");
                                for (int j = 0; j < respuesta2.length; j++) {
                                    System.out.println("res: " + respuesta2[j]);
                                }
                                break;
                            
                            case VALORES:
                                String res3 = "";
                                for (int j = 0; j < instb.get(i).getParametro().size(); j++) {
                                    res3 = res3 + instb.get(i).getParametro().get(j).getValorParam() + ";";
                                }
                                String[] respuesta3 = res3.split(";");
                                for (int j = 0; j < respuesta3.length; j++) {
                                    System.out.println("res: " + respuesta3[j]);
                                }
                                break;
                                
                            case TITULOX:
                                String res4 = "";
                                for (int j = 0; j < instb.get(i).getParametro().size(); j++) {
                                    res4 = res4 + instb.get(i).getParametro().get(j).getValorParam() + ";";
                                }
                                String[] respuesta4 = res4.split(";");
                                for (int j = 0; j < respuesta4.length; j++) {
                                    System.out.println("res: " + respuesta4[j]);
                                }
                                break;
                                
                            case TITULOY:
                                String res5 = "";
                                for (int j = 0; j < instb.get(i).getParametro().size(); j++) {
                                    res5 = res5 + instb.get(i).getParametro().get(j).getValorParam() + ";";
                                }
                                String[] respuesta5 = res5.split(";");
                                for (int j = 0; j < respuesta5.length; j++) {
                                    System.out.println("res: " + respuesta5[j]);
                                }
                                break;
                        }
                    }
                    break;
                case GRAFICA_PIE:
                    for (int i = 0; i < instp.size(); i++) {
                        switch(instp.get(i).getTipo().getTipo()){
                            case TITULO:
                                String res = "";
                                for (int j = 0; j < instp.get(i).getParametro().size(); j++) {
                                    res = res + instp.get(i).getParametro().get(j).getValorParam() + ";";
                                }
                                String[] respuesta = res.split(";");
                                for (int j = 0; j < respuesta.length; j++) {
                                    System.out.println("res: " + respuesta[j]);
                                }
                                break;
                            
                            case EJEX:
                                String res2 = "";
                                for (int j = 0; j < instp.get(i).getParametro().size(); j++) {
                                    res2 = res2 + instp.get(i).getParametro().get(j).getValorParam() + ";";
                                }
                                String[] respuesta2 = res2.split(";");
                                for (int j = 0; j < respuesta2.length; j++) {
                                    System.out.println("res: " + respuesta2[j]);
                                }
                                break;
                            
                            case VALORES:
                                String res3 = "";
                                for (int j = 0; j < instp.get(i).getParametro().size(); j++) {
                                    res3 = res3 + instp.get(i).getParametro().get(j).getValorParam() + ";";
                                }
                                String[] respuesta3 = res3.split(";");
                                for (int j = 0; j < respuesta3.length; j++) {
                                    System.out.println("res: " + respuesta3[j]);
                                }
                                break;
                        }
                    }
                    break;
                case GRAFICA_LINEAS:
                    for (int i = 0; i < instl.size(); i++) {
                        switch(instl.get(i).getTipo().getTipo()){
                            case TITULO:
                                String res = "";
                                for (int j = 0; j < instl.get(i).getParametro().size(); j++) {
                                    res = res + instl.get(i).getParametro().get(j).getValorParam() + ";";
                                }
                                String[] respuesta = res.split(";");
                                for (int j = 0; j < respuesta.length; j++) {
                                    System.out.println("res: " + respuesta[j]);
                                }
                                break;
                            case ARCHIVO:
                                String res2 = "";
                                for (int j = 0; j < instl.get(i).getParametro().size(); j++) {
                                    res2 = res2 + instl.get(i).getParametro().get(j).getValorParam() + ";";
                                }
                                String[] respuesta2 = res2.split(";");
                                for (int j = 0; j < respuesta2.length; j++) {
                                    System.out.println("res: " + respuesta2[j]);
                                }
                                break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
