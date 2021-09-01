/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.Funciones;
import java.io.File;
import javax.swing.JOptionPane;
import Analizadorfca.*;
import Analizadorjs.*;

/**
 *
 * @author Carlos Martinez
 */
public class Principal extends javax.swing.JFrame {

 
    
    String [] opcionesArchivos ={"Guardar","Guardar Como", "Abrir Archivos"};
    Funciones func;
    File Archivo;
    static String consoleMsj = "";
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("PROYECTO FASE 1 ORGANIZACION DE LENGUAJES Y COMPILADORES 1 CARLOS MARTINEZ 201709282");
        func = new Funciones();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        btnArchivo = new javax.swing.JButton();
        btnCrearP = new javax.swing.JButton();
        btnEliminarP = new javax.swing.JButton();
        btnEjecutar = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Tabulador = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setBackground(new java.awt.Color(153, 153, 153));
        jInternalFrame1.setTitle("FIUSAC Copy Analyzer");
        jInternalFrame1.setVisible(true);

        btnArchivo.setText("Archivo");
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        btnCrearP.setText("Crear Pestaña");
        btnCrearP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPActionPerformed(evt);
            }
        });

        btnEliminarP.setText("Eliminar Pestaña");
        btnEliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPActionPerformed(evt);
            }
        });

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        btnReportes.setText("Reportes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnCrearP, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnEliminarP, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearP, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarP, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Tabulador.setBackground(new java.awt.Color(204, 204, 204));
        Tabulador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Tabulador.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabulador, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabulador, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("CONSOLA");

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(204, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(255, 51, 51));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPActionPerformed
        // TODO add your handling code here:
        
        Ventana ventana1 = new Ventana();
        this.Tabulador.add("VENTANA",ventana1);
    }//GEN-LAST:event_btnCrearPActionPerformed

    private void btnEliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPActionPerformed
        // TODO add your handling code here:
       try{
           int indice = this.Tabulador.getSelectedIndex();
           this.Tabulador.remove(indice);
       }catch(Exception e){
           System.out.println(e);
       }
        
    }//GEN-LAST:event_btnEliminarPActionPerformed

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
        // TODO add your handling code here:
        
        try{
            int selec = JOptionPane.showOptionDialog(this, "Selecciona una opcion para continuar", "Menu De Opciones", 0, JOptionPane.QUESTION_MESSAGE, null, opcionesArchivos, "Guardar");
            System.out.println("Seleccion: " + opcionesArchivos[selec]);
            System.out.println("Numero:"+ selec);
            switch(selec){
                case 0:
                    //AQUI INCERTAMOS EL CODIGO PARA GUARDAR
                     if(this.Tabulador.getComponentCount()>0){
                        Ventana v = (Ventana)this.Tabulador.getSelectedComponent();
                        String documento = v.jTextArea1.getText();
                        String resGuardar = func.SaveDoc(documento);
                        JOptionPane.showMessageDialog(null, resGuardar);
                    }else{
                        JOptionPane.showMessageDialog(null,"DEBE CREAR UN DOCUMENTO");
                    }


                    break;
                case 1:
                    //AQUI INCERTAMOS EL CODIGO PARA GUARDAR COMO
                    if(this.Tabulador.getComponentCount()>0){
                        Ventana v = (Ventana)this.Tabulador.getSelectedComponent();
                        String documento = v.jTextArea1.getText();
                        String resGuardar = func.GuardarArchivo(documento);
                        JOptionPane.showMessageDialog(null, resGuardar);
                    }else{
                        JOptionPane.showMessageDialog(null,"DEBE CREAR UN DOCUMENTO");
                    }
                    break;
                case 2:
                    //AQUI INCERTAMOS EL CODIGO PARA ABRIR ARCHIVOS
                    String resAbrir = func.AbrirArchivo(Archivo);
                    if(this.Tabulador.getComponentCount()==0){
                        Ventana ventana1 = new Ventana();
                        ventana1.jTextArea1.setText(resAbrir);
                        this.Tabulador.add("VENTANA",ventana1);
                        this.jTextArea1.setText("ABRIENDO EL ARCHIVO");
                    }else{
                        Ventana comp = (Ventana)this.Tabulador.getSelectedComponent();
                        comp.jTextArea1.setText(resAbrir);
                        this.jTextArea1.setText("ABRIENDO EL ARCHIVO");
                    }
                    break;
            }
            
        }catch(Exception e){
            
            System.out.println(e);
        }
       
    }//GEN-LAST:event_btnArchivoActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        // TODO add your handling code here:
        Ventana pagina = (Ventana)this.Tabulador.getSelectedComponent();
        String texto = pagina.jTextArea1.getText();
        //Analizadorfca analizador;
        //analizador = Analizadorfca.getInstancia();
        
        Analizadorjs analizador2;
        analizador2 = Analizadorjs.getInstancia();
        
        try{
            
            /*analizador.AnalizarCodigo(texto);
            analizador.MostrarEr();
            analizador.MostrarMsj();*/
            analizador2.AnalizarCodigo(texto);
            analizador2.MostrarEr();
            
        }catch(Exception e){
            System.out.println(e);
        }
        
    }//GEN-LAST:event_btnEjecutarActionPerformed

    public static void EscribirMsj(String mensaje){
        consoleMsj = consoleMsj + mensaje;
        jTextArea1.setText(consoleMsj);
    }
    public static void EscribirErrorEnConsola(String mensaje){
        jTextArea1.setText(mensaje);
    }
    
    public static void CleanConsola(){
        jTextArea1.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tabulador;
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton btnCrearP;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnEliminarP;
    private javax.swing.JButton btnReportes;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
