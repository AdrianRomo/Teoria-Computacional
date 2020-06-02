 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Adrian
 */
public class examinarArchivos extends javax.swing.JFrame {
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos java", "java");
    /**
     * Creates new form examinarArchivos
     */
    public examinarArchivos() {
        initComponents();
        
        
    }

    public boolean  analizarRenglon(String renglon) {
        ArrayList<String> palabra = new ArrayList();
        ArrayList<Boolean> estadosFinales = new ArrayList();
        int j=0;
        Boolean estadoRenglon;
        for(int i=0;i<renglon.length();i++) {
            if(renglon.charAt(i)=='\t'|| renglon.charAt(i)==' ' || renglon.charAt(i)=='=' || renglon.charAt(i)==';' || renglon.charAt(i)==',' || renglon.charAt(i)==')' || renglon.charAt(i)=='<' || renglon.charAt(i)=='>') {
                palabra.add(renglon.substring(j, i));
                j=i+1;
            }
        }
        for(int i=0;i<palabra.size();i++) {
            if(palabra.get(i).length()>=1) {
                if(palabra.get(i).charAt(0)== '-' || (palabra.get(i).charAt(0)>= '0' && palabra.get(i).charAt(0)<= '9')) {                    
                    estadosFinales.add(validarExpresion(palabra.get(i)));
                }
            }
        }
        estadoRenglon = true;
        for(int i = 0 ; i < estadosFinales.size() ; i++){
            estadoRenglon = estadosFinales.get(i) && estadoRenglon;
        }
        return estadoRenglon;
    }
    
    public boolean validarExpresion(String palabra) {
        int estado=0;
        for(int i=0; i<palabra.length();i++) {
            //Decimal s/Expresion
            if(estado==0) {
                if(palabra.charAt(i)=='0')
                    estado=1;
                else if(palabra.charAt(i)=='-')
                    estado=2;
                else if(palabra.charAt(i)>= '1' && palabra.charAt(i)<= '9')
                    estado=3;
                else estado=14;
            }
            //Hexadecimal
            else if(estado==1) {
                if(palabra.charAt(i)=='x')
                    estado=6;
                else if(palabra.charAt(i)>= '1' && palabra.charAt(i)<= '7')
                    estado=4;
                else if(palabra.charAt(i)=='+' || palabra.charAt(i)=='-' || palabra.charAt(i)=='/' || palabra.charAt(i)=='*')
                    estado=0;
                else estado=14;
            }
            else if(estado==2) {
                if(palabra.charAt(i)=='0')
                    estado=1;
                else if(palabra.charAt(i)>= '1' && palabra.charAt(i)<= '9')
                    estado=3;
                else estado=14;
            }
            //Decimal c/Expresion
            else if(estado==3) {
                if(palabra.charAt(i)>= '0' && palabra.charAt(i)<= '9')
                    estado=3;
                else if(palabra.charAt(i)=='E' || palabra.charAt(i)=='e')
                    estado=8;
                else if(palabra.charAt(i)=='.')
                    estado=9;
                else if(palabra.charAt(i)=='+' || palabra.charAt(i)=='-' || palabra.charAt(i)=='/' || palabra.charAt(i)=='*')
                    estado=0;
                else estado=14;
            }
            //Octal
            else if(estado==4) {
                if(palabra.charAt(i)>= '0' && palabra.charAt(i)<= '7')
                    estado=4;
                else if(palabra.charAt(i)=='+' || palabra.charAt(i)=='-' || palabra.charAt(i)=='/' || palabra.charAt(i)=='*')
                    estado=0;
                else estado=14;
            }
            //Hexadecimal
            else if(estado==6) {
                if((palabra.charAt(i)>= '1' && palabra.charAt(i)<= '9')|| (palabra.charAt(i)>= 'A' && palabra.charAt(i)<= 'F'))
                    estado=7;
                else estado=14;
            }
            else if(estado==7) {
                if((palabra.charAt(i)>= '0' && palabra.charAt(i)<= '9')|| (palabra.charAt(i)>= 'A' && palabra.charAt(i)<= 'F'))
                    estado=7;
                else if(palabra.charAt(i)=='+' || palabra.charAt(i)=='-' || palabra.charAt(i)=='/' || palabra.charAt(i)=='*')
                    estado=0;
                else estado=14;
            }
            else if(estado==8) {
                if(palabra.charAt(i)=='+' || palabra.charAt(i)=='-')
                    estado=11;
                else if(palabra.charAt(i)>= '0' && palabra.charAt(i)<= '9')
                    estado=12;
                else estado=14;
            }
            else if(estado==9) {
                if(palabra.charAt(i)>= '0' && palabra.charAt(i)<= '9')
                    estado=10;
                else estado=14;
            }
            else if(estado==10) {
                if(palabra.charAt(i)>= '0' && palabra.charAt(i)<= '9')
                    estado=10;
                else if(palabra.charAt(i)=='E' || palabra.charAt(i)=='e')
                    estado=8;
                else if(palabra.charAt(i)=='+' || palabra.charAt(i)=='-' || palabra.charAt(i)=='/' || palabra.charAt(i)=='*')
                    estado=0;
                else estado=14;
            }
            else if(estado==11) {
                if(palabra.charAt(i)>= '0' && palabra.charAt(i)<= '9')
                    estado=12;
                else estado=14;
            }
            else if(estado==12) {
                if(palabra.charAt(i)>= '0' && palabra.charAt(i)<= '9')
                    estado=12;
                else if(palabra.charAt(i)=='+' || palabra.charAt(i)=='-' || palabra.charAt(i)=='/' || palabra.charAt(i)=='*')
                    estado=0;
                else estado=14;
            }
       }
       if(estado==1||estado==4||estado==7||estado==3 || estado==10|| estado==12) {
           return true;
       }
       else return false;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        ruta = new javax.swing.JTextField();
        validar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        jLabel1.setText("Ruta del archivo:");

        ruta.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N

        validar.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 18)); // NOI18N
        validar.setText("Validar programa");
        validar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Microsoft Tai Le", 0, 18)); // NOI18N
        jLabel2.setText("Selecciona un archivo con extension .java");

        jMenu1.setText("Practica 3 pt. 2");

        jMenuItem1.setText("Open");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(validar)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(validar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFileChooser filechooser = new JFileChooser();  
        filechooser.setFileFilter(filter);
        int opcion = filechooser.showOpenDialog(this);
        if(opcion==JFileChooser.APPROVE_OPTION) {
            String nombreArchivo = filechooser.getSelectedFile().getPath();
            ruta.setText(nombreArchivo);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void validarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validarActionPerformed
        File archivo;
        FileReader fr;
        BufferedReader br;
        ArrayList<String> renglon = new ArrayList();
        boolean[] valores = new boolean[5000]; 
        int i=1;
        try {
            archivo = new File (ruta.getText());
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
             String linea;
            while((linea=br.readLine())!=null) {
                renglon.add(linea);
                System.out.println("Linea #" + i+ "\t" +linea);
                i++;
            }
            for(int j=0; j<renglon.size();j++) {
                boolean correcto = analizarRenglon(renglon.get(j));
                valores[j]=correcto;
                if(!correcto) {
                    System.out.println("Error en la linea " + (j+1));
                }
            }
            int k;
            for(k=0;k<renglon.size();k++) {
                if(valores[k]==false) {
                    break;
                }
            }
            if(k==renglon.size()) {
                System.out.println("No hay errores de analisis lexico en las constantes numericas del archivo " + ruta.getText());
            }
            System.out.println("Fin de la revision :)");
        }
        catch(IOException e){
        }
    }//GEN-LAST:event_validarActionPerformed

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
            java.util.logging.Logger.getLogger(examinarArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(examinarArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(examinarArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(examinarArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new examinarArchivos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JTextField ruta;
    private javax.swing.JButton validar;
    // End of variables declaration//GEN-END:variables
}
