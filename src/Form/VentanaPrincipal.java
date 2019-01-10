/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import ControlDot.ControlDot;
import ControlDot.generarGrafica;
import static ControlDot.generarGrafica.generarGrafica;
import Ejecucion.EjecucionLenguajeAsa;
import EjecucionExpresiones.ExpresionAritmetica;
import Ejecucion.TablaFunciones;
import Ejecucion.TablaSimbolo;
import fuentes.Nodo;
import fuentes.parser;
import fuentes.scanner;
import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author Hellen
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    String a = "Ale";
    double b = 20;

    public void mostrar() {
        a = "d";
        System.out.println(a);
    }

    public VentanaPrincipal() {
        initComponents();
        mostrar();
        System.out.println("m" + a);
        File file = new File("C:\\Users\\Hellen\\Documents\\Cursos\\COMPI1_VACAS_DIC_2018\\Proyecto2_201325674\\src\\archivoPrueba.asa");

        String content = "";

        try {
            content = new String(Files.readAllBytes(Paths.get("C:\\Users\\Hellen\\Documents\\Cursos\\COMPI1_VACAS_DIC_2018\\Proyecto2_201325674\\src\\archivoPrueba.asa")));
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            String texto = content;
            System.out.println("Inicia analisis...");

            if (!"".equals(texto)) {
                scanner scan = new scanner(new BufferedReader(new StringReader(texto)));
                parser parser = new parser(scan);
                parser.parse();
                Nodo AST = parser.padre;

                String archivoTxT = "C:\\Users\\Hellen\\Desktop" + "\\GrafoApila.txt";
                File file1 = new File(archivoTxT);

                PrintWriter writer = new PrintWriter(file1, "UTF-8");

                writer.println(ControlDot.getDot(AST));
                writer.close();
                generarGrafica(archivoTxT, "AST");
                System.out.println("Finaliza analisis...");

                for (Nodo item : AST.getHijos()) {
                    EjecucionLenguajeAsa ejecucion = new EjecucionLenguajeAsa();
                    ejecucion.almacenarFunciones(item);
                    break;
                }
                TablaFunciones a = EjecucionLenguajeAsa.tsFunciones;

                EjecucionLenguajeAsa leng = new EjecucionLenguajeAsa();
                leng.almacenarVariablesGlobales(AST.getHijos().get(0));
                leng.almacenarFunciones(AST);

                System.out.println("**************************Variables en tabla de simbolos global :D***********************************");
                EjecucionLenguajeAsa.tsGlobal.mostrarTS();

                System.out.println("**************************Funciones en tabla de Funciones global :D***********************************");
                EjecucionLenguajeAsa.tsFunciones.mostrarTS();

                if (EjecucionLenguajeAsa.tsFunciones.existeFuncion("vacio_principal")) {
                    System.out.println("El metodo principal si esta");
                    txtConsola.setText(EjecucionLenguajeAsa.ejecutarMain());
                    //TablaSimbolo t = EjecucionLenguajeAsa.pilaSimbolos.peek();
                } else {
                    System.out.println("El metodo principal no esta declarado aun");
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }        // TODO add your handling code here:
    }

    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<String>();
        if (digits.length() > 1) {
            for (int i = 0; i < digits.length() - 1; i++) {
                for (int j = 0; j < digits.length() - 1; i++) {
                    char caracter = digits.charAt(i);
                    char caracterj = digits.charAt(j);
                    System.out.println(caracter + Character.toString((char) j));
                }
            }
        }
        return list;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtConsola = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        txtConsola.setColumns(20);
        txtConsola.setRows(5);
        jScrollPane2.setViewportView(txtConsola);

        jLabel2.setText("Consola provisional");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jButton1)
                        .addGap(102, 102, 102)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        File file = new File("C:\\Users\\Hellen\\Documents\\Cursos\\COMPI1_VACAS_DIC_2018\\Proyecto2_201325674\\src\\archivoPrueba.asa");

        String content = "";

        try {
            content = new String(Files.readAllBytes(Paths.get("C:\\Users\\Hellen\\Documents\\Cursos\\COMPI1_VACAS_DIC_2018\\Proyecto2_201325674\\src\\archivoPrueba.asa")));
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            String texto = content;
            System.out.println("Inicia analisis...");
            scanner scan = new scanner(new BufferedReader(new StringReader(texto)));
            parser parser = new parser(scan);
            parser.parse();
            System.out.println("Finaliza analisis...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea txtConsola;
    // End of variables declaration//GEN-END:variables
}
