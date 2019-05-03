package lexer;
import static lexer.Tokens.*;

%%
%class Lexer
%type Tokens
%unicode
%line

L=[a-zA-Z]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
CA="\""[^\"\n]*"\"" | "\"""\""

%{
    public String lexeme;
%}
%%

PROG {lexeme=yytext(); return Prog;}
VAR {lexeme=yytext(); return Var;}
PROC {lexeme=yytext(); return Proc;}
INICIO {lexeme=yytext(); return Inicio;}
FIN {lexeme=yytext(); return Final;}
ENTERO {lexeme=yytext(); return Entero;}
REAL {lexeme=yytext(); return Real;}
STRING {lexeme=yytext(); return String;}
LIMPIAR {lexeme=yytext(); return Limpiar;}
VEXY {lexeme=yytext(); return Vexy;}
LEER {lexeme=yytext(); return Leer;}
ESCRIBIR {lexeme=yytext(); return Escribir;}
REPITE {lexeme=yytext(); return Repite;}
HASTA {lexeme=yytext(); return Hasta;}
MIENTRAS {lexeme=yytext(); return Mientras;}
SI {lexeme=yytext(); return Si;}
SINO {lexeme=yytext(); return SiNo;}
EJCUTA {lexeme=yytext(); return Ejecuta;}
AND {lexeme=yytext(); return And;}
OR {lexeme=yytext(); return Or;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"\\".* {/*Ignore*/}
"+" {lexeme=yytext(); return Suma;}
"-" {lexeme=yytext(); return Resta;}
"*" {lexeme=yytext(); return Multiplicacion;}
"/" {lexeme=yytext(); return Division;}
"=" {lexeme=yytext(); return Igual;}
">=" {lexeme=yytext(); return MayorIgual;}
">" {lexeme=yytext(); return Mayor;}
"<=" {lexeme=yytext(); return MenorIgual;}
"<" {lexeme=yytext(); return Menor;}
"<>" {lexeme=yytext(); return Diferente;}
";" {lexeme=yytext(); return PuntoYComa;}
"]" {lexeme=yytext(); return CierraCorchete;}
"[" {lexeme=yytext(); return AbreCorchete;}
"," {lexeme=yytext(); return Coma;}
":" {lexeme=yytext(); return DosPuntos;}
")" {lexeme=yytext(); return CierraParentesis;}
"(" {lexeme=yytext(); return AbreParentesis;}
":=" {lexeme=yytext(); return DosPuntosIgual;}

{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
{D}+ {lexeme=yytext(); return Enteros;}
({D}+"."{D}+) {lexeme=yytext(); return Reales;}
"."{D}+ {lexeme=yytext(); return Reales;}
{CA}+ {lexeme=yytext(); return Cadena;}
{D}{L}+ {lexeme=yytext(); return ERROR;}
{L}+"."+({L}|{D})* {lexeme=yytext(); return ERROR;}
{L}{D}"."+({L}|{D})* {lexeme=yytext(); return ERROR;}
".""."+({L}|{D})* {lexeme=yytext(); return ERROR;}
"."+{L}+{D}* {lexeme=yytext(); return ERROR;}
"."+{D}*{L}+ {lexeme=yytext(); return ERROR;}
"\""[^\"\n]* {lexeme=yytext(); return ERROR;}
 . {return ERROR;}