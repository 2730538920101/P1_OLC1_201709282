/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadorjs;
import ASTjs.Clases.Clases;
import ASTjs.Erroresjs.ListaErroresjs;
import Vista.Principal;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;

/**
 *
 * @author Carlos Martinez
 */
public class Analizadorjs {
    private static Analizadorjs analizador;
    public static ListaErroresjs errores;
    public static ArrayList<Clases> clases;
    public  boolean AnalizarCodigo(String entrada) {
        try {
            Sintacticojs sin = new Sintacticojs(
                    new Lexicojs(new BufferedReader(new StringReader(entrada))));
            //analizando
            sin.parse();
            System.out.println("NO HAY ERRORES");
            Principal.EscribirErrorEnConsola("CODIGO ANALIZADO EXITOSAMENTE");
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }

        if (Analizadorjs.errores.size() > 0) {
            return false;
        }
        return true;
    }
     
     public static Analizadorjs getInstancia() {
        if (analizador == null) {
            analizador = new Analizadorjs();
            errores = new ListaErroresjs();
            setClases(new ArrayList<>());
        }
        return analizador;
    }

    public static void LimpiarInstancia() {
        if (analizador != null) {
            errores.clear();
            getClases().clear();
        } else {
            System.out.println("No existe un analizador");
        }
    }
    
    public void MostrarEr(){
        errores.mostrarEnConsola();
    }

    /**
     * @return the clases
     */
    public static ArrayList<Clases> getClases() {
        return clases;
    }

    /**
     * @param aClases the clases to set
     */
    public static void setClases(ArrayList<Clases> aClases) {
        clases = aClases;
    }
     
     
    
}
