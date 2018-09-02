
package suppliers;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import subchanger.SubchangerGUI;

/**
 *
 * @author Matmozaur
 */
public class FileCommunicator {
    private JFileChooser FileChooser;
    private static FileCommunicator f;
    private FileCommunicator(){
        FileChooser=new JFileChooser();
    }
    public static FileCommunicator getInstance(){
        if(f==null){
            f=new FileCommunicator();
        }
        return f;
    }
    
    public File getUsersFile(Component parent){
        int flag=FileChooser.showOpenDialog(parent);
        if(flag==JFileChooser.APPROVE_OPTION){
            File file=FileChooser.getSelectedFile();
            return file;
        }
        return null;        
    }
    
    public char getType(BufferedReader br) throws IOException{       
        Map<Character,Integer> types=new HashMap<Character,Integer>();
        types.put('{',0);
        types.put('>',0);
        int i;
        while ((i=br.read()) != -1){
            char c=(char) i;
            if(c=='{') types.put('{', types.get('{')+1);
            if(c=='>') types.put('>', types.get('>')+1);
        }
        final int[] max=new int[2];
        types.forEach((k,v)->{if(v>max[0]){
            max[0]=v;
            max[1]=(int) k;
        }});
        if(max[0]>0) return (char) max[1];
        return '0';
    }
            
    
    public char writeSubtitles(File file,JTextArea area){
        BufferedReader br;
            try {
                br = new BufferedReader(new FileReader(file));
                char type=getType(br);
                if(type=='0'){
                    br.close();
                    return '0';
                }
                br = new BufferedReader(new FileReader(file));
                switch(type){
                        case '{': this.writeMicroDVD(br,area);
                                  break;
                        case '>': this.writeSubRip(br,area);
                                  break;
                        default : return '0';
                    }
                br.close();
                return type;      
            }
            catch (FileNotFoundException ex) {
                Logger.getLogger(SubchangerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(IOException e){
                e.printStackTrace();
            }
        return '0';
    }
    
    public void writeMicroDVD(BufferedReader br,JTextArea area) throws IOException{
        String line="";
        int c;
        while ((c = br.read()) != -1) {
            char s=(char) c;
            line=line+s;
        }
        area.append(line);
    }
    
    public void writeSubRip(BufferedReader br,JTextArea area) throws IOException{
        String line="";
        int c;
        while ((c = br.read()) != -1) {
            char s=(char) c;
            line=line+s;
        }
        area.append(line);
    }
}
