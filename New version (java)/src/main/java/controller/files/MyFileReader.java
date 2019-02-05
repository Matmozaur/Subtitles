/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import model.Type;
import controller.suppliers.AddicionalFunctions;
import view.GUI;

public class MyFileReader {
    private final JFileChooser FileChooser;
    private static MyFileReader f;
    private MyFileReader(){
        FileChooser=new JFileChooser();
        FileChooser.addChoosableFileFilter(new MyFileFilter(".txt"));
    }
    public static MyFileReader getInstance(){
        if(f==null){
            f=new MyFileReader();
        }
        return f;
    }
    
    public void getUsersFile(GUI parent){
        int flag=FileChooser.showOpenDialog(parent.getFrame());
        if(flag==JFileChooser.APPROVE_OPTION){
            File file=FileChooser.getSelectedFile();
            if(file!=null){
                parent.setFile(file);
                writeSubtitles(file,parent.getTa());
            }
        }
    }
    
    private Type getType(BufferedReader br) throws IOException{
        Map<Type,Integer> types=new HashMap<Type,Integer>();
        types.put(Type.MicroDVD,0);
        types.put(Type.SubRip,0);
        int i;
        while ((i=br.read()) != -1){
            char c=(char) i;
            if(c=='{') types.put(Type.MicroDVD, types.get(Type.MicroDVD)+1);
            if(c=='>') types.put(Type.SubRip, types.get(Type.SubRip)+1);
        }
        return AddicionalFunctions.<Type>maxKey(types);
    }
            
    
    public Type writeSubtitles(File file,JTextArea area){
        BufferedReader br;
            try {
                br = new BufferedReader(new java.io.FileReader(file));
                Type type=getType(br);
                if(type==null){
                    type=Type.TEXT;
                }
                br = new BufferedReader(new java.io.FileReader(file));

                switch(type){
                        case MicroDVD: this.writeMicroDVD(br,area);
                                  break;
                        case SubRip: this.writeSubRip(br,area);
                                  break;
                        default : defaultWrite(br,area);
                    }
                br.close();
                return type;
            }
            catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        return null;
    }

    private void writeMicroDVD(BufferedReader br, JTextArea area) throws IOException{
        area.setText(null);
        String line="";
        int c;
        while ((c = br.read()) != -1) {
            char s=(char) c;
            line= new StringBuilder().append(line).append(s).toString();
        }
        area.append(line);
    }
    
    private void writeSubRip(BufferedReader br, JTextArea area) throws IOException{
        area.setText(null);
        String line="";
        int c;
        while ((c = br.read()) != -1) {
            char s=(char) c;
            line=line+s;
        }
        area.append(line);
    }

    private void defaultWrite(BufferedReader br, JTextArea area) throws IOException{
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
