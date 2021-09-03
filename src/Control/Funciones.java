/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

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
    String[] nombreArchivos1;
    String[] nombreArchivos2;
   
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
    
    public String LeerArchivo(String archivo)throws IOException{
        String mensaje = "";
        try{
            File arch1 = new File(archivo);
            FileReader fr = new FileReader (arch1);
            BufferedReader br = new BufferedReader(fr);
             while (br.ready()) {
                 mensaje = mensaje + br.readLine();
             }
            
        }catch(Exception e){
            System.out.println(e);
        }
        return mensaje;
    }
    
    public void setArchivos(String ruta1, String ruta2){
        File dir1 = new File(ruta1);
        File dir2 = new File(ruta2);
        if(dir1.isDirectory()&& dir2.isDirectory()){
            this.nombreArchivos1 = dir1.list();
            this.nombreArchivos2 = dir2.list();
        }
        
    }
    
    public String[] getArchivo1(){
        return this.nombreArchivos1;
    }
    
    public String[] getArchivo2(){
        return this.nombreArchivos2;
    }
    
    public void hacerPie(String titulo, String[] ejex, Double[] valores) throws IOException{
        DefaultPieDataset dataset = new DefaultPieDataset( );
        for (int i = 0; i < valores.length; i++) {
            dataset.setValue(ejex[i],valores[i]);
        }
        JFreeChart chart = ChartFactory.createPieChart(
         titulo,   // chart title
         dataset,          // data
         true,             // include legend
         true,
         false);
         
        int width = 640;   /* Width of the image */
        int height = 480;  /* Height of the image */ 
        File pieChart = new File( "PieChart.jpeg" ); 
        ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
        
    }
    
    public void hacerBarras(String titulo, String[] ejex, Double[] valores, String Titulox, String Tituloy) throws IOException{
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        for (int i = 0; i < valores.length; i++) {
            dataset.addValue(valores[i],"Porcentaje de copia", ejex[i]);
        }
        JFreeChart barChart = ChartFactory.createBarChart(
         titulo, 
         Titulox, Tituloy, 
         dataset,PlotOrientation.VERTICAL, 
         true, true, false);
         
        int width = 640;    /* Width of the image */
        int height = 480;   /* Height of the image */ 
        File BarChart = new File( "BarChart.jpeg" ); 
        ChartUtilities.saveChartAsJPEG( BarChart , barChart , width , height );
    }
    
    public void hacerLineas(String titulo, String[] ejex, Double[] valores, String Titulox, String Tituloy) throws IOException{
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        for (int i = 0; i < valores.length; i++) {
            dataset.addValue(valores[i],"Porcentaje de copia", ejex[i]);
        }
        JFreeChart barChart = ChartFactory.createBarChart(
         titulo, 
         Titulox, Tituloy, 
         dataset,PlotOrientation.VERTICAL, 
         true, true, false);
         
        int width = 640;    /* Width of the image */
        int height = 480;   /* Height of the image */ 
        File BarChart = new File( "BarChart.jpeg" ); 
        ChartUtilities.saveChartAsJPEG( BarChart , barChart , width , height );
    }
    
    
}
