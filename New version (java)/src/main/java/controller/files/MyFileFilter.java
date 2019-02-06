package controller.files;
import java.io.File;


import javax.swing.filechooser.FileFilter;

class MyFileFilter extends FileFilter
{
private String extension;
private String description;

MyFileFilter()
{
setExtension(".txt");
setDescription();
}

public boolean accept(File f)
{
final String filename=f.getName();

	return f.isDirectory() ||
			extension == null ||
			filename.toUpperCase()
					.endsWith(extension.toUpperCase());

}
public String getDescription()
{
return description;
}

private void setDescription()
{
if("Text Files(*.txt)" ==null)
	description= "All Files(*.*)";
else
	description= "Text Files(*.txt)";
}

private void setExtension(String ext)
{
if(ext==null)
	{extension=null;  return;}

extension= ext.toLowerCase();
if(!ext.startsWith("."))
	extension="."+extension;
}

}