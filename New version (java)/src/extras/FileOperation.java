package extras;
//package p1;
import java.io.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
//import p1.FontChooser;
//import p1.FontDialog;
//import p1.FindDialog;
//import p1.LookAndFeelMenu;
//import p1.MyFileFilter;
/************************************/
public class FileOperation
{
Notepad npd;

boolean saved;
boolean newFileFlag;
String fileName;
String applicationTitle="Javapad";

File fileRef;
JFileChooser chooser;
/////////////////////////////
boolean isSave(){return saved;}
void setSave(boolean saved){this.saved=saved;}
String getFileName(){return new String(fileName);}
void setFileName(String fileName){this.fileName=new String(fileName);}
/////////////////////////
FileOperation(Notepad npd)
{
this.npd=npd;

saved=true;
newFileFlag=true;
fileName=new String("Untitled");
fileRef=new File(fileName);
this.npd.f.setTitle(fileName+" - "+applicationTitle);

chooser=new JFileChooser();
chooser.addChoosableFileFilter(new MyFileFilter(".java","Java Source Files(*.java)"));
chooser.addChoosableFileFilter(new MyFileFilter(".txt","Text Files(*.txt)"));
chooser.setCurrentDirectory(new File("."));

}
//////////////////////////////////////

boolean saveFile(File temp)
{
FileWriter fout=null;
try
{
fout=new FileWriter(temp);
fout.write(npd.ta.getText());
}
catch(IOException ioe){updateStatus(temp,false);return false;}
finally
{try{fout.close();}catch(IOException excp){}}
updateStatus(temp,true);
return true;
}
////////////////////////
boolean saveThisFile()
{

if(!newFileFlag)
	{return saveFile(fileRef);}

return saveAsFile();
}
////////////////////////////////////
boolean saveAsFile()
{
File temp=null;
chooser.setDialogTitle("Save As...");
chooser.setApproveButtonText("Save Now"); 
chooser.setApproveButtonMnemonic(KeyEvent.VK_S);
chooser.setApproveButtonToolTipText("Click me to save!");

do
{
if(chooser.showSaveDialog(this.npd.f)!=JFileChooser.APPROVE_OPTION)
	return false;
temp=chooser.getSelectedFile();
if(!temp.exists()) break;
if(   JOptionPane.showConfirmDialog(
	this.npd.f,"<html>"+temp.getPath()+" already exists.<br>Do you want to replace it?<html>",
	"Save As",JOptionPane.YES_NO_OPTION
				)==JOptionPane.YES_OPTION)
	break;
}while(true);


return saveFile(temp);
}

////////////////////////
boolean openFile(File temp)
{
FileInputStream fin=null;
BufferedReader din=null;

try
{
fin=new FileInputStream(temp);
din=new BufferedReader(new InputStreamReader(fin));
String str=" ";
while(str!=null)
{
str=din.readLine();
if(str==null)
break;
this.npd.ta.append(str+"\n");
}

}
catch(IOException ioe){updateStatus(temp,false);return false;}
finally
{try{din.close();fin.close();}catch(IOException excp){}}
updateStatus(temp,true);
this.npd.ta.setCaretPosition(0);
return true;
}
///////////////////////
void openFile()
{
if(!confirmSave()) return;
chooser.setDialogTitle("Open File...");
chooser.setApproveButtonText("Open this"); 
chooser.setApproveButtonMnemonic(KeyEvent.VK_O);
chooser.setApproveButtonToolTipText("Click me to open the selected file.!");

File temp=null;
do
{
if(chooser.showOpenDialog(this.npd.f)!=JFileChooser.APPROVE_OPTION)
	return;
temp=chooser.getSelectedFile();

if(temp.exists())	break;

JOptionPane.showMessageDialog(this.npd.f,
	"<html>"+temp.getName()+"<br>file not found.<br>"+
	"Please verify the correct file name was given.<html>",
	"Open",	JOptionPane.INFORMATION_MESSAGE);

} while(true);

this.npd.ta.setText("");

if(!openFile(temp))
	{
	fileName="Untitled"; saved=true; 
	this.npd.f.setTitle(fileName+" - "+applicationTitle);
	}
if(!temp.canWrite())
	newFileFlag=true;

}
////////////////////////
void updateStatus(File temp,boolean saved)
{
if(saved)
{
this.saved=true;
fileName=new String(temp.getName());
if(!temp.canWrite())
	{fileName+="(Read only)"; newFileFlag=true;}
fileRef=temp;
npd.f.setTitle(fileName + " - "+applicationTitle);
npd.statusBar.setText("File : "+temp.getPath()+" saved/opened successfully.");
newFileFlag=false;
}
else
{
npd.statusBar.setText("Failed to save/open : "+temp.getPath());
}
}
///////////////////////
boolean confirmSave()
{
String strMsg="<html>The text in the "+fileName+" file has been changed.<br>"+
	"Do you want to save the changes?<html>";
if(!saved)
{
int x=JOptionPane.showConfirmDialog(this.npd.f,strMsg,applicationTitle,JOptionPane.YES_NO_CANCEL_OPTION);

if(x==JOptionPane.CANCEL_OPTION) return false;
if(x==JOptionPane.YES_OPTION && !saveAsFile()) return false;
}
return true;
}
///////////////////////////////////////
void newFile()
{
if(!confirmSave()) return;

this.npd.ta.setText("");
fileName=new String("Untitled");
fileRef=new File(fileName);
saved=true;
newFileFlag=true;
this.npd.f.setTitle(fileName+" - "+applicationTitle);
}
//////////////////////////////////////
}// end defination of class FileOperation
/************************************/