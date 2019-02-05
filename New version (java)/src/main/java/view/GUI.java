package view;//package p1;
import controller.files.FileCommunicator;
import controller.suppliers.FontChooser;
import controller.suppliers.TextAreaSupply;
import view.find.FindReplaceManager;
import view.time.TimeDialog;
import java.io.File;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI implements ActionListener, MenuConstants
 {
	private final JFrame frame;
	private final JTextArea ta;
	private final JLabel statusBar;
	private final FileCommunicator FC;
	private FontChooser fontDialog=null;
	private JMenuItem cutItem;
	private JMenuItem copyItem;
	private JMenuItem deleteItem;
	private JMenuItem findItem;
	private JMenuItem gotoItem;
	private JMenuItem selectAllItem;
	private File file;

	public GUI()
	{
		String fileName = "Untitled";
		frame =new JFrame(fileName +" - "+"SubChanger");
		ta=new JTextArea(30,60);
		statusBar=new JLabel("||       Ln 1, Col 1  ",JLabel.RIGHT);
		frame.add(new JScrollPane(ta),BorderLayout.CENTER);
		frame.add(statusBar,BorderLayout.SOUTH);
		frame.add(new JLabel("  "),BorderLayout.EAST);
		frame.add(new JLabel("  "),BorderLayout.WEST);
		createMenuBar(frame);
		frame.pack();
		frame.setLocation(100,50);
		frame.setVisible(true);
		frame.setLocation(150,50);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		FC =FileCommunicator.getInstance();
		ta.addCaretListener(
				e -> {
				int lineNumber=0, column=0, pos=0;

				try{
				pos=ta.getCaretPosition();
				lineNumber=ta.getLineOfOffset(pos);
				column=pos-ta.getLineStartOffset(lineNumber);
				}catch(Exception excp){}
				if(ta.getText().length()==0){lineNumber=0; column=0;}
				statusBar.setText("||       Ln "+(lineNumber+1)+", Col "+(column+1));
				});
		WindowListener frameClose=new WindowAdapter()
		{
		public void windowClosing(WindowEvent we) {
		System.exit(0);
		}
		};
		frame.addWindowListener(frameClose);

	}



	public void actionPerformed(ActionEvent ev) {
		String cmdText=ev.getActionCommand();
		if(cmdText.equals(fileNew))
			newFile();
		else if(cmdText.equals(fileOpen))
			FC.getFR().getUsersFile(this);
		else if(cmdText.equals(fileSave))
			FC.getFW().save(file,ta,frame);
		else if(cmdText.equals(fileSaveAs))
			FC.getFW().saveAs(ta, frame);
		else if(cmdText.equals(fileExit))
			System.exit(0);
		else if(cmdText.equals(editCut))
			ta.cut();
		else if(cmdText.equals(editCopy))
			ta.copy();
		else if(cmdText.equals(editPaste))
			ta.paste();
		else if(cmdText.equals(editDelete))
			ta.replaceSelection("");
		else if(cmdText.equals(editFind)) {
			FindReplaceManager findDialog = new FindReplaceManager(ta);
			findDialog.showDialog(ta);
		}
		else if(cmdText.equals(editGoTo))
			TextAreaSupply.goTo(ta);
		else if(cmdText.equals(editSelectAll))
			ta.selectAll();
		else if(cmdText.equals(editTimeDate))
			ta.insert(new Date().toString(),ta.getSelectionStart());
		else if(cmdText.equals(formatWordWrap)) {
		JCheckBoxMenuItem temp=(JCheckBoxMenuItem)ev.getSource();
		ta.setLineWrap(temp.isSelected());
		}
		else if(cmdText.equals(formatFont)) {
		if(fontDialog==null)
			fontDialog=new FontChooser(ta.getFont());

		if(fontDialog.showDialog(GUI.this.frame,"Choose a font"))
			GUI.this.ta.setFont(fontDialog.createFont());
		}

		else if(cmdText.equals(viewStatusBar)) {
		JCheckBoxMenuItem temp=(JCheckBoxMenuItem)ev.getSource();
		statusBar.setVisible(temp.isSelected());
		}
		else if(cmdText.equals(helpAboutNotepad)) {
		JOptionPane.showMessageDialog(GUI.this.frame,aboutText,"Dedicated 2 u!",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(cmdText.equals(timeManager)) {
			TimeDialog.showDialog(ta);
		}
		else
			statusBar.setText("This "+cmdText+" command is yet to be implemented");
	}


	private JMenuItem createMenuItem(String s, int key, JMenu toMenu, ActionListener al) {
		JMenuItem temp=new JMenuItem(s,key);
		temp.addActionListener(al);
		toMenu.add(temp);

		return temp;
	}

	private JMenuItem createMenuItem(String s, int key, JMenu toMenu, int aclKey, ActionListener al) {
		JMenuItem temp=new JMenuItem(s,key);
		temp.addActionListener(al);
		temp.setAccelerator(KeyStroke.getKeyStroke(aclKey,ActionEvent.CTRL_MASK));
		toMenu.add(temp);
		return temp;
	}

	private JCheckBoxMenuItem createCheckBoxMenuItem(String s, int key, JMenu toMenu, ActionListener al) {
		JCheckBoxMenuItem temp=new JCheckBoxMenuItem(s);
		temp.setMnemonic(key);
		temp.addActionListener(al);
		temp.setSelected(false);
		toMenu.add(temp);
		return temp;
	}

	private JMenu createMenu(String s, int key, JMenuBar toMenuBar) {
		JMenu temp=new JMenu(s);
		temp.setMnemonic(key);
		toMenuBar.add(temp);
		return temp;
	}

	private void createMenuBar(JFrame f) {
		JMenuBar mb=new JMenuBar();
		JMenuItem temp;

		JMenu fileMenu=createMenu(fileText,KeyEvent.VK_F,mb);
		JMenu editMenu=createMenu(editText,KeyEvent.VK_E,mb);
		JMenu formatMenu=createMenu(formatText,KeyEvent.VK_O,mb);
		JMenu viewMenu=createMenu(viewText,KeyEvent.VK_V,mb);
		JMenu helpMenu=createMenu(helpText,KeyEvent.VK_H,mb);
		JMenu timeMenu=createMenu(timeChange,KeyEvent.VK_H,mb);

		createMenuItem(fileNew,KeyEvent.VK_N,fileMenu,KeyEvent.VK_N,this);
		createMenuItem(fileOpen,KeyEvent.VK_O,fileMenu,KeyEvent.VK_O,this);
		createMenuItem(fileSave,KeyEvent.VK_S,fileMenu,KeyEvent.VK_S,this);
		createMenuItem(fileSaveAs,KeyEvent.VK_A,fileMenu,this);
		fileMenu.addSeparator();
		createMenuItem(fileExit,KeyEvent.VK_X,fileMenu,this);

		cutItem=createMenuItem(editCut,KeyEvent.VK_T,editMenu,KeyEvent.VK_X,this);
		copyItem=createMenuItem(editCopy,KeyEvent.VK_C,editMenu,KeyEvent.VK_C,this);
		createMenuItem(editPaste,KeyEvent.VK_P,editMenu,KeyEvent.VK_V,this);
		deleteItem=createMenuItem(editDelete,KeyEvent.VK_L,editMenu,this);
		deleteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0));
		editMenu.addSeparator();
		findItem=createMenuItem(editFind,KeyEvent.VK_F,editMenu,KeyEvent.VK_F,this);
		gotoItem=createMenuItem(editGoTo,KeyEvent.VK_G,editMenu,KeyEvent.VK_G,this);
		editMenu.addSeparator();
		selectAllItem=createMenuItem(editSelectAll,KeyEvent.VK_A,editMenu,KeyEvent.VK_A,this);
		createMenuItem(editTimeDate,KeyEvent.VK_D,editMenu,this).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5,0));
		createCheckBoxMenuItem(formatWordWrap,KeyEvent.VK_W,formatMenu,this);
		createMenuItem(formatFont,KeyEvent.VK_F,formatMenu,this);
		formatMenu.addSeparator();
		createCheckBoxMenuItem(viewStatusBar,KeyEvent.VK_S,viewMenu,this).setSelected(true);
		createMenuItem(helpAboutNotepad,KeyEvent.VK_A,helpMenu,this);
		createMenuItem(timeManager,KeyEvent.VK_A,timeMenu,this);

		MenuListener editMenuListener=new MenuListener()
		{
		   public void menuSelected(MenuEvent e)
			{
			if(GUI.this.ta.getText().length()==0)
			{
			findItem.setEnabled(false);
			gotoItem.setEnabled(false);
			}
			else
			{
			findItem.setEnabled(true);
			selectAllItem.setEnabled(true);
			gotoItem.setEnabled(true);
			}
			if(GUI.this.ta.getSelectionStart()==ta.getSelectionEnd())
			{
			cutItem.setEnabled(false);
			copyItem.setEnabled(false);
			deleteItem.setEnabled(false);
			}
			else
			{
			cutItem.setEnabled(true);
			copyItem.setEnabled(true);
			deleteItem.setEnabled(true);
			}
			}
		   public void menuDeselected(MenuEvent e){}
		   public void menuCanceled(MenuEvent e){}
		};
		editMenu.addMenuListener(editMenuListener);
		f.setJMenuBar(mb);
	}

	private void newFile(){
		file=null;
		ta.setText("");
	}

	 public JFrame getFrame() {
		 return frame;
	 }

	 public void setFile(File file) {
		 this.file = file;
		 this.frame.setTitle(file.getName()+"-SubChanger");
	 }

	 public JTextArea getTa() {
		 return ta;
	 }
 }
