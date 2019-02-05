package view.find;


import controller.suppliers.FindReplaceSupply;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public final class FindReplaceManager extends JPanel implements ActionListener
{
    private JTextArea jta;
    public int lastIndex=0;
    JLabel replaceLabel;

    private final TextField findWhat;
    private final JTextField replaceWith;

    private final JCheckBox matchCase;

    private final JRadioButton up;
    private final JRadioButton down;

    JButton findNextButton, replaceButton, replaceAllButton, cancelButton;

    JPanel direction,buttonPanel, findButtonPanel, replaceButtonPanel;
    CardLayout card;

    private boolean ok;
    private JDialog dialog;
    ///////////////////////
    public FindReplaceManager(JTextArea jta)
    {

        this.jta=jta;
        findWhat=new TextField(20);
        replaceWith=new JTextField(20);

        matchCase=new JCheckBox("Match case");

        up=new JRadioButton("Up");
        down=new JRadioButton("Down");

        down.setSelected(true);
        ButtonGroup bg=new ButtonGroup();
        bg.add(up);
        bg.add(down);

        direction=new JPanel();
        Border etched=BorderFactory.createEtchedBorder();
        Border titled=BorderFactory.createTitledBorder(etched,"Direction");
        direction.setBorder(titled);
        direction.setLayout(new GridLayout(1,2));
        direction.add(up);
        direction.add(down);

        JPanel southPanel=new JPanel();
        southPanel.setLayout(new GridLayout(1,2));
        southPanel.add(matchCase);
        southPanel.add(direction);


        findNextButton=new JButton("Find Next");
        replaceButton=new JButton("Replace");
        replaceAllButton=new JButton("Replace All");
        cancelButton=new JButton("Cancel");

        replaceButtonPanel=new JPanel();
        replaceButtonPanel.setLayout(new GridLayout(4,1));
        replaceButtonPanel.add(findNextButton);
        replaceButtonPanel.add(replaceButton);
        replaceButtonPanel.add(replaceAllButton);
        replaceButtonPanel.add(cancelButton);


        JPanel textPanel=new JPanel();
        textPanel.setLayout(new GridLayout(3,2));
        textPanel.add(new JLabel("Find what "));
        textPanel.add(findWhat);
        textPanel.add(replaceLabel=new JLabel("Replace With "));
        textPanel.add(replaceWith);


        setLayout(new BorderLayout());

        add(textPanel,BorderLayout.CENTER);
        add(replaceButtonPanel,BorderLayout.EAST);
        add(southPanel, BorderLayout.SOUTH);

        setSize(200,200);

        findNextButton.addActionListener(this);
        replaceButton.addActionListener(this);
        replaceAllButton.addActionListener(this);

        cancelButton.addActionListener((ActionEvent ev) -> {
            dialog.setVisible(false);
            findWhat.setText("");
            replaceWith.setText("");
            lastIndex=0;

        });

        findWhat.addFocusListener(
                new FocusAdapter(){
                    @Override
                    public void focusLost(FocusEvent te){
                        enableDisableButtons();
                    }
                }
        );
        findWhat.addTextListener((TextEvent te) -> {
            enableDisableButtons();
        });
        enableDisableButtons();
    }
    //////////////////////////
    void enableDisableButtons()
    {
        if(findWhat.getText().length()==0)
        {
            findNextButton.setEnabled(false);
            replaceButton.setEnabled(false);
            replaceAllButton.setEnabled(false);
        }
        else
        {
            findNextButton.setEnabled(true);
            replaceButton.setEnabled(true);
            replaceAllButton.setEnabled(true);
        }
    }
    ///////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent ev)
    {

        if(ev.getSource()==findNextButton)
            FindReplaceSupply.findNextWithSelection(this);
        else if(ev.getSource()==replaceButton)
            FindReplaceSupply.replaceNext(this);
        else if(ev.getSource()==replaceAllButton)
            JOptionPane.showMessageDialog(null,"Total replacements made= "+FindReplaceSupply.replaceAllNext(this));

    }
    //////////////////////////////////////////////
    public boolean showDialog(Component parent )
    {

        Frame owner;
        if(parent instanceof Frame)
            owner=(Frame)parent;
        else
            owner=(Frame)SwingUtilities.getAncestorOfClass(Frame.class,parent);
        if(dialog==null || dialog.getOwner()!=owner)
        {
            dialog=new JDialog(owner,false);
            dialog.add(this);
            dialog.getRootPane().setDefaultButton(findNextButton);
        }

        if(findWhat.getText().length()==0)
            findNextButton.setEnabled(false);
        else
            findNextButton.setEnabled(true);


        replaceButton.setVisible(true);
        replaceAllButton.setVisible(true);
        replaceWith.setVisible(true);
        replaceLabel.setVisible(true);

        //card.show(buttonPanel,"replace");
        dialog.setSize(450,200);
        dialog.setTitle("Replace");


        dialog.setVisible(true);

        //System.out.println(dialog.getWidth()+" "+dialog.getHeight());
        return ok;
    }
//////////////////////////////

    public JTextField getReplaceWith() {
        return replaceWith;
    }

    public JCheckBox getMatchCase() {
        return matchCase;
    }

    public JTextArea getJta() {
        return jta;
    }

    public TextField getFindWhat() {
        return findWhat;
    }

    public JRadioButton getUp() {
        return up;
    }

    public JRadioButton getDown() {
        return down;
    }
}