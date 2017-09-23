
#ifndef FileOpen
#define FileOpen

#include <vcl.h>
#pragma hdrstop


#include "Unit1.h"
#include "Unit2.h"
#include <iostream>
#include <fstream>
#include <cstdlib>
#include <string>

using namespace std;


void _fastcall TForm1::OpenFile(String File_Name)
{
        string name1=File_Name.c_str();
        const char* name=name1.c_str();
        char c,d='a';
        string line="";
        int counter=0;
        fstream OldFile;
        fstream TempFile;
        OldFile.open(name, ios::in);
        TempFile.open("Temporary.txt",ios::out | ios::trunc  );
        while(!OldFile.eof())
        {
               OldFile.get(c);
               if(c!=10)
               {
                        if(c=='{'||c=='[')
                        {
                                if(counter>1)
                                {
                                        counter=0;
                                        if(d!=10) line=line+"\n";
                                        TempFile<<line;
                                        line=c;
                                }
                                else line=line+c;
                                counter++;

                        }
                        else line=line+c;
                        d=c;
               }

        }
        TempFile<<line;
        OldFile.close();
        TempFile.close();

         Content->Lines->LoadFromFile("Temporary.txt");
         remove("Temporary.txt");

}



char CheckType(string A[5])
{
        string y=A[1].c_str();
        int N=2,X=3;
       string chooses="oabcd";
       int i=1;
       int C[8];
       C[0]=1;
       while(i<8)
       {
                C[i]=0;
                i++;
       }
       i=0;
       while(i<5)
       {
                switch(A[i][0])
                {
                        case '{': C[1]++; break;
                        case '[': C[2]++; break;
                        default: break;

                }

                i++;
        }
       int x=X,n=N;
        while(x>0)
        {
                while(n>=0)
                {
                        if(C[n]>=x) return chooses[n];
                        n--;
                }
                n=N;
                x--;
        }
        return 'o';
}

//-------------------------------------------------
void __fastcall TForm1::DealWithType(char type)
{
        switch(type)
        {
                case 'o':
                {
                        Label1->Caption="Nie rozpoznano";
                        Button1->Enabled=false;
                        break;
                }
                case 'a':
                {
                        Label2->Caption="O ile(klatki 1s~27klatek)";
                        Button1->Enabled=true;
                        break;
                }
                case 'b':
                {
                        Label2->Caption="O ile(milidecysec)";
                        Button1->Enabled=true;
                        break;
                }
                default:
                {
                        Label1->Caption="Nie rozpoznano";
                        Button1->Enabled=false;
                }

        }
}







#endif