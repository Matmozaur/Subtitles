package controller.files;
import java.io.File;


import javax.swing.filechooser.FileFilter;

class MyFileFilter extends FileFilter
{
private String extension;
private String description;

MyFileFilter(final String ext)
{
setExtension(ext);
setDescription("Text Files(*.txt)");
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

private void setDescription(String desc)
{
if(desc==null)
	description= "All Files(*.*)";
else
	description= desc;
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