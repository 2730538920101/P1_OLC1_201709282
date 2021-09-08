/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Carlos Martinez
 */
public class Barras {
    public String[] titulo, tituloX, tituloY;
    public String[] ejex;
    public String[] valores;
    public int contBarras;
    public static ArrayList<String> GraficasBarras = new ArrayList<>();
    public Barras(){
        
    }
    public void hacerBarras(String[] titulo, String[] ejex, String[] valores, String[] Titulox, String[] Tituloy) throws IOException{
        contBarras++;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        
        for (int i = 0; i < valores.length; i++) {
            double val = Double.parseDouble(valores[i]);    
            dataset.addValue(val,"Porcentaje de copia", ejex[i]);
        }
        JFreeChart barChart = ChartFactory.createBarChart(
        titulo[0], 
        Titulox[0], Tituloy[0], 
        dataset,PlotOrientation.VERTICAL, 
        true, true, false);

        int width = 640;    /* Width of the image */
        int height = 480;   /* Height of the image */ 
        try{
            final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
            final File BarChart = new File( "BarChart"+String.valueOf(contBarras)+".png" ); 
            ChartUtilities.saveChartAsPNG(BarChart , barChart , width , height, info );
            GraficasBarras.add(BarChart.getName());
            System.out.println("GRAFICA DE BARRAS GENERADA");
        }catch(Exception e){
            System.out.println(e);
        } 
         
       
    }

    /**
     * @return the titulo
     */
    public String[] getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String[] titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the tituloX
     */
    public String[] getTituloX() {
        return tituloX;
    }

    /**
     * @param tituloX the tituloX to set
     */
    public void setTituloX(String[] tituloX) {
        this.tituloX = tituloX;
    }

    /**
     * @return the tituloY
     */
    public String[] getTituloY() {
        return tituloY;
    }

    /**
     * @param tituloY the tituloY to set
     */
    public void setTituloY(String[] tituloY) {
        this.tituloY = tituloY;
    }

    /**
     * @return the ejex
     */
    public String[] getEjex() {
        return ejex;
    }

    /**
     * @param ejex the ejex to set
     */
    public void setEjex(String[] ejex) {
        this.ejex = ejex;
    }

    /**
     * @return the valores
     */
    public String[] getValores() {
        return valores;
    }

    /**
     * @param valores the valores to set
     */
    public void setValores(String[] valores) {
        this.valores = valores;
    }
    
}
