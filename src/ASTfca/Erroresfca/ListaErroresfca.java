/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTfca.Erroresfca;

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
public class ListaErroresfca extends ArrayList<MiErrorfca> {

    public ListaErroresfca() {
    super();
    }
    
    public void addError(MiErrorfca error){
        this.add(error);
    }
    
    public void mostrarEnConsola(){
        this.forEach((t) -> {
            Principal.EscribirErrorEnConsola(t.toString());
            System.out.println(t);
        });
    }
    
}

