/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTfca.Instrucciones;

/**
 *
 * @author Carlos Martinez
 */
public class Compare {
    public String ruta1;
    public String ruta2;
   
    public Compare(String ruta1, String ruta2){
        this.ruta1 = ruta1;
        this.ruta2 = ruta2;
    }

    Compare() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the ruta1
     */
    public String getRuta1() {
        return ruta1;
    }

    /**
     * @param ruta1 the ruta1 to set
     */
    public void setRuta1(String ruta1) {
        this.ruta1 = ruta1;
    }

    /**
     * @return the ruta2
     */
    public String getRuta2() {
        return ruta2;
    }

    /**
     * @param ruta2 the ruta2 to set
     */
    public void setRuta2(String ruta2) {
        this.ruta2 = ruta2;
    }
    
    public String getCompararMsj(){
        return "Comparar ruta: " + getRuta1() + " con la ruta: " + getRuta2() + "\n";
    }
}
