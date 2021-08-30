/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadorjs;

/**
 *
 * @author Carlos Martinez
 */
public class GeneradorCompiladorjs {
    public static void main(String[] args){
        generarCompiladorjs();
    }

    
    public static void generarCompiladorjs() {
        try {
            String ruta = "src/Analizadorjs/";
            String opcFlex[] = {ruta + "Lexicojs.flex", "-d", ruta};
            jflex.Main.generate(opcFlex);
           
            String opcCUP[] = {"-destdir", ruta, "-parser", "Sintacticojs", ruta + "Sintacticojs.cup"};
            java_cup.Main.main(opcCUP);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
