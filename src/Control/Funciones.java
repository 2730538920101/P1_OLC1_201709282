/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Martinez
 */
public class Funciones {
    //VARIABLES GLOBALES
    JFileChooser seleccionar;
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;
    
    
    public Funciones(){
        seleccionar = new JFileChooser();
    }
    
    //METODO PARA ABRIR ARCHIVO
    public String AbrirArchivo(File archivo){
        
        String documento = "";
        if(seleccionar.showDialog(null, "Abrir")== JFileChooser.APPROVE_OPTION){
            archivo = seleccionar.getSelectedFile();
            if(archivo.canRead()){
                if(archivo.getName().endsWith("fca")){
                    
                    try{
                        entrada = new FileInputStream(archivo);
                        int ascci;
                        while((ascci = entrada.read())!=-1){
                            char caracter = (char)ascci;
                            documento+=caracter;
                        }
                        entrada.close();
                    }catch(Exception e){
                       documento += "EL DOCUMENTO NO PUDO ABRIRSE";
                    }
                }
            }else{
                documento += "EL DOCUMENTO NO PUDO ABRIRSE";
            }
        }
        return documento;
    }
    
    
    //METODO PARA GUARDAR COMO ARCHIVO
    public String GuardarArchivo(String documento){
        String mensaje = "";
        try{
            if(seleccionar.showDialog(null, "Guardar")== JFileChooser.APPROVE_OPTION){

                archivo = seleccionar.getSelectedFile();
                
                if(archivo.getName().endsWith("fca")){
                    salida = new FileOutputStream(archivo);
                    byte[] bytxt = documento.getBytes();
                    salida.write(bytxt);
                    mensaje += "ARCHIVO GUARDADO";
                    salida.close();
                }else{
                    mensaje += "EL ARCHIVO NO ES COMPATIBLE";
                }
            }    
                 
        }catch(Exception e){
            mensaje += "NO SE PUDO GUARDAR EL DOCUMENTO";
        }
        return mensaje;
    }
    
    //METODO PARA GUARDAR ARCHIVO 
    public String SaveDoc(String documento){
        String mensaje = "";
        try{
            archivo = seleccionar.getSelectedFile();
            if(archivo == null){
                String nombre = JOptionPane.showInputDialog(null, "INGRESA EL NOMBRE DEL ARCHIVO");
                archivo = new File("C:\\Users\\Carlos Martinez\\Desktop\\P1_OLC1_201709282\\src",nombre.trim()+".fca");
                archivo.createNewFile();
                seleccionar.setSelectedFile(archivo);
                mensaje += "EL ARCHIVO HA SIDO GUARDADO EXITOSAMENTE EN EL SRC";
               
            }else{
                if(archivo.getName().endsWith("fca")){
                    salida = new FileOutputStream(archivo);
                    byte[] bytxt = documento.getBytes();
                    salida.write(bytxt);
                    mensaje += "ARCHIVO GUARDADO";
                    salida.close();
                }else{
                    mensaje += "EL ARCHIVO NO ES COMPATIBLE";
                }   
            }
            
            
        }catch(Exception e){
            mensaje += "NO SE PUDO GUARDAR EL DOCUMENTO";
        }
        return mensaje;
    }
    
    
}
