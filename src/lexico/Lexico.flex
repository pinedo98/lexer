package lexico;
import static lexico.Token.*;

%%
%class Lexico
%type Token
%line
%unicode

L=[a-zA-Z]+
D=[0-9]+
LU=[a-zA-Z]
DU=[0-9]
espacio=[ \t\r\n]+
CA="\""[^\"\n]*"\"" | "\"""\""
LorD = {LU}|{DU}



%{
    public int getLine() {
    return yyline;
    }
%}

%{
    public String lexeme;
%}
%%

programa {lexeme=yytext(); return programa;}
inicio {lexeme=yytext(); return inicio;}
fin {lexeme=yytext(); return fin;}
entrada {lexeme=yytext(); return entrada;}
salida {lexeme=yytext(); return salida;}
entero {lexeme=yytext(); return entero;}
real {lexeme=yytext(); return real;}
cadena {lexeme=yytext(); return cadena;}
si {lexeme=yytext(); return si;}
sino {lexeme=yytext(); return sino;}
entonces {lexeme=yytext(); return entonces;}
mientras {lexeme=yytext(); return mientras;}
repetir {lexeme=yytext(); return repetir;}
hasta {lexeme=yytext(); return hasta;}
limpiar {lexeme=yytext(); return limpiar;}
ejecutar {lexeme=yytext(); return ejecutar;}
posxy {lexeme=yytext(); return posxy;}
proc {lexeme=yytext(); return proc;}


{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"\\".* {lexeme=yytext(); return Comentario;}
" . " {/*Ignore*/}
". " {/*Ignore*/}
" ." {/*Ignore*/}
"+" {lexeme=yytext(); return Suma;}
"-" {lexeme=yytext(); return Resta;}
"*" {lexeme=yytext(); return Multiplicacion;}
"/" {lexeme=yytext(); return Division;}
"%" {lexeme=yytext(); return Modulo;}
"=" {lexeme=yytext(); return Igual;}
">=" {lexeme=yytext(); return MayorIgual;}
">" {lexeme=yytext(); return Mayor;}
"<=" {lexeme=yytext(); return MenorIgual;}
"==" {lexeme=yytext(); return IgualIgual;}
"<" {lexeme=yytext(); return Menor;}
"!=" {lexeme=yytext(); return Diferente;}
";" {lexeme=yytext(); return PuntoYComa;}
"]" {lexeme=yytext(); return CierraCorchete;}
"[" {lexeme=yytext(); return AbreCorchete;}
"}" {lexeme=yytext(); return CierraLlave;}
"{" {lexeme=yytext(); return AbreLlave;}
"," {lexeme=yytext(); return Coma;}
"." {/* Ignore */}
"\"" {/* Ignore */}
":" {lexeme=yytext(); return DosPuntos;}
")" {lexeme=yytext(); return CierraParentesis;}
"(" {lexeme=yytext(); return AbreParentesis;}
":=" {lexeme=yytext(); return DosPuntosIgual;}
"&&" {lexeme=yytext(); return LogicoAND;}
"||" {lexeme=yytext(); return LogicoOR;}
"!" {lexeme=yytext(); return Negacion;}

{LU}{LorD}{0, 5} {lexeme=yytext(); return Identificador;}
{D}+ {lexeme=yytext(); return Enteros;}
({D}+"."{D}+) {lexeme=yytext(); return Reales;}
{CA}+ {lexeme=yytext(); return Cadena;}
{D}{L}+({L}|{D}|".")* {lexeme=yytext(); return ERROR;}
{L}+"."+({L}|{D}|".")* {lexeme=yytext(); return ERROR;}
{D}+"."+({L}|{D}|".")* {lexeme=yytext(); return ERROR;}
{L}{D}"."+({L}|{D}|".")* {lexeme=yytext(); return ERROR;}
".""."+({L}|{D}|".")* {lexeme=yytext(); return ERROR;}
"."+({L}|{D}|".")+ {lexeme=yytext(); return ERROR;}
"\""[^\"\n]* {lexeme=yytext(); return ERROR;}
[^\"\n" "]+"\"" {lexeme=yytext(); return ERROR;}
"+""+"+ {lexeme=yytext(); return ERROR;}
"-""-"+ {lexeme=yytext(); return ERROR;}
"/""/"+ {lexeme=yytext(); return ERROR;}
"*""*"+ {lexeme=yytext(); return ERROR;}
"%""%"+ {lexeme=yytext(); return ERROR;}
"|" {lexeme=yytext(); return ERROR;}
"&" {lexeme=yytext(); return ERROR;}
"|" {lexeme=yytext(); return ERROR;}
{LU}({LU}|{DU})({LU}|{DU})({LU}|{DU})({LU}|{DU})({LU}|{DU})[^\"\n" "]* {lexeme=yytext(); return ERROR;}
"\""([^\"\n]|"\\""\"")*"\"" {lexeme=yytext(); return Cadena;}
 . {lexeme=yytext(); return ERROR;}