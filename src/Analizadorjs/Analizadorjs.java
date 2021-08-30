/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadorjs;

import ASTjs.Erroresjs.ListaErroresjs;
import Vista.Principal;
import java.io.BufferedReader;
import java.io.StringReader;

/**
 *
 * @author Carlos Martinez
 */
public class Analizadorjs {
    private static Analizadorjs analizador;
    public static ListaErroresjs errores;
    
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
            //listaAcciones = new ArrayList<>();
        }
        return analizador;
    }

    public void LimpiarInstancia() {
        if (analizador != null) {
            errores.clear();
            //listaAcciones.clear();
        } else {
            System.out.println("No existe un analizador");
        }
    }
    
     public void MostrarEr(){
        errores.mostrarEnConsola();
    }
    
}
