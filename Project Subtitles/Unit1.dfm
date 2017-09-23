object Form1: TForm1
  Left = 300
  Top = 109
  Width = 804
  Height = 510
  Caption = 'Napisy'
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  Menu = MainMenu1
  OldCreateOrder = False
  OnClose = FormClose
  PixelsPerInch = 96
  TextHeight = 13
  object Content: TMemo
    Left = 0
    Top = 0
    Width = 400
    Height = 452
    Align = alClient
    Color = clBtnShadow
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -23
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
    ScrollBars = ssVertical
    TabOrder = 0
    OnKeyDown = ContentKeyDown
  end
  object GroupBox1: TGroupBox
    Left = 400
    Top = 0
    Width = 388
    Height = 452
    Align = alRight
    Caption = 'Napisy'
    TabOrder = 1
    Visible = False
    object Label1: TLabel
      Left = 2
      Top = 15
      Width = 384
      Height = 52
      Align = alTop
      Alignment = taCenter
      Caption = 'Nieznany typ'
      Color = clWhite
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -37
      Font.Name = 'Arial Black'
      Font.Style = []
      ParentColor = False
      ParentFont = False
    end
    object Label2: TLabel
      Left = 100
      Top = 75
      Width = 59
      Height = 13
      Caption = 'O ile (milsec)'
    end
    object Label3: TLabel
      Left = 100
      Top = 123
      Width = 185
      Height = 13
      Caption = 'Od jakiego momentu (h:min:sec:milisec)'
    end
    object Label4: TLabel
      Left = 100
      Top = 168
      Width = 185
      Height = 13
      Caption = 'Do jakiego momentu (h:min:sec:milisec)'
    end
    object Edit1: TEdit
      Left = 100
      Top = 96
      Width = 121
      Height = 21
      TabOrder = 0
      Text = '0'
    end
    object Edit2: TEdit
      Left = 100
      Top = 144
      Width = 121
      Height = 21
      TabOrder = 1
      Text = '0'
    end
    object Edit3: TEdit
      Left = 100
      Top = 192
      Width = 121
      Height = 21
      TabOrder = 2
      Text = '0'
    end
    object Button1: TButton
      Left = 136
      Top = 264
      Width = 75
      Height = 25
      Caption = 'Ok'
      Enabled = False
      TabOrder = 3
      OnClick = Button1Click
    end
  end
  object MainMenu1: TMainMenu
    Left = 96
    Top = 24
    object Plik1: TMenuItem
      Caption = '&Plik'
      object Nowy1: TMenuItem
        Caption = '&Nowy'
        OnClick = Nowy1Click
      end
      object N1: TMenuItem
        Caption = '-'
      end
      object Otwrz1: TMenuItem
        Caption = '&Otw'#243'rz'
        OnClick = Otwrz1Click
      end
      object Zapisz1: TMenuItem
        Caption = 'Za&pisz    Ctrl+S'
        OnClick = Zapisz1Click
      end
      object Zapiszjako1: TMenuItem
        Caption = 'Zapi&sz jako'
        OnClick = Zapiszjako1Click
      end
      object N2: TMenuItem
        Caption = '-'
      end
      object Zakocz1: TMenuItem
        Caption = 'Zako'#324'&cz'
        OnClick = Zakocz1Click
      end
    end
    object Edycja1: TMenuItem
      Caption = '&Edycja'
      object Wytnij1: TMenuItem
        Caption = 'W&ytnij    Ctrl+X'
        OnClick = Wytnij1Click
      end
      object KopiujCtrlC1: TMenuItem
        Caption = 'Kop&iuj    Ctrl+C'
        OnClick = KopiujCtrlC1Click
      end
      object WklejCtrlV1: TMenuItem
        Caption = 'Wkle&j    Ctrl+V'
        OnClick = WklejCtrlV1Click
      end
    end
    object Format1: TMenuItem
      Caption = '&Format'
      object Zawijaniewierszy1: TMenuItem
        Caption = 'Z&awijanie wierszy'
        OnClick = Zawijaniewierszy1Click
      end
      object czcionka1: TMenuItem
        Caption = '&Czcionka'
        OnClick = czcionka1Click
      end
    end
    object Pomoc1: TMenuItem
      Caption = 'P&omoc'
      object Stronaprojektu1: TMenuItem
        Caption = 'Strona projektu'
      end
    end
    object Dzialanie1: TMenuItem
      Caption = 'Dzialanie'
      object Przyspieszanie1: TMenuItem
        Caption = 'Przyspieszanie'
        OnClick = Przyspieszanie1Click
      end
      object Opoznianie1: TMenuItem
        Caption = 'Opoznianie'
        OnClick = Opoznianie1Click
      end
    end
    object Jezyk1: TMenuItem
      Caption = 'Jezyk'
      object Polski1: TMenuItem
        Caption = 'Polski'
        Checked = True
        OnClick = Polski1Click
      end
      object Angielski1: TMenuItem
        Caption = 'Angielski'
        OnClick = Angielski1Click
      end
    end
  end
  object OpenDialog1: TOpenDialog
    Filter = 'Pliki tekstowe (TXT)|*.txt|Wszystkie pliki|*.*'
    Left = 40
    Top = 80
  end
  object SaveDialog1: TSaveDialog
    Filter = 'Plik tekstowy (TXT)|*.txt|Dowolny plik|*.*'
    Options = [ofOverwritePrompt, ofHideReadOnly, ofEnableSizing]
    Left = 32
    Top = 32
  end
  object FontDialog1: TFontDialog
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -11
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    MinFontSize = 0
    MaxFontSize = 0
    Left = 16
  end
end
