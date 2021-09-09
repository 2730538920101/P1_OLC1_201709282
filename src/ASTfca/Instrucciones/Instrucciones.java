/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTfca.Instrucciones;

import static ASTfca.Instrucciones.TipoDato.PUNTAJE_ESPECIFICO;
import static ASTfca.Instrucciones.TipoDato.PUNTAJE_GENERAL;
import Control.Archivo;
import Control.Funciones;
import Graficas.Barras;
import Graficas.Pie;
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
    public static ArrayList<Puntaje> puntajes = new ArrayList<>();
   
    
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
                                puntajes.add(varlist.get(i).getValorp());
                                var = varlist.get(i).getValorp().getId();
                                valor = varlist.get(i).getValorp().getPuntajes();
                                varlist.get(i).setValor(valor);
                                varlist.get(i).setId(var);
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
                                bar.setTitulo(respuesta);
                                break;
                            
                            case EJEX:
                                String res2 = "";
                                for (int j = 0; j < instb.get(i).getParametro().size(); j++) {
                                    res2 = res2 + instb.get(i).getParametro().get(j).getValorParam() + ";";
                                }
                                String[] respuesta2 = res2.split(";");
                                bar.setEjex(respuesta2);
                                break;
                            
                            case VALORES:
                                String res3 = "";
                                for (int j = 0; j < instb.get(i).getParametro().size(); j++) {
                                    res3 = res3 + instb.get(i).getParametro().get(j).getValorParam() + ";";
                                    if(instb.get(i).getParametro().get(j).getTipo()== PUNTAJE_GENERAL){
                                        Puntaje pun = new Puntaje(TipoPuntaje.GENERAL,"PARAMETRO",instb.get(i).getParametro().get(j).getPgeneral());
                                        puntajes.add(pun);
                                    }
                                    if(instb.get(i).getParametro().get(j).getTipo()== PUNTAJE_ESPECIFICO){
                                        Puntaje pun = new Puntaje(TipoPuntaje.ESPECIFICO,"PARAMETRO",instb.get(i).getParametro().get(j).getPespecifico());
                                        puntajes.add(pun);
                                    }
                                }
                                String[] respuesta3 = res3.split(";");
                                bar.setValores(respuesta3);
                                break;
                                
                            case TITULOX:
                                String res4 = "";
                                for (int j = 0; j < instb.get(i).getParametro().size(); j++) {
                                    res4 = res4 + instb.get(i).getParametro().get(j).getValorParam() + ";";
                                }
                                String[] respuesta4 = res4.split(";");
                                bar.setTituloX(respuesta4);
                                break;
                                
                            case TITULOY:
                                String res5 = "";
                                for (int j = 0; j < instb.get(i).getParametro().size(); j++) {
                                    res5 = res5 + instb.get(i).getParametro().get(j).getValorParam() + ";";
                                }
                                String[] respuesta5 = res5.split(";");
                                bar.setTituloY(respuesta5);
                                break;
                        }
                    }
                    bar.hacerBarras(bar.getTitulo(),bar.getEjex(), bar.getValores(), bar.getTituloX(), bar.getTituloY());
                    break;
                case GRAFICA_PIE:
                    Pie pie = new Pie();
                    for (int i = 0; i < instp.size(); i++) {
                        switch(instp.get(i).getTipo().getTipo()){
                            case TITULO:
                                String res = "";
                                for (int j = 0; j < instp.get(i).getParametro().size(); j++) {
                                    res = res + instp.get(i).getParametro().get(j).getValorParam() + ";";
                                }
                                String[] respuesta = res.split(";");
                                pie.setTitulo(respuesta);
                                break;
                            
                            case EJEX:
                                String res2 = "";
                                for (int j = 0; j < instp.get(i).getParametro().size(); j++) {
                                    res2 = res2 + instp.get(i).getParametro().get(j).getValorParam() + ";";
                                }
                                String[] respuesta2 = res2.split(";");
                                pie.setEjex(respuesta2);
                                break;
                            
                            case VALORES:
                                String res3 = "";
                                for (int j = 0; j < instp.get(i).getParametro().size(); j++) {
                                    res3 = res3 + instp.get(i).getParametro().get(j).getValorParam() + ";";
                                    if(instp.get(i).getParametro().get(j).getTipo()== PUNTAJE_GENERAL){
                                        Puntaje pun = new Puntaje(TipoPuntaje.GENERAL,"PARAMETRO",instp.get(i).getParametro().get(j).getPgeneral());
                                        puntajes.add(pun);
                                    }
                                    if(instp.get(i).getParametro().get(j).getTipo()== PUNTAJE_ESPECIFICO){
                                        Puntaje pun = new Puntaje(TipoPuntaje.ESPECIFICO,"PARAMETRO",instp.get(i).getParametro().get(j).getPespecifico());
                                        puntajes.add(pun);
                                    }
                                }
                                String[] respuesta3 = res3.split(";");
                                pie.setValores(respuesta3);
                                break;
                        }
                    }
                    pie.hacerPie(pie.getTitulo(), pie.getEjex(), pie.getValores());
                    break;
                case GRAFICA_LINEAS:
                    String[] respuesta = new String[1];
                    String[] respuesta2 = new String[1];
                    for (int i = 0; i < instl.size(); i++) {
                        switch(instl.get(i).getTipo().getTipo()){
                            case TITULO:
                                String res = "";
                                for (int j = 0; j < instl.get(i).getParametro().size(); j++) {
                                    res = res + instl.get(i).getParametro().get(j).getValorParam() + ";";
                                }
                                respuesta = res.split(";");

                                break;
                            case ARCHIVO:
                                String res2 = "";
                                for (int j = 0; j < instl.get(i).getParametro().size(); j++) {
                                    res2 = res2 + instl.get(i).getParametro().get(j).getValorParam() + ";";
                                }
                                respuesta2 = res2.split(";");

                                break;
                        }
                    }
                    funciones.hacerLineas(respuesta, respuesta2);
                    break;
                default:
                    break;
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
