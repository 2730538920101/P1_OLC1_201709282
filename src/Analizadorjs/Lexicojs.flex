package Analizadorjs;
import java_cup.runtime.*;
import ASTjs.Erroresjs.*;

%%

%class Lexicojs
%public 
%line 
%column 
%cup 
%unicode


%init{ 
    yyline = 1; 
    yycolumn = 1; 
%init} 

LETRA =[a-zA-ZÑñ]+
NUMERO =[0-9]+ 
DECIMAL ={NUMERO}("." [0-9]+)?
CADENA =[\"\“\'] [^\"\”\'\n]* [\"\”\']
BLANCOS=[ \t\r\f]+
IDEN =({LETRA}|("_"{LETRA})|({LETRA}"_"))({LETRA}|{NUMERO}|"_")*
DEFINIR_VARIABLE = "var"|"let"|"const"
COMENTSIMPLE =("//".*\r\n*)|("//".*\n*)|("//".*\r\n*)
COMENTARIO_MULTI =  \/\*([^\*\/]|[^\*]\/|\*[^\/])*\*\/

%%
"=" {return new Symbol(sym.igual,yyline,yycolumn,yytext());}
"(" {return new Symbol(sym.apertura_parentesis,yyline,yycolumn,yytext());}
")" {return new Symbol(sym.cierre_parentesis,yyline,yycolumn,yytext());}
"==" {return new Symbol(sym.igualacion,yyline,yycolumn,yytext());}
"!=" {return new Symbol(sym.diferencia,yyline,yycolumn,yytext());}
"<" {return new Symbol(sym.menor_que,yyline,yycolumn,yytext());}
">" {return new Symbol(sym.mayor_que,yyline,yycolumn,yytext());}
"<=" {return new Symbol(sym.menor_igual,yyline,yycolumn,yytext());}
">=" {return new Symbol(sym.mayor_igual,yyline,yycolumn,yytext());}
"&&" {return new Symbol(sym.and,yyline,yycolumn,yytext());}
"||" {return new Symbol(sym.or,yyline,yycolumn,yytext());}
"!" {return new Symbol(sym.not,yyline,yycolumn,yytext());}
"+" {return new Symbol(sym.suma,yyline,yycolumn,yytext());}
"-" {return new Symbol(sym.resta,yyline,yycolumn,yytext());}
"*" {return new Symbol(sym.multiplicacion,yyline,yycolumn,yytext());}
"/" {return new Symbol(sym.division,yyline,yycolumn,yytext());}
"**" {return new Symbol(sym.potencia,yyline,yycolumn,yytext());}
"%" {return new Symbol(sym.modulo,yyline,yycolumn,yytext());}
"true" {return new Symbol(sym.true_t,yyline,yycolumn,yytext());}
"false" {return new Symbol(sym.false_t,yyline,yycolumn,yytext());}
{DEFINIR_VARIABLE} {return new Symbol(sym.definir_variable,yyline,yycolumn,yytext());}
";" {return new Symbol(sym.fin_de_linea,yyline,yycolumn,yytext());}
"," {return new Symbol(sym.coma,yyline,yycolumn,yytext());}
"require" {return new Symbol(sym.importar,yyline,yycolumn,yytext());}
[\n]+ {return new Symbol(sym.salto,yyline,yycolumn,yytext());}
"console.log" {return new Symbol(sym.consola,yyline,yycolumn,yytext());}
"if" {return new Symbol(sym.if_t,yyline,yycolumn,yytext());}
"else" {return new Symbol(sym.else_t,yyline,yycolumn,yytext());}
"else if" {return new Symbol(sym.else_if,yyline,yycolumn,yytext());}
"for" {return new Symbol(sym.for_t,yyline,yycolumn,yytext());}
"while" {return new Symbol(sym.while_t,yyline,yycolumn,yytext());}
"do" {return new Symbol(sym.do_t,yyline,yycolumn,yytext());}
"switch" {return new Symbol(sym.switch_t,yyline,yycolumn,yytext());}
"case" {return new Symbol(sym.case_t,yyline,yycolumn,yytext());}
"default" {return new Symbol(sym.default_t,yyline,yycolumn,yytext());}
"break" {return new Symbol(sym.break_t,yyline,yycolumn,yytext());}
"++" {return new Symbol(sym.suma_doble,yyline,yycolumn,yytext());}
"--" {return new Symbol(sym.resta_doble,yyline,yycolumn,yytext());}
"{" {return new Symbol(sym.apertura_llave,yyline,yycolumn,yytext());}
"}" {return new Symbol(sym.cierre_llave,yyline,yycolumn,yytext());}
":" {return new Symbol(sym.dos_puntos,yyline,yycolumn,yytext());}
"class" {return new Symbol(sym.definir_clase,yyline,yycolumn,yytext());}

{COMENTSIMPLE} {return new Symbol(sym.comentsimple,yyline,yycolumn,yytext());}
{COMENTARIO_MULTI} {return new Symbol(sym.comentario_multi,yyline,yycolumn,yytext());}
{BLANCOS} {}
{DECIMAL} {return new Symbol(sym.decimal,yyline,yycolumn,yytext());}
{CADENA} {return new Symbol(sym.cadena,yyline,yycolumn,yytext());}
{IDEN} {return new Symbol(sym.iden, yyline,yycolumn,yytext());}

. {
    System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yycolumn);
    Analizadorjs.errores.addError(new MiErrorjs(yyline, yycolumn, TipoErrorjs.LEXICO, 
    "Se detectó un error léxico (caracter "+yytext()+")", yytext()));
}