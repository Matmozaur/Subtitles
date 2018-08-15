#ifndef Language
#define Language

#include <vcl.h>
#pragma hdrstop


#include "Unit1.h"
#include "Unit2.h"
#include <iostream>
#include <fstream>
#include <cstdlib>
#include <string>

void _fastcall TForm1::LangChange(char lang,char l)
{
          if((lang=='p')&&(l=='e'))
          {
                Plik1->Caption="&File";
                Edycja1->Caption="&Edit";
                Format1->Caption="&View";
                Pomoc1->Caption="&Help";
                Dzialanie1->Caption="&Change Subtitles";
                Jezyk1->Caption="Language";
                Nowy1->Caption="New";
                Otwrz1->Caption="Open";
                Zapisz1->Caption="Save";
                Zapiszjako1->Caption="Save as";
                Zakocz1->Caption="Close";
                Wytnij1->Caption="&Cut Ctrl+X";
                WklejCtrlV1->Caption="Paste Ctrl+V";
                KopiujCtrlC1->Caption="Copy Ctrl+C";
                Stronaprojektu1->Caption="Website";
                Przyspieszanie1->Caption="Faster";
                Opoznianie1->Caption="Slower";



                Polski1->Caption="Polish";
                Angielski1->Caption="English";
                Polski1->Checked=false;
                Angielski1->Checked=true;
                lang='e';
          }

          if((lang=='e')&&(l=='p'))
          {
                Plik1->Caption="&Plik";
                Edycja1->Caption="&Edycja";
                Format1->Caption="&Format";
                Pomoc1->Caption="&Pomoc";
                Dzialanie1->Caption="&Dzia³anie";
                Jezyk1->Caption="Jêzyk";
                Nowy1->Caption="Nowy";
                Otwrz1->Caption="Otwórz";
                Zapisz1->Caption="Zapisz";
                Zapiszjako1->Caption="Zapisz jako";
                Zakocz1->Caption="Zamknij";
                Wytnij1->Caption="&Wytnij Ctrl+X";
                WklejCtrlV1->Caption="Wklej Ctrl+V";
                KopiujCtrlC1->Caption="Kopiuj Ctrl+C";
                Stronaprojektu1->Caption="Strona projektu";
                Przyspieszanie1->Caption="Przyspieszanie";
                Opoznianie1->Caption="OpóŸnianie";


                Polski1->Caption="Polski";
                Angielski1->Caption="Angieslki";
                Polski1->Checked=true;
                Angielski1->Checked=false;
                lang='p';
          }
}

#endif