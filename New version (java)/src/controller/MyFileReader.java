/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import model.Type;
import suppliers.AddicionalFunctions;
import view.GUI;

/**
 *
 * @author Matmozaur
 */
public class MyFileReader {
    private final JFileChooser FileChooser;
    private static MyFileReader f;
    private MyFileReader(){
        FileChooser=new JFileChooser();
    }
    public static MyFileReader getInstance(){
        if(f==null){
            f=new MyFileReader();
        }
        return f;
    }
    
    public File getUsersFile(JFrame parent){
        int flag=FileChooser.showOpenDialog(parent);
        if(flag==JFileChooser.APPROVE_OPTION){
            File file=FileChooser.getSelectedFile();
            if(file!=null) parent.setTitle(file.getName()+"-SubChanger");
            return file;
        }
        return null;        
    }
    
    public Type getType(BufferedReader br) throws IOException{       
        Map<Type,Integer> types=new HashMap<Type,Integer>();
        types.put(Type.MicroDVD,0);
        types.put(Type.SubRip,0);
        int i;
        while ((i=br.read()) != -1){
            char c=(char) i;
            if(c=='{') types.put(Type.MicroDVD, types.get(Type.MicroDVD)+1);
            if(c=='>') types.put(Type.SubRip, types.get(Type.SubRip)+1);
        }
        Type t=AddicionalFunctions.<Type>maxKey(types);
        return t;
    }
            
    
    public Type writeSubtitles(File file,JTextArea area){
        BufferedReader br;
            try {
                br = new BufferedReader(new java.io.FileReader(file));
                Type type=getType(br);
                if(type==null){
                    br.close();
                    return null;
                }
                br = new BufferedReader(new java.io.FileReader(file));
                switch(type){
                        case MicroDVD: this.writeMicroDVD(br,area);
                                  break;
                        case SubRip: this.writeSubRip(br,area);
                                  break;
                        default : return null;
                    }
                br.close();
                return type;      
            }
            catch (FileNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(IOException e){
                e.printStackTrace();
            }
        return null;
    }
    
    public void writeMicroDVD(BufferedReader br,JTextArea area) throws IOException{
        area.setText(null);
        String line="";
        int c;
        while ((c = br.read()) != -1) {
            char s=(char) c;
            line=line+s;
        }
        area.append(line);
    }
    
    public void writeSubRip(BufferedReader br,JTextArea area) throws IOException{
        area.setText(null);
        String line="";
        int c;
        while ((c = br.read()) != -1) {
            char s=(char) c;
            line=line+s;
        }
        area.append(line);
    }
    
}
