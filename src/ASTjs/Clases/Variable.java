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
public class Variable{
   String IdVar;
 
   public Variable(String IdVar){
       this.IdVar = IdVar;
   }
   
   public String getVariable(){
       return this.IdVar;
   }
   
   
    public String getVarMsj(){
       return "Se ha detectado la variable: " + this.IdVar;
   }

}
