/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import ASTjs.Clases.Clases;
import ASTjs.Clases.Comentarios;
import static ASTjs.Clases.Instruccion.DECLARACIONVARIABLE;
import Analizadorjs.Analizadorjs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
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
    public String[] nombreArchivos1;
    public String[] nombreArchivos2;
    public ArrayList<Archivo> proyecto1 = new ArrayList<>();
    public ArrayList<Archivo> proyecto2 = new ArrayList<>();;
    Comparador comp;
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
    
    public void GenerarComparador(){
        comp = new Comparador(getProyecto1(),getProyecto2());
        comp.setTotalCMR();
        comp.setTotalCM();
        comp.setTotalVR();
        comp.setTotalV();
        comp.setTotalMR();
        comp.setTotalM();
        comp.setTotalCLR();
        comp.setTotalCL();
        comp.setPuntajeGeneral();
        
    }
    
    public void Compare(String ruta1, String ruta2) throws IOException{
        ruta1 = ruta1.replace("\"", "");
        ruta2 = ruta2.replace("\"", "");
        Analizadorjs analizador;
        analizador = Analizadorjs.getInstancia();
        Analizadorjs.LimpiarInstancia();
        System.out.println("COMPARE: " + ruta1 + " y " + ruta2);
        File dir1 = new File(ruta1);
        File dir2 = new File(ruta2);
        if(dir1.isDirectory()&& dir2.isDirectory()){
            System.out.println("ENCONTRO LOS DIRECTORIOS");
            setNombreArchivos1(dir1.list());
            setNombreArchivos2(dir2.list());
        }else{
            System.out.println("DIRECTORIOS NO ENCONTRADOS");
        }
        
        for (int i = 0; i < this.getNombreArchivos1().length; i++) {
            if(getArchivo1()[i].endsWith("js")){
                System.out.println("Archivo encontrado en el proyecto 1: " + getArchivo1()[i]);
                String mensaje = "";
                try{
                    File arch1 = new File("C:\\Users\\Carlos Martinez\\Desktop\\prueba\\"+getArchivo1()[i]);
                    FileReader fr = new FileReader (arch1);
                    BufferedReader br = new BufferedReader(fr);
                    while (br.ready()) {
                        mensaje = mensaje + br.readLine() +"\n";
                    }
                    mensaje = mensaje + "\n";

                }catch(Exception e){
                    System.out.println(e);
                }
                
                //System.out.println("CONTENIDO ARCHIVO " + getArchivo1()[i] + "\n" + mensaje);
                analizador.AnalizarCodigo(mensaje);
                analizador.MostrarEr();
                ArrayList<Clases> clases = analizador.getClases();
                String nombreArchivo = getArchivo1()[i];
                int totalClases = 0;
                int totalVariables = 0;
                int totalMetodos = 0;
                int totalComentarios = 0;
                //System.out.println("CAPACIDAD: " + clases.size());
                for (int j = 0; j < clases.size(); j++) {
                    for (int k = 0; k < clases.get(j).getListaClases().size(); k++) {
                        totalClases = totalClases + clases.get(j).getListaClases().size();
                        totalComentarios = totalComentarios + clases.get(j).getListaComentarios().size();
                        for (int l = 0; l < clases.get(j).getListaClases().size(); l++) {
                            totalVariables = totalVariables + clases.get(j).getListaClases().get(l).getCantidadVariables();
                            totalMetodos = totalMetodos + clases.get(j).getListaClases().get(l).getCantidadMetodos();
                        }
                    }
                    
                    
                }
                Archivo respuesta1 = new Archivo(nombreArchivo,totalClases,totalVariables,totalMetodos,totalComentarios, clases);
                this.proyecto1.add(respuesta1);
            }
            
        }
        for (int i = 0; i < this.getNombreArchivos2().length; i++) {    
            if(getArchivo2()[i].endsWith("js")){
                System.out.println("Archivo encontrado en el proyecto 2: " + getArchivo2()[i]); 
                String mensaje = "";
                try{
                    File arch2 = new File("C:\\Users\\Carlos Martinez\\Desktop\\prueba2\\"+getArchivo2()[i]);
                    FileReader fr2 = new FileReader (arch2);
                    BufferedReader br2 = new BufferedReader(fr2);
                    while (br2.ready()) {
                        mensaje = mensaje + br2.readLine() + "\n";
                    }
                    mensaje = mensaje + "\n";

                }catch(Exception e){
                    System.out.println(e);
                }
                
                //System.out.println("CONTENIDO ARCHIVO " + getArchivo2()[i] + "\n" + mensaje);
                analizador.AnalizarCodigo(mensaje);
                analizador.MostrarEr();
                ArrayList<Clases> clases2 = analizador.getClases();
                String nombreArchivo = getArchivo2()[i];
                int totalClases = 0;
                int totalVariables = 0;
                int totalMetodos = 0;
                int totalComentarios = 0;
                //System.out.println("CAPACIDAD: " + clases.size());
                for (int j = 0; j < clases2.size(); j++) {
                    for (int k = 0; k < clases2.get(j).getListaClases().size(); k++) {
                        totalClases = totalClases + clases2.get(j).getListaClases().size();
                        totalComentarios = totalComentarios + clases2.get(j).getListaComentarios().size();
                        for (int l = 0; l < clases2.get(j).getListaClases().size(); l++) {
                            totalVariables = totalVariables + clases2.get(j).getListaClases().get(l).getCantidadVariables();
                            totalMetodos = totalMetodos + clases2.get(j).getListaClases().get(l).getCantidadMetodos();
                        }
                    }
                    
                    
                }

                Archivo respuesta2 = new Archivo(nombreArchivo,totalClases,totalVariables,totalMetodos,totalComentarios, clases2);
                this.proyecto2.add(respuesta2);
            }
            
        }
        
    }
    
    public String RepitenciaIdClase(String nombreArchivo, String nombreClase){
        String nombreA = nombreArchivo.replace("\"", "");
        nombreClase = nombreClase.replace("\"", "");
        String id="";
        String id2="";
        double puntajetotal = 0;
        int cantMet = 0;
        int cantLineas=0;
        int cantMet2 = 0;
        int cantLineas2=0;
        for (int i = 0; i < getProyecto1().size(); i++) {
            if(nombreA.equalsIgnoreCase(getProyecto1().get(i).getNombre())){
                for (int j = 0; j < getProyecto1().get(i).getResultado().size(); j++) {
                    for (int k = 0; k < getProyecto1().get(i).getResultado().get(j).getListaClases().size(); k++) {
                        id = getProyecto1().get(i).getResultado().get(j).getListaClases().get(k).getIdClase();
                        if(nombreClase.equalsIgnoreCase(id)){
                            cantMet = getProyecto1().get(i).getResultado().get(j).getListaClases().get(k).getCantidadMetodos();
                            cantLineas = getProyecto1().get(i).getResultado().get(j).getListaClases().get(k).getLineasClase();  
                        }               
                        
                        
                    }
                }
            }
        }
        
        
        for (int i = 0; i < getProyecto2().size(); i++) {
            for (int j = 0; j < getProyecto2().get(i).getResultado().size(); j++) {
                for (int k = 0; k < getProyecto2().get(i).getResultado().get(j).getListaClases().size(); k++) {
                    id2 = getProyecto2().get(i).getResultado().get(j).getListaClases().get(k).getIdClase();
                    cantMet2 = getProyecto2().get(i).getResultado().get(j).getListaClases().get(k).getCantidadMetodos();
                    cantLineas2 = getProyecto2().get(i).getResultado().get(j).getListaClases().get(k).getLineasClase();
                    if(id.equalsIgnoreCase(id2)){
                        puntajetotal = puntajetotal + 0.2;
                        if(cantMet2 == cantMet){
                            puntajetotal = puntajetotal + 0.4;
                            if(cantLineas2 == cantLineas){
                                puntajetotal = puntajetotal + 0.4;
                            } 
                        }
                    }                    
                }
            }
        }
        DecimalFormat formato = new DecimalFormat("#0.0");
        System.out.println("PUNTAJE ESPECIFICO CLASES: " + puntajetotal);
        return formato.format(puntajetotal);
    }
    
    
    
    public String EspecificoClase(String nombreArchivo, String nombreClase){
        
        return RepitenciaIdClase(nombreArchivo, nombreClase);
    }
    
    public String RepitenciaIdVariable(String nombreArchivo, String nombreClase){
        String nombreA = nombreArchivo.replace("\"", "");
        nombreClase = nombreClase.replace("\"", "");
        String id="";
        String id2="";
        int totalRep = 0;
        for (int i = 0; i < getProyecto1().size(); i++) {
            if(nombreA.equalsIgnoreCase(getProyecto1().get(i).getNombre())){
                for (int j = 0; j < getProyecto1().get(i).getResultado().size(); j++) {
                    for (int k = 0; k < getProyecto1().get(i).getResultado().get(j).getListaClases().size(); k++) {
                        String idclase = getProyecto1().get(i).getResultado().get(j).getListaClases().get(k).getIdClase();
                        if(idclase.equalsIgnoreCase(nombreClase)){
                            for (int l = 0; l < getProyecto1().get(i).getResultado().get(j).getListaClases().get(k).getInstrucciones().size(); l++) {
                                if(getProyecto1().get(i).getResultado().get(j).getListaClases().get(k).getInstrucciones().get(l).getVariable() != null){
                                    id = getProyecto1().get(i).getResultado().get(j).getListaClases().get(k).getInstrucciones().get(l).getVariable().getVariable();
                                    for (int m = 0; m < getProyecto2().size(); m++) {
                                        for (int n = 0; n < getProyecto2().get(m).getResultado().size(); n++) {
                                            for (int o = 0; o < getProyecto2().get(m).getResultado().get(n).getListaClases().size(); o++) {
                                                for (int p = 0; p < getProyecto2().get(m).getResultado().get(n).getListaClases().get(o).getInstrucciones().size(); p++) {
                                                    if (getProyecto2().get(m).getResultado().get(n).getListaClases().get(o).getInstrucciones().get(p).getVariable() != null) {
                                                        id2 = getProyecto2().get(m).getResultado().get(n).getListaClases().get(o).getInstrucciones().get(p).getVariable().getVariable();
                                                        if (id.equalsIgnoreCase(id2)) {
                                                            totalRep++;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } 
                                }
                                
                            }
                        }
                    }
                }
            }
        }

                
        System.out.println("PUNTAJE ESPECIFICO VARIABLES: " +totalRep);
        if(totalRep > 0){
            return "1";
        }else{
            return "0";
        }
    
         
    }
    
    public String EspecificoVariable(String nombreArchivo, String nombreClase){
        return RepitenciaIdVariable(nombreArchivo, nombreClase);
    }
    
    
    public String RepitenciaIdMetodo(String nombreArchivo, String nombreClase){
        String nombreA = nombreArchivo.replace("\"", "");
        nombreClase = nombreClase.replace("\"", "");
        String id="";
        String id2="";
        int par1 = 0;
        int par2 = 0;
        int cantLineas = 0;
        int cantLineas2 = 0;
        double totalRep = 0;
        
        for (int i = 0; i < getProyecto1().size(); i++) {
            if(getProyecto1().get(i).getNombre().equalsIgnoreCase(nombreA)){
                for (int j = 0; j < getProyecto1().get(i).getResultado().size(); j++) {
                    for (int k = 0; k < getProyecto1().get(i).getResultado().get(j).getListaClases().size(); k++) {
                        if(getProyecto1().get(i).getResultado().get(j).getListaClases().get(k).getIdClase().equalsIgnoreCase(nombreClase)){
                            for (int l = 0; l < getProyecto1().get(i).getResultado().get(j).getListaClases().get(k).getInstrucciones().size(); l++) {
                                if (getProyecto1().get(i).getResultado().get(j).getListaClases().get(k).getInstrucciones().get(l).getMetodo() != null) {
                                    id = getProyecto1().get(i).getResultado().get(j).getListaClases().get(k).getInstrucciones().get(l).getMetodo().getIdMetodo();
                                    par1 = getProyecto1().get(i).getResultado().get(j).getListaClases().get(k).getInstrucciones().get(l).getMetodo().getCantidadParams();
                                    cantLineas = getProyecto1().get(i).getResultado().get(j).getListaClases().get(k).getInstrucciones().get(l).getMetodo().getLineasMetodo();
                                    for (int m = 0; m < getProyecto2().size(); m++) {
                                        for (int n = 0; n < getProyecto2().get(m).getResultado().size(); n++) {
                                            for (int o = 0; o < getProyecto2().get(m).getResultado().get(n).getListaClases().size(); o++) {
                                                for (int p = 0; p < getProyecto2().get(m).getResultado().get(n).getListaClases().get(o).getInstrucciones().size() ; p++) {
                                                    if(getProyecto2().get(m).getResultado().get(n).getListaClases().get(o).getInstrucciones().get(p).getMetodo() != null){
                                                        id2 = getProyecto2().get(m).getResultado().get(n).getListaClases().get(o).getInstrucciones().get(p).getMetodo().getIdMetodo();
                                                        par2 = getProyecto2().get(m).getResultado().get(n).getListaClases().get(o).getInstrucciones().get(p).getMetodo().getCantidadParams();
                                                        cantLineas2 = getProyecto2().get(m).getResultado().get(n).getListaClases().get(o).getInstrucciones().get(p).getMetodo().getLineasMetodo();
                                                        if (id.equalsIgnoreCase(id2)) {
                                                            totalRep = totalRep + 0.4;
                                                            if (par1 == par2) {
                                                                totalRep = totalRep + 0.3;
                                                                if (cantLineas == cantLineas2) {
                                                                    totalRep = totalRep + 0.3;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }                                
                                }
                            }
                        }
                    }
                }
            }
        }
        
        
        

        DecimalFormat formato = new DecimalFormat("#0.0");
        System.out.println("PUNTAJE ESPECIFICO METODO: " + totalRep);
        return formato.format(totalRep);
    }
    
    
    
    public String EspecificoMetodo(String nombreArchivo, String nombreClase){
        return RepitenciaIdMetodo(nombreArchivo,nombreClase);
    }
    
    
    public String RepitenciaComentarios(String nombreArchivo){
        String coment = "";
        String coment2 = "";
        int totalRep = 0;
        String nombreA = nombreArchivo.replace("\"", "");
        for (int i = 0; i < getProyecto1().size(); i++) {
            if(getProyecto1().get(i).getNombre().equalsIgnoreCase(nombreA)){
                for (int j = 0; j < getProyecto1().get(i).getResultado().size(); j++) {
                    for (int k = 0; k < getProyecto1().get(i).getResultado().get(j).getListaComentarios().size(); k++) {
                        coment = getProyecto1().get(i).getResultado().get(j).getListaComentarios().get(k).getComent();
                        for (int l = 0; l < getProyecto2().size(); l++) {
                            for (int m = 0; m < getProyecto2().get(l).getResultado().size(); m++) {
                                for (int n = 0; n < getProyecto2().get(l).getResultado().get(m).getListaComentarios().size(); n++) {
                                    coment2 = getProyecto2().get(l).getResultado().get(m).getListaComentarios().get(n).getComent();
                                    if (coment.equalsIgnoreCase(coment2)) {
                                        totalRep = totalRep + 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        DecimalFormat formato = new DecimalFormat("#0.0");
        System.out.println("PUNTAJE ESPECIFICO COMENTARIO: " + totalRep);
        return formato.format(totalRep);
    }
    
    
    
    public String EspecificoComentario(String nombreArchivo){
        return RepitenciaComentarios(nombreArchivo);
    }
    
    public String ObtenerPuntajeGeneral(){   
        return comp.getPuntajeGeneral();
    }
    
    public String[] getArchivo1(){
        return this.getNombreArchivos1();
    }
    
    public String[] getArchivo2(){
        return this.getNombreArchivos2();
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

    /**
     * @return the nombreArchivos1
     */
    public String[] getNombreArchivos1() {
        return nombreArchivos1;
    }

    /**
     * @param nombreArchivos1 the nombreArchivos1 to set
     */
    public void setNombreArchivos1(String[] nombreArchivos1) {
        this.nombreArchivos1 = nombreArchivos1;
    }

    /**
     * @return the nombreArchivos2
     */
    public String[] getNombreArchivos2() {
        return nombreArchivos2;
    }

    /**
     * @param nombreArchivos2 the nombreArchivos2 to set
     */
    public void setNombreArchivos2(String[] nombreArchivos2) {
        this.nombreArchivos2 = nombreArchivos2;
    }

    /**
     * @return the proyecto1
     */
    public ArrayList<Archivo> getProyecto1() {
        return proyecto1;
    }

    /**
     * @param proyecto1 the proyecto1 to set
     */
    public void setProyecto1(ArrayList<Archivo> proyecto1) {
        this.proyecto1 = proyecto1;
    }

    /**
     * @return the proyecto2
     */
    public ArrayList<Archivo> getProyecto2() {
        return proyecto2;
    }

    /**
     * @param proyecto2 the proyecto2 to set
     */
    public void setProyecto2(ArrayList<Archivo> proyecto2) {
        this.proyecto2 = proyecto2;
    }
    
    
}
