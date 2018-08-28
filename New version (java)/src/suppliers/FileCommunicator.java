
package suppliers;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    
    
    public void writeSubtitles(File file,JTextArea area){
        BufferedReader br;
            try {
                br = new BufferedReader(new FileReader(file));
                String st;
                while ((st = br.readLine()) != null)
                  area.append(st);
                  area.append("xxxxxxxxxxxxxx");
            }
            catch (FileNotFoundException ex) {
                Logger.getLogger(SubchangerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(IOException e){
                e.printStackTrace();
            }
    }
}
