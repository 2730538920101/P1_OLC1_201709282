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
public class Clases{
    public ArrayList<Clase> listaClases;
    public ArrayList<Comentarios> listaComentarios;

    public Clases(){
        
    }
    public Clases(ArrayList<Clase> listaClases, ArrayList<Comentarios> listaComentarios){
        this.listaClases = listaClases;
        this.listaComentarios = listaComentarios;
    }


    /**
     * @return the listaClases
     */
    public ArrayList<Clase> getListaClases() {
        return listaClases;
    }

    /**
     * @param listaClases the listaClases to set
     */
    public void setListaClases(ArrayList<Clase> listaClases) {
        this.listaClases = listaClases;
    }

   
     /**
     * @return the listaComentarios
     */
    public ArrayList<Comentarios> getListaComentarios() {
        return listaComentarios;
    }

    /**
     * @param listaComentarios the listaComentarios to set
     */
    public void setListaComentarios(ArrayList<Comentarios> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }
    public void agregarComentario(Comentarios coment){
        this.listaComentarios.add(coment);
    }
    
    public void agregarClase(Clase clase){
        this.listaClases.add(clase);
    }
    
    public String getClasesMsj(){
        String mensaje ="";
        for (int i = 0; i < this.listaClases.size(); i++) {
            mensaje = mensaje + this.listaClases.get(i).getClasesMsj();
        }
        return mensaje;
    }
     public String getComentariosMsj(){
        String mensaje ="";
        for (int i = 0; i < this.listaComentarios.size(); i++) {
            mensaje = mensaje + this.listaComentarios.get(i).getComentMsj();
        }
        return mensaje;
    }
    
    public String getTotalMsj(){
        return "\nCOMENZANDO ANALISIS DE CLASES " +"\n"+ getClasesMsj() + "\n"+
                "Y la lista de comentarios es :\n" + getComentariosMsj();
    }
    
}
