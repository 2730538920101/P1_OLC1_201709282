/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadorfca;

import ASTfca.Erroresfca.ListaErroresfca;
import ASTfca.Simbolos.TablaSimbolosfca;
import Vista.Principal;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
/**
 *
 * @author Carlos Martinez
 */
public class Analizadorfca {
    private static Analizadorfca analizador;
    public static ListaErroresfca errores;
    
    private Analizadorfca(){
        
    }
    public boolean AnalizarCodigo(String entrada) {
        try {
            Sintacticofca sin = new Sintacticofca(
                    new Lexicofca(new BufferedReader(new StringReader(entrada))));
            //analizando
            sin.parse();
            System.out.println("NO HAY ERRORES");
            Principal.EscribirErrorEnConsola("CODIGO ANALIZADO EXITOSAMENTE");
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }

        if (Analizadorfca.errores.size() > 0) {
            
            return false;
        }
        return true;
    }
     
    public static Analizadorfca getInstancia() {
        if (analizador == null) {
            analizador = new Analizadorfca();
            errores = new ListaErroresfca();

        }
        return analizador;
    }

    public void LimpiarInstancia() {
        if (analizador != null) {
            errores.clear();
        } else {
            System.out.println("No existe un analizador");
        }
    }
    
    public void MostrarEr(){
        errores.mostrarEnConsola();
    }

}
