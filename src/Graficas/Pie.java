/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficas;

import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Carlos Martinez
 */
public class Pie {
    public String[] titulo;
    public String[] ejex;
    public String[] valores;
    public int contPie;
    
    public Pie(){
        
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
    
     public void hacerPie(String[] titulo, String[] ejex, String[] valores) throws IOException{
        contPie++;
         DefaultPieDataset dataset = new DefaultPieDataset( );
        for (int i = 0; i < valores.length; i++) {
            double val = Double.parseDouble(valores[i]);
            dataset.setValue(ejex[i],val);
        }
        JFreeChart chart = ChartFactory.createPieChart(
         titulo[0],   // chart title
         dataset,          // data
         true,             // include legend
         true,
         false);
         
        int width = 640;   /* Width of the image */
        int height = 480;  /* Height of the image */ 
        try{
            final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
            final File pieChart = new File( "PieChart"+String.valueOf(contPie)+".png" ); 
            ChartUtilities.saveChartAsPNG( pieChart , chart , width , height, info );
            System.out.println("GRAFICA DE PIE GENERADA");
        }catch(Exception e){
            System.out.println(e);
        }
        
        
    }
    
}
