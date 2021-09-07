/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import ASTjs.Clases.Clases;
import java.util.ArrayList;

/**
 *
 * @author Carlos Martinez
 */
public class Archivo {
    public String nombre;
    public int totalClases, totalVariables, totalMetodos, totalComentarios;
    public ArrayList<Clases> resultado;

    public Archivo(String nombre, int totalClases, int totalVariables, int totalMetodos, int totalComentarios, ArrayList<Clases> resultado){
        this.nombre = nombre;
        this.totalClases = totalClases;
        this.totalVariables = totalVariables;
        this.totalMetodos = totalMetodos;
        this.totalComentarios = totalComentarios;
        this.resultado = resultado;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the totalClases
     */
    public int getTotalClases() {
        return totalClases;
    }

    /**
     * @param totalClases the totalClases to set
     */
    public void setTotalClases(int totalClases) {
        this.totalClases = totalClases;
    }

    /**
     * @return the totalVariables
     */
    public int getTotalVariables() {
        return totalVariables;
    }

    /**
     * @param totalVariables the totalVariables to set
     */
    public void setTotalVariables(int totalVariables) {
        this.totalVariables = totalVariables;
    }

    /**
     * @return the totalMetpdps
     */
    public int getTotalMetodos() {
        return totalMetodos;
    }

    /**
     * @param totalMetpdps the totalMetpdps to set
     */
    public void setTotalMetodos(int totalMetodos) {
        this.totalMetodos = totalMetodos;
    }

    /**
     * @return the totalComentarios
     */
    public int getTotalComentarios() {
        return totalComentarios;
    }

    /**
     * @param totalComentarios the totalComentarios to set
     */
    public void setTotalComentarios(int totalComentarios) {
        this.totalComentarios = totalComentarios;
    }

    /**
     * @return the resultado
     */
    public ArrayList<Clases> getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(ArrayList<Clases> resultado) {
        this.resultado = resultado;
    }
    
    
    
}
