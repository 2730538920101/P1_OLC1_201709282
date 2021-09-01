/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTfca.Instrucciones;

import Vista.Principal;

/**
 *
 * @author Carlos Martinez
 */
public class Instrucciones{
    String token;
    Instruccion tipo;
    public Instrucciones(String token, Instruccion tipo){
        this.token = token;
        this.tipo = tipo;
        
    }

    public String setInstruccionMsj(){
        String msj = "";
        switch(this.tipo){
            case CARGAR_PROYECTO:
                msj = "Se detecto la instruccion: " + token +"\n";
                System.out.println(msj);
                //FUNCION COMPARE
                return msj;
            case DEFINIR_GLOBALES:
                msj = "Se detecto la instruccion: " + token +"\n";
                System.out.println(msj);
                //FUNCION PARA DEFINIR VARIABLES
                return msj;
            case GRAFICA_BARRAS:
                msj = "Se detecto la instruccion: " + token +"\n";
                System.out.println(msj);
                //FUNCION PARA GRAFICA DE BARRAS
                return msj;
            case GRAFICA_PIE:
                msj = "Se detecto la instruccion: " + token +"\n";
                System.out.println(msj);
                //FUNCION PARA GRAFICA DE PIE
                return msj;
            case GRAFICA_LINEAS:
                msj = "Se detecto la instruccion: " + token +"\n";
                System.out.println(msj);
                //FUNCION PARA GRAFICA DE LINEAS
                return msj;
            default:
                return msj;
        }
        
    }
}
