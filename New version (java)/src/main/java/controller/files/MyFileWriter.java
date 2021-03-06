/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author Matmozaur
 */
public class MyFileWriter {
    private final JFileChooser FileChooser;
    private static MyFileWriter f;
    private MyFileWriter(){
        FileChooser=new JFileChooser();
    }
    public static MyFileWriter getInstance(){
        if(f==null){
            f=new MyFileWriter();
        }
        return f;
    }
    
    public void save(File file,JTextArea area,JFrame parent){
        FileWriter Writer=null;
        if(file==null){
            saveAs(area,parent);
            return;
        }
        try {
            Writer = new FileWriter(file);
            BufferedWriter  bWriter = new BufferedWriter(Writer);
            bWriter.write(area.getText());
        } catch (IOException ex) {
            Logger.getLogger(MyFileWriter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                assert Writer != null;
                Writer.close();
            } catch (IOException ex) {
                Logger.getLogger(MyFileWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void saveAs(JTextArea area,JFrame parent){
        FileWriter Writer=null;
        File file;
        try {
            int flag=FileChooser.showOpenDialog(parent);
            if(flag==JFileChooser.APPROVE_OPTION){
                file=FileChooser.getSelectedFile();
                if(file!=null) parent.setTitle(file.getName()+"-SubChanger");
            }
            else return;
            Writer = new FileWriter(file != null ? file : null);
            BufferedWriter  bWriter = new BufferedWriter(Writer);
            bWriter.write(area.getText());
        } catch (IOException ex) {
            Logger.getLogger(MyFileWriter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(Writer !=null) Writer.close();
            } catch (IOException ex) {
                Logger.getLogger(MyFileWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
