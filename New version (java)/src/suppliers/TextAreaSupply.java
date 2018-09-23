/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Matmozaur
 */
public class TextAreaSupply {

    public TextAreaSupply() {
    }
    
    public static void goTo(JTextArea ta){
        int lineNumber=0;
        try
        {
        lineNumber=ta.getLineOfOffset(ta.getCaretPosition())+1;
        String tempStr=JOptionPane.showInputDialog(ta,"Enter Line Number:",""+lineNumber);
        if(tempStr==null)
                {return;}
        lineNumber=Integer.parseInt(tempStr);
        ta.setCaretPosition(ta.getLineStartOffset(lineNumber-1));
        }catch(Exception e){}
    }
}
