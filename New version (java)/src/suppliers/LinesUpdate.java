/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 *
 * @author Matmozaur
 */
public class LinesUpdate implements CaretListener{

    JTextArea area;
    JLabel statusBar;
    public LinesUpdate(JTextArea area, JLabel statusBar) {
        this.area=area;
        this.statusBar=statusBar;
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        int lineNumber=0, column=0, pos=0;

        try
        {
        pos=area.getCaretPosition();
        lineNumber=area.getLineOfOffset(pos);
        column=pos-area.getLineStartOffset(lineNumber);
        }catch(Exception excp){excp.printStackTrace();}
        if(area.getText().length()==0){lineNumber=0; column=0;};
        statusBar.setText("||       Ln "+(lineNumber+1)+", Col "+(column+1));
    }
    
    
}
