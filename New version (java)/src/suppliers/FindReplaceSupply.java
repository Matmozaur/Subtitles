/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers;

import javax.swing.JOptionPane;
import view.FindReplaceManager;

/**
 *
 * @author Matmozaur
 */
public class FindReplaceSupply {

    /**
     *
     * @param m
     * @return
     */
    public static int findNext(FindReplaceManager m)
    {

    String s1=m.getJta().getText();
    String s2=m.getFindWhat().getText();

    m.lastIndex=m.getJta().getCaretPosition();

    int selStart=m.getJta().getSelectionStart();
    int selEnd=m.getJta().getSelectionEnd();

    if( m.getUp().isSelected())
    {
        if(selStart!=selEnd)
            m.lastIndex=selEnd-s2.length()-1;
        /*****Notepad doesnt use the else part, but it should be, instead of using caretPosition.***
         * else
         * m.lastIndex=m.lastIndex-s2.length();
         ******/
        
        if(!m.getMatchCase().isSelected())
            m.lastIndex=s1.toUpperCase().lastIndexOf(s2.toUpperCase(),m.lastIndex);
        else
            m.lastIndex=s1.lastIndexOf(s2,m.lastIndex);
    }
    else
    {
        if(selStart!=selEnd)
            m.lastIndex=selStart+1;
        if(!m.getMatchCase().isSelected())
            m.lastIndex=s1.toUpperCase().indexOf(s2.toUpperCase(),m.lastIndex);
        else
            m.lastIndex=s1.indexOf(s2,m.lastIndex);
    }

    return m.lastIndex;
    }
    ///////////////////////////////////////////////

    /**
     *
     * @param m
     */
    public static void findNextWithSelection(FindReplaceManager m)
    {
    int idx=findNext(m);
    if(idx!=-1)
    {
    m.getJta().setSelectionStart(idx);
    m.getJta().setSelectionEnd(idx+m.getFindWhat().getText().length());
    }
    else
            JOptionPane.showMessageDialog(m,
            "Cannot find"+" \""+m.getFindWhat().getText()+"\"",
            "Find",JOptionPane.INFORMATION_MESSAGE);
    }
    //////////////////////////////////////////////

    /**
     *
     * @param m
     */
    public static void replaceNext(FindReplaceManager m)
    {
    // if nothing is selectd
    if(m.getJta().getSelectionStart()==m.getJta().getSelectionEnd()) 
            {findNextWithSelection(m);return;}

    String searchText=m.getFindWhat().getText();
    String temp=m.getJta().getSelectedText();	//get selected text

    //check if the selected text matches the search text then do replacement

    if(
            (m.getMatchCase().isSelected() && temp.equals(searchText))
                                    ||
            (!m.getMatchCase().isSelected() && temp.equalsIgnoreCase(searchText))
      )
            m.getJta().replaceSelection(m.getReplaceWith().getText());

    findNextWithSelection(m);
    }
    //////////////////////////////////////////////

    /**
     *
     * @param m
     * @return
     */
    public static int replaceAllNext(FindReplaceManager m)
    {
    if(m.getUp().isSelected())
            m.getJta().setCaretPosition(m.getJta().getText().length()-1);
    else
            m.getJta().setCaretPosition(0);

    int idx=0;
    int counter=0;
    do
    {
    idx=findNext(m);
    if(idx==-1) break;
    counter++;
    m.getJta().replaceRange(m.getReplaceWith().getText(),idx,idx+m.getFindWhat().getText().length());
    }while(idx!=-1);

    return counter;
    }
}
