/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTjs.Clases;

/**
 *
 * @author Carlos Martinez
 */
public class Comentarios {
    public String Coment;
  
    
    public Comentarios(String Coment){
        this.Coment = Coment;
    }

    /**
     * @return the Coment
     */
    public String getComent() {
        return Coment;
    }

    /**
     * @param Coment the Coment to set
     */
    public void setComent(String Coment) {
        this.Coment = Coment;
    }
    


    public String getComentMsj(){
        return "Se detecto un comentario con el contenido: "+ this.Coment + "\n";
    }
}
