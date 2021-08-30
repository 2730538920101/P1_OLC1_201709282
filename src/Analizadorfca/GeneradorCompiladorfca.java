/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadorfca;

/**
 *
 * @author Carlos Martinez
 */
public class GeneradorCompiladorfca {
    public static void main(String[] args){
        generarCompiladorfca();
    }

    
    public static void generarCompiladorfca() {
        try {
            String ruta = "src/Analizadorfca/";
            String opcFlex[] = {ruta + "Lexicofca.flex", "-d", ruta};
            jflex.Main.generate(opcFlex);
           
            String opcCUP[] = {"-destdir", ruta, "-parser", "Sintacticofca", ruta + "Sintacticofca.cup"};
            java_cup.Main.main(opcCUP);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
