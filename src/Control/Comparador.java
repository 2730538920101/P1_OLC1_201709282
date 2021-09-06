/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import ASTjs.Clases.Instrucciones;
import ASTjs.Clases.Clase;
import ASTjs.Clases.Clases;
import ASTjs.Clases.Comentarios;
import ASTjs.Clases.Metodo;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Carlos Martinez
 */
public class Comparador {
    public ArrayList<Archivo> proyecto1;
    public ArrayList<Archivo> proyecto2;
    public int totalCMR;
    public int totalCM;
    public int totalVR;
    public int totalV;
    public int totalMR;
    public int totalM;
    public int totalCLR;
    public int totalCL;
    public double PuntajeGeneral;

    public Comparador(ArrayList<Archivo> proyecto1 , ArrayList<Archivo> proyecto2){
        this.proyecto1 = proyecto1;
        this.proyecto2 = proyecto2;
    }
    /**
     * @return the proyecto1
     */
    public ArrayList<Archivo> getProyecto1() {
        return proyecto1;
    }

    /**
     * @param proyecto1 the proyecto1 to set
     */
    public void setProyecto1(ArrayList<Archivo> proyecto1) {
        this.proyecto1 = proyecto1;
    }

    /**
     * @return the proyecto2
     */
    public ArrayList<Archivo> getProyecto2() {
        return proyecto2;
    }

    /**
     * @param proyecto2 the proyecto2 to set
     */
    public void setProyecto2(ArrayList<Archivo> proyecto2) {
        this.proyecto2 = proyecto2;
    }

    /**
     * @return the totalCMR
     */
    public int getTotalCMR() {
        return totalCMR;
    }

    /**
     * @param totalCMR the totalCMR to set
     */
    public void setTotalCMR() {
        int rep = 0;
        String coment = "";
        String coment2 = "";
       
        for (int i = 0; i <getProyecto1().size(); i++) {
            for (int j = 0; j < getProyecto1().get(i).getResultado().size(); j++) {
                Clases clases1 =  getProyecto1().get(i).getResultado().get(j);
                ArrayList<Comentarios> comlist = clases1.getListaComentarios();
                for (int k = 0; k < comlist.size(); k++) {
                    coment = comlist.get(k).getComent();
                    for (int p = 0; p < getProyecto2().size(); p++) {
                        for (int a = 0; a < getProyecto2().get(p).getResultado().size(); a++) {
                            Clases clases2 = getProyecto2().get(p).getResultado().get(a);
                            ArrayList<Comentarios> comlist2 = clases2.getListaComentarios();
                            for (int l = 0; l < comlist2.size(); l++) {
                                coment2 = comlist2.get(l).getComent();
                                if(coment.equalsIgnoreCase(coment2)){
                                    rep = rep +1;
                                    
                                }
                                
                            }
                            
                        }
                    }
                    
                }
            }
        }
     
        System.out.println("COMENTARIOS REPETIDOS: "+rep);
        this.totalCMR = rep;
    }

    /**
     * @return the totalCM
     */
    public int getTotalCM() {
        return totalCM;
    }

    /**
     * @param totalCM the totalCM to set
     */
    public void setTotalCM() {
        int total = 0;
        for (int i = 0; i < getProyecto1().size(); i++) {
            total = total + getProyecto1().get(i).getTotalComentarios();
            
        }
        for (int i = 0; i < getProyecto2().size(); i++) {
            total = total + getProyecto2().get(i).getTotalComentarios();
        }
        System.out.println("TOTAL DE COMENTARIOS: " + total);
        this.totalCM = total;
    }

    /**
     * @return the totalVR
     */
    public int getTotalVR() {
        return totalVR;
    }

    /**
     * @param totalVR the totalVR to set
     */
    public void setTotalVR() {
        int rep = 0;
        String var1 = "";
        String var2 = "";
      
        for (int i=0; i < getProyecto1().size(); i++) {
            for (int j = 0; j < getProyecto1().get(i).getResultado().size(); j++) {
                Clases clases = getProyecto1().get(i).getResultado().get(j);
                ArrayList<Clase> claselista = clases.getListaClases();
                for (int k = 0; k < claselista.size(); k++) {
                    ArrayList<Instrucciones> ins = claselista.get(k).getInstrucciones();
                    for (int l = 0; l < ins.size(); l++) {
                        if(ins.get(l).getVariable() != null){
                           var1 = ins.get(l).getVariable().getVariable(); 
                            for (int m = 0; m < getProyecto2().size(); m++) {
                                for (int n = 0; n < getProyecto2().get(m).getResultado().size(); n++) {
                                    Clases clases2 = getProyecto2().get(m).getResultado().get(n);
                                    ArrayList<Clase> claselista2 = clases2.getListaClases();
                                    for (int o = 0; o < claselista2.size(); o++) {
                                        ArrayList<Instrucciones> ins2 = claselista2.get(o).getInstrucciones();
                                        for (int p = 0; p < ins2.size(); p++) {
                                            if(ins2.get(p).getVariable() != null){
                                                var2 = ins2.get(p).getVariable().getVariable();
                                                if(var1.equalsIgnoreCase(var2)){
                                                    rep++;
                                                    
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        
                    }
                }
            }
        }
       
        System.out.println("VARIABLES REPETIDAS: "+rep);
        this.totalVR = rep;
    }

    /**
     * @return the totalV
     */
    public int getTotalV() {
        return totalV;
    }

    /**
     * @param totalV the totalV to set
     */
    public void setTotalV() {
        int total = 0;
        for (int i = 0; i < getProyecto1().size(); i++) {
            total = total + getProyecto1().get(i).getTotalVariables();
            
        }
        for (int i = 0; i < getProyecto2().size(); i++) {
            total = total + getProyecto2().get(i).getTotalVariables();
        }
        System.out.println("TOTAL DE VARIABLES: " + total);
        this.totalV = total;
    }

    /**
     * @return the totalMR
     */
    public int getTotalMR() {
        return totalMR;
    }

    /**
     * @param totalMR the totalMR to set
     */
    public void setTotalMR() {
        int rep = 0;
        String met1 = "";
        String met2 = "";
     
        for (int i = 0; i < getProyecto1().size(); i++) {
            for (int j = 0; j < getProyecto1().get(i).getResultado().size(); j++) {
                Clases clases = getProyecto1().get(i).getResultado().get(j);
                ArrayList<Clase> claselista = getProyecto1().get(i).getResultado().get(j).getListaClases();
                for (int k = 0; k < claselista.size(); k++) {
                    ArrayList<Instrucciones> ins =  claselista.get(k).getInstrucciones();
                    for (int l = 0; l < ins.size(); l++) {
                        if(ins.get(l).getMetodo() != null){
                            Metodo metodo = ins.get(l).getMetodo();
                            met1 = metodo.getIdMetodo();
                            for (int m = 0; m < getProyecto2().size(); m++) {
                                for (int n = 0; n < getProyecto2().get(m).getResultado().size(); n++) {
                                    Clases clases2 = getProyecto2().get(m).getResultado().get(n);
                                    ArrayList<Clase> claselista2 = getProyecto2().get(m).getResultado().get(n).getListaClases();
                                    for (int o = 0; o < claselista2.size(); o++) {
                                        ArrayList<Instrucciones> ins2 = claselista2.get(o).getInstrucciones();
                                        for (int p = 0; p < ins2.size(); p++) {
                                            if (ins2.get(p).getMetodo() != null) {
                                                Metodo metodo2 = ins2.get(p).getMetodo();
                                                met2 = metodo2.getIdMetodo();
                                                if(met1.equalsIgnoreCase(met2)){
                                                    rep++;
                                                    
                                                }
                                                
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        
                    }
                }
            }
        }
        
        System.out.println("METODOS REPETIDOS: " + rep);
        this.totalMR = rep;
    }

    /**
     * @return the totalM
     */
    public int getTotalM() {
        return totalM;
    }

    /**
     * @param totalM the totalM to set
     */
    public void setTotalM() {
        int total = 0;
        for (int i = 0; i < getProyecto1().size(); i++) {
            total = total + getProyecto1().get(i).getTotalMetodos();
            
        }
        for (int i = 0; i < getProyecto2().size(); i++) {
            total = total + getProyecto2().get(i).getTotalMetodos();
        }
        System.out.println("TOTAL DE METODOS: " + total);
        this.totalM = total;
    }

    /**
     * @return the totalCLR
     */
    public int getTotalCLR() {
        return totalCLR;
    }

    /**
     * @param totalCLR the totalCLR to set
     */
    public void setTotalCLR() {
        int rep = 0;
        String clase1 = "";
        String clase2 = "";
        
        for (int i = 0; i < getProyecto2().size(); i++) {
            for (int j = 0; j < getProyecto2().get(i).getResultado().size(); j++) {
                for (int k = 0; k < getProyecto2().get(i).getResultado().get(j).getListaClases().size() ; k++) {
                    if(getProyecto2().get(i).getResultado().get(j).getListaClases().get(k) != null){
                        clase1 = getProyecto2().get(i).getResultado().get(j).getListaClases().get(k).getIdClase();
                        for (int l = 0; l < getProyecto2().size(); l++) {
                            for (int m = 0; m < getProyecto2().get(l).getResultado().size(); m++) {
                                for (int n = 0; n < getProyecto2().get(l).getResultado().size(); n++) {
                                    if(getProyecto2().get(l).getResultado().get(m).getListaClases().get(n) != null){
                                        clase2 = getProyecto2().get(l).getResultado().get(m).getListaClases().get(n).getIdClase();
                                        if(clase1.equalsIgnoreCase(clase2)){
                                            rep++;
                                        }
                                    }
                                    
                                }
                            }
                        }
                    }
                    
                }
            }
        }
        System.out.println("CLASES REPETIDAS: "+ rep);
        this.totalCLR = rep;
    }

    /**
     * @return the totalCL
     */
    public int getTotalCL() {
        return totalCL;
    }

    /**
     * @param totalCL the totalCL to set
     */
    public void setTotalCL() {
        int total = 0;
        for (int i = 0; i < getProyecto1().size(); i++) {
            total = total + getProyecto1().get(i).getTotalClases();
            
        }
        for (int i = 0; i < getProyecto2().size(); i++) {
            total = total + getProyecto2().get(i).getTotalClases();
        }
        System.out.println("TOTAL DE CLASES: " + total);
        this.totalCL = total;
    }

    /**
     * @return the PuntajeGeneral
     */
    public double getPuntajeGeneral() {
        return PuntajeGeneral;
    }

    /**
     * @param PuntajeGeneral the PuntajeGeneral to set
     */
    public void setPuntajeGeneral() {
        
        double parte1 = ((((double)getTotalCMR()/(double)getTotalCM())*(0.2))+(((double)getTotalVR()/(double)getTotalV())*(0.2))+(((double)getTotalMR()/(double)getTotalM())*(0.3))+(((double)getTotalCLR()/(double)getTotalCL())*(0.3)));
        System.out.println("PUNTAJE GENERAL: " + parte1);
        DecimalFormat formato = new DecimalFormat("#0.0");
        System.out.println("EL PUNTAJE GENERAL CALCULADO ES: "+formato.format(parte1));
        this.PuntajeGeneral = parte1;
    }
    
    
    
    
}
