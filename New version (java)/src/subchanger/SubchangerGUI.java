/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subchanger;

import java.io.File;
import javax.swing.JOptionPane;
import suppliers.*;

/**
 *
 * @author Matmozaur
 */
public class SubchangerGUI extends javax.swing.JFrame {
    
    char type;
    FileCommunicator FC= FileCommunicator.getInstance();
    /**
     * Creates new form SubchangerGUI
     */
    public SubchangerGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        SearchedText = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        ReplacementText = new javax.swing.JTextField();
        ReplaceButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        menuNew = new javax.swing.JMenuItem();
        menuOpen = new javax.swing.JMenuItem();
        menuSave = new javax.swing.JMenuItem();
        menuSaveAs = new javax.swing.JMenuItem();
        menuExit = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        menuCopy = new javax.swing.JMenuItem();
        menuPaste = new javax.swing.JMenuItem();
        menuCut = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuConstantTime = new javax.swing.JMenuItem();
        menuByFunction = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        SearchedText.setText("Searched phrase");
        SearchedText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SearchedTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SearchedTextFocusLost(evt);
            }
        });
        SearchedText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchedTextActionPerformed(evt);
            }
        });
        jPanel1.add(SearchedText);

        SearchButton.setForeground(new java.awt.Color(102, 102, 102));
        SearchButton.setText("Search");
        SearchButton.setAlignmentX(0.5F);
        SearchButton.setMargin(new java.awt.Insets(2, 4, 2, 4));
        SearchButton.setMaximumSize(new java.awt.Dimension(740, 320));
        SearchButton.setMinimumSize(new java.awt.Dimension(74, 24));
        SearchButton.setPreferredSize(new java.awt.Dimension(74, 24));
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });
        jPanel1.add(SearchButton);
        SearchButton.getAccessibleContext().setAccessibleDescription("");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setMinimumSize(new java.awt.Dimension(10, 10));
        jSeparator2.setPreferredSize(new java.awt.Dimension(20, 100));
        jPanel1.add(jSeparator2);

        ReplacementText.setText("Replacement");
        ReplacementText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ReplacementTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ReplacementTextFocusLost(evt);
            }
        });
        ReplacementText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReplacementTextActionPerformed(evt);
            }
        });
        jPanel1.add(ReplacementText);

        ReplaceButton.setText("Replace");
        jPanel1.add(ReplaceButton);

        jPanel2.setLayout(new javax.swing.OverlayLayout(jPanel2));

        TextArea.setColumns(20);
        TextArea.setForeground(new java.awt.Color(0, 0, 0));
        TextArea.setLineWrap(true);
        TextArea.setRows(5);
        jScrollPane1.setViewportView(TextArea);

        jPanel2.add(jScrollPane1);

        File.setText("File");

        menuNew.setText("new");
        File.add(menuNew);

        menuOpen.setText("open");
        menuOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpenActionPerformed(evt);
            }
        });
        File.add(menuOpen);

        menuSave.setText("save");
        File.add(menuSave);

        menuSaveAs.setText("save as");
        menuSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSaveAsActionPerformed(evt);
            }
        });
        File.add(menuSaveAs);

        menuExit.setText("exit");
        File.add(menuExit);

        jMenuBar1.add(File);

        Edit.setText("Edit");

        menuCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menuCopy.setText("copy");
        Edit.add(menuCopy);

        menuPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        menuPaste.setText("paste");
        Edit.add(menuPaste);

        menuCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuCut.setText("cut");
        menuCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCutActionPerformed(evt);
            }
        });
        Edit.add(menuCut);

        jMenuBar1.add(Edit);

        jMenu3.setText("Time change");

        menuConstantTime.setText("constant time");
        jMenu3.add(menuConstantTime);

        menuByFunction.setText("by function");
        menuByFunction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuByFunctionActionPerformed(evt);
            }
        });
        jMenu3.add(menuByFunction);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchedTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchedTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchedTextActionPerformed

    private void ReplacementTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReplacementTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReplacementTextActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void menuCutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuCutActionPerformed

    private void menuSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSaveAsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuSaveAsActionPerformed

    private void menuByFunctionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuByFunctionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuByFunctionActionPerformed

    private void SearchedTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchedTextFocusGained
        SearchedText.setText("");
    }//GEN-LAST:event_SearchedTextFocusGained

    private void SearchedTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchedTextFocusLost
        SearchedText.setText("Searched phrase");
    }//GEN-LAST:event_SearchedTextFocusLost

    private void ReplacementTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ReplacementTextFocusGained
        ReplacementText.setText("");
    }//GEN-LAST:event_ReplacementTextFocusGained

    private void menuOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpenActionPerformed
        File file=FC.getUsersFile(this);
        type = FC.writeSubtitles(file, this.TextArea);
        if(type=='0'){
            JOptionPane.showMessageDialog(this, "Unknown type of subtitles");
        } 
    }//GEN-LAST:event_menuOpenActionPerformed

    private void ReplacementTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ReplacementTextFocusLost
        ReplacementText.setText("Replacement");
    }//GEN-LAST:event_ReplacementTextFocusLost

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
            java.util.logging.Logger.getLogger(SubchangerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubchangerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubchangerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubchangerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubchangerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Edit;
    private javax.swing.JMenu File;
    private javax.swing.JButton ReplaceButton;
    private javax.swing.JTextField ReplacementText;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchedText;
    private javax.swing.JTextArea TextArea;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JMenuItem menuByFunction;
    private javax.swing.JMenuItem menuConstantTime;
    private javax.swing.JMenuItem menuCopy;
    private javax.swing.JMenuItem menuCut;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenuItem menuNew;
    private javax.swing.JMenuItem menuOpen;
    private javax.swing.JMenuItem menuPaste;
    private javax.swing.JMenuItem menuSave;
    private javax.swing.JMenuItem menuSaveAs;
    // End of variables declaration//GEN-END:variables
}
