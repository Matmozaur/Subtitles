#ifndef SubChangeH
#define SubChangeH

#include <vcl.h>
#pragma hdrstop


#include "Unit1.h"
#include "Unit2.h"
#include "Unit1.h"
#include "Unit2.h"
#include <iostream>
#include <fstream>
#include <cstdlib>
#include <string>

using namespace std;

int first,secound;
int StrToInt(String s);
char CheckType(String A[10]);
string AddA(string & linia, int n, int s,int e);
string MinusA(string & linia, int n, int s,int e);


void _fastcall TForm1::ChangeSub(bool l,String name1,String n1, String s1, String e1,char type)
{
        string name2=name1.c_str(),n2=n1.c_str(),s2=s1.c_str(),e2=e1.c_str();
        const char *name=name2.c_str(),*n3=n2.c_str(),*s3=s2.c_str(),*e3=e2.c_str();
        int n=atoi(n3),s=atoi(s3),e=atoi(e3);
        string OldLine;
	string NewLine;
        fstream OldFile;
        fstream TempFile;
        OldFile.open(name, ios::in);
        TempFile.open("Temporary.txt",ios::out | ios::trunc  );

        while(!OldFile.eof())
        {
                getline(OldFile, OldLine);
                switch(type)
                case 'a':
                        {
                                if(OldLine[0]==123)
        	                {
        			        if(l==true) NewLine=AddA(OldLine,n,s,e);
                                        else NewLine=MinusA(OldLine,n,s,e);
        			        TempFile<<"{"<<first<<"}"<<"{"<<secound<<"}"<<NewLine<<endl;
                                }
        	                else TempFile<<OldLine<<endl;
                        }
                /*case 'b':
                        {
                              if(OldLine[0]==123)
        	                {
        			        if(l==true) NewLine=AddB(OldLine,n,s,e);
                                        else NewLine=MinusB(OldLine,n,s,e);
        			        TempFile<<"{"<<first<<"}"<<"{"<<secound<<"}"<<NewLine<<endl;
                                }
        	                else TempFile<<OldLine<<endl;
                        }*/
        }
        OldFile.close();
        TempFile.close();
         Content->Lines->LoadFromFile("Temporary.txt");
         remove("Temporary.txt");

}



string AddA(string & linia, int n, int s,int e)
{
	int c,d;
	string a,b;
	int i=2;
	a+=linia[1];
	while(linia[i]!=125)
    {
        a=a+linia[i];
        i++;
    }

        b+=linia[i+2];
        i=i+3;
        while(linia[i]!=125)
        {
                b=b+linia[i];
                i++;
        }
        c=atoi(a.c_str());
        d=atoi(b.c_str());
        if(atoi(a.c_str())>=s&&atoi(a.c_str())<=e)
        {
                first=c+n;
                secound=d+n;
        }
        else
        {
                first=c;
                secound=d;
        }
        int u=0;
        i++;
        string newline;
        while(i<linia.length())
        {
                newline+=linia[i];
                i++;
                u++;

        }
        return newline;
}
string MinusA(string & linia, int n, int s,int e)
{
	int c,d;
	string a,b;
	int i=2;
	a+=linia[1];
	while(linia[i]!=125)
    {
        a=a+linia[i];
        i++;
    }
        b+=linia[i+2];
        i=i+3;
        while(linia[i]!=125)
        {
                b=b+linia[i];
                i++;
        }
        c=atoi(a.c_str());
        d=atoi(b.c_str());
        if(atoi(a.c_str())>=s&&atoi(a.c_str())<=e)
        {
                first=c+n;
                secound=d+n;
        }
        else
        {
                first=c;
                secound=d;
        }
        int u=0;
        i++;
        string newline;
        while(i<linia.length())
        {
                newline+=linia[i];
                i++;
                u++;

        }
        return newline;

}




#endif
