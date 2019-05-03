/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

/**
 * @author luis1
 */
public enum Tokens {
  Prog(-1),
  Var(-5),
  Proc(-5),
  Inicio(-5),
  Final(-5),
  Entero(-5),
  Real(-5),
  String(-5),
  Limpiar(-5),
  Vexy(-5),
  Leer(-5),
  Escribir(-5),
  Repite(-5),
  Hasta(-5),
  Mientras(-5),
  Si(-5),
  SiNo(-5),
  Ejecuta(-5),
  And(-5),
  Or(-5),
  Suma(-5),
  Resta(-5),
  Multiplicacion(-5),
  Division(-5),
  Igual(-5),
  MayorIgual(-5),
  Mayor(-5),
  MenorIgual(-5),
  Menor(-5),
  Diferente(-5),
  PuntoYComa(-5),
  CierraCorchete(-5),
  AbreCorchete(-5),
  Coma(-5),
  DosPuntos(-5),
  CierraParentesis(-5),
  AbreParentesis(-5),
  DosPuntosIgual(-5),
  Identificador(-5),
  Enteros(-5),
  Reales(-5),
  Cadena(-5),
  ERROR(-5);


  private int numVal;

  Tokens(int numVal) {
    this.numVal = numVal;
  }

  public int getNumVal() {
    return numVal;
  }
}
