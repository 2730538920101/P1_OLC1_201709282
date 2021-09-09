package Analizadorfca;
import java_cup.runtime.*;
import ASTfca.Erroresfca.*;


%%
%class Lexicofca
%public 
%line 
%column 
%cup 
%unicode
%ignorecase

%init{

    yyline = 1;
    yycolumn = 1;

%init}

LETRA =[a-zA-ZñÑ]+
NUMERO =[0-9]+
DECIMAL ={NUMERO}("." [0-9]+)?
ID =({LETRA}|("_"{LETRA}))({LETRA}|{NUMERO}|"_")*
CADENA =[\"\“\'] [^\"\”\'\n]* [\"\”\']
BLANCOS =[ \t\r\f\n]+
COMENTSIMPLE =("##".*\r\n*)|("##".*\n*)|("##".*\r\n*)
COMENTARIO_MULTI =  \#\*([^\*\#]|[^\*]\#|\*[^\#])*\*\#

%%


";" {return new Symbol(sym.fin_de_linea,yyline,yycolumn,yytext());}
"Compare" {return new Symbol(sym.comparar,yyline,yycolumn,yytext());}
"DefinirGlobales" {return new Symbol(sym.definir_globales,yyline,yycolumn,yytext());}
"string" {return new Symbol(sym.tipo_de_dato_string,yyline,yycolumn,yytext());}
"double" {return new Symbol(sym.tipo_de_dato_double,yyline,yycolumn,yytext());}
"{" {return new Symbol(sym.apertura_llave,yyline,yycolumn,yytext());}
"}" {return new Symbol(sym.cierre_llave,yyline,yycolumn,yytext());}
"[" {return new Symbol(sym.apertura_corchete,yyline,yycolumn,yytext());}
"]" {return new Symbol(sym.cierre_corchete,yyline,yycolumn,yytext());}
"(" {return new Symbol(sym.apertura_parentesis,yyline,yycolumn,yytext());}
")" {return new Symbol(sym.cierre_parentesis,yyline,yycolumn,yytext());}
"GraficaBarras" {return new Symbol(sym.grafica_de_barras,yyline,yycolumn,yytext());}
"Titulo" {return new Symbol(sym.titulo_grafica,yyline,yycolumn,yytext());}
"Ejex" {return new Symbol(sym.ejex,yyline,yycolumn,yytext());}
"Valores" {return new Symbol(sym.valores_grafica,yyline,yycolumn,yytext());}
"TituloX" {return new Symbol(sym.titulo_ejex,yyline,yycolumn,yytext());}
"TituloY" {return new Symbol(sym.titulo_ejey,yyline,yycolumn,yytext());}
"GraficaPie" {return new Symbol(sym.grafica_de_pie,yyline,yycolumn,yytext());}
"GraficaLineas" {return new Symbol(sym.grafica_de_lineas,yyline,yycolumn,yytext());}
"Archivo" {return new Symbol(sym.archivo_grafica_lineas,yyline,yycolumn,yytext());}
"=" {return new Symbol(sym.igual,yyline,yycolumn,yytext());}
"$" {return new Symbol(sym.concatenacion,yyline,yycolumn,yytext());}
":" {return new Symbol(sym.dos_puntos,yyline,yycolumn,yytext());}
"," {return new Symbol(sym.coma,yyline,yycolumn,yytext());}
"PuntajeGeneral" {return new Symbol(sym.puntaje_general,yyline,yycolumn,yytext());}
"PuntajeEspecifico" {return new Symbol(sym.puntaje_especifico,yyline,yycolumn,yytext());}
"GenerarReporteEstadistico" {return new Symbol(sym.generar_reporte_estadistico,yyline,yycolumn,yytext());}

\n {}

{BLANCOS} {}
{DECIMAL} {return new Symbol(sym.decimal,yyline,yycolumn,yytext());}
{CADENA} {return new Symbol(sym.cadena,yyline,yycolumn,yytext());}
{COMENTSIMPLE} {}
{COMENTARIO_MULTI} {}
{ID} {return new Symbol(sym.id,yyline,yycolumn,yytext());}

. {
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yycolumn);
    Analizadorfca.errores.add(new MiErrorfca(yyline, yycolumn, TipoErrorfca.LEXICO, 
    "Se detectó un error léxico (caracter "+yytext()+")", yytext()));
}