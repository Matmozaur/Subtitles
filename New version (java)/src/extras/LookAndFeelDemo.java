package extras;
//package p1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/***************************************************/
class LookAndFeelDemo extends JFrame
{
JLabel myLabel;
JMenuBar jmb;
JMenu fileMenu;

LookAndFeelDemo()
{
super("Look and Feel Demo");
add(myLabel=new JLabel("This is a Label"));
add(new JButton("Button")); 
add(new JCheckBox("CheckBox"));
add(new JRadioButton("RadioButton"));
setLayout(new FlowLayout());
setSize(350,350);
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
jmb=new JMenuBar();
setJMenuBar(jmb);
fileMenu=new JMenu("Look and Feel");
jmb.add(fileMenu);
LookAndFeelMenu.createLookAndFeelMenuItem(fileMenu,this);
setVisible(true);
}
////////////////////////

///////////////////////
public static void main(String[] args)
{
new LookAndFeelDemo();
}
////////////////////////
}
/************************/
