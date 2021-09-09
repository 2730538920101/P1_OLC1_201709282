/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTjs.Erroresjs;

/**
 *
 * @author Carlos Martinez
 */


import Vista.Principal;
import java.util.ArrayList;

/**
 *
 * @author gm_ye
 */
public class ListaErroresjs extends ArrayList<MiErrorjs> {

    public ListaErroresjs() {
    super();
    }
    
    public void addError(MiErrorjs error){
        this.add(error);
    }
    
    public void mostrarEnConsola(){
        this.forEach((t) -> {
            Principal.EscribirErrorEnConsola(t.toString());
        });
    }
    

    
}

