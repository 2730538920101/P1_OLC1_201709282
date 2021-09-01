/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTjs.Clases;

import java.util.ArrayList;

/**
 *
 * @author Carlos Martinez
 */
public class ComentList {
    public ArrayList<Comentarios> comentlist;
    
    public ComentList(ArrayList<Comentarios> comentlist){
        this.comentlist = comentlist;
    }
    
    public String getComentMensaje(){
        String mensaje="Lista de comentarios: " + "\n";
        for (int i = 0; i < this.comentlist.size(); i++) {
            if(this.comentlist.get(i) != null){
                mensaje = mensaje + this.comentlist.get(i).getComentMsj();
               
            }
        }
        return mensaje;
    }
}
