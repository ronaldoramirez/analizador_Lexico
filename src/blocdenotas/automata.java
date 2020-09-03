package blocdenotas;

public class automata extends javax.swing.JFrame {

    public automata() {
        initComponents();
        this.setTitle("Automata");
        this.setLocationRelativeTo(this);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtAutomata = new javax.swing.JTextField();
        btnEjecutar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mostrarTexto = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Ingrese la cadena");

        txtAutomata.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        btnEjecutar.setText("Ejecutar Automata");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        mostrarTexto.setColumns(20);
        mostrarTexto.setRows(5);
        jScrollPane1.setViewportView(mostrarTexto);

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtAutomata, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEjecutar)
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAutomata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEjecutar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        frmNotepad notePad = new frmNotepad();
        notePad.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        // TODO add your handling code here:
        mostrarTexto.setText(ejecutar(txtAutomata.getText(), 1));
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        txtAutomata.setText("");
        mostrarTexto.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    public static String ejecutar(String cadena, int linea) {
        int estado = 1, bandera = 0;
        String text = "";
        do {
            String subcadena = cadena.substring(bandera, bandera + 1);
            switch (estado) {
                case 1: {
                    if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 2;
                    } else {
                        text = error(text);
                    }
                }
                break;

                case 2: {
                    if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 2;
                    } else if (subcadena.equalsIgnoreCase(".")) {
                        estado = 3;
                    } else if (cadena.substring(bandera, bandera + 1).equalsIgnoreCase("E")) {
                        estado = 5;
                    } else {
                        text = error(text);
                    }
                }
                break;

                case 3: {
                    if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 4;
                    } else {
                        text = error(text);
                    }
                }
                break;

                case 4: {
                    if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 4;
                    } else if (subcadena.equalsIgnoreCase("E")) {
                        estado = 5;
                    } else {
                        text = error(text);
                    }
                }
                break;

                case 5: {
                    if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 7;
                    } else if ((subcadena.equalsIgnoreCase("+")) || (subcadena.equalsIgnoreCase("-"))) { // || 
                        estado = 6;
                    } else {
                        text = error(text);
                    }
                }
                break;

                case 6: {
                    if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 7;
                    } else {
                        text = error(text);
                    }
                }
                break;

                case 7: {
                    if (Character.isDigit(cadena.charAt(bandera))) {
                        estado = 7;
                    } else {
                        text = error(text);
                    }
                }
                break;

                default:
                    text = error(text);
                    break;
            }
            bandera++;

            if (text.equalsIgnoreCase("Error, en la cadena ingresada\n")) {
                break;
            }
        } while (bandera < cadena.length());
        //Si hay error devuelve esta cadena
        if (text.equalsIgnoreCase("Error, en la cadena ingresada\n")) {
            cadena = text;
            cadena = cadena.replace("\n", " en la linea #" + linea + ".\n");

        } else {// De lo contrario devuelve lo que el usuario ingreso en esa linea
            
            cadena = cadena.concat("\n");
        }

        return cadena;
    }

    public static String error(String texto) {
        texto += "Error, en la cadena ingresada\n";
        return texto;
    }

    public static String imprimirDigito(int estado, String cadena, String texto, int bandera) {
        texto += "El estado es: " + estado + ". Del digito: " + cadena.charAt(bandera) + "\n";
        return texto;

    }

    public static String imprimirCaracter(int estado, String cadena, String texto, int bandera) {
        texto += "El estado es: " + estado + ". Del Caracter: " + cadena.charAt(bandera) + "\n";
        return texto;
    }


    /*
    public static String imprimirDigito(int estado, String cadena, String texto, int bandera){
        texto += "El estado es: " + estado + ". Del digito: " + cadena.charAt(bandera)+"\n";
        return texto;
        
    }
    
    public static String imprimirCaracter(int estado, String cadena, String texto, int bandera){
        texto += "El estado es: " + estado + ". Del Caracter: " + cadena.charAt(bandera)+"\n";
        return texto;
    }
     */
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
            java.util.logging.Logger.getLogger(automata.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(automata.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(automata.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(automata.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new automata().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea mostrarTexto;
    private javax.swing.JTextField txtAutomata;
    // End of variables declaration//GEN-END:variables
}
