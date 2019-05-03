package lexer;

public enum Tokens {
  Prog(-1, -1),
  Var(-5, -1),
  Proc(-5, -1),
  Inicio(-5, -1),
  Final(-5, -1),
  Entero(-5, -1),
  Real(-5, -1),
  String(-5, -1),
  Limpiar(-5, -1),
  Vexy(-5, -1),
  Leer(-5, -1),
  Escribir(-5, -1),
  Repite(-5, -1),
  Hasta(-5, -1),
  Mientras(-5, -1),
  Si(-5, -1),
  SiNo(-5, -1),
  Ejecuta(-5, -1),
  And(-5, -1),
  Or(-5, -1),
  Suma(-5, -1),
  Resta(-5, -1),
  Multiplicacion(-5, -1),
  Division(-5, -1),
  Igual(-5, -1),
  MayorIgual(-5, -1),
  Mayor(-5, -1),
  MenorIgual(-5, -1),
  Menor(-5, -1),
  Diferente(-5, -1),
  PuntoYComa(-5, -1),
  CierraCorchete(-5, -1),
  AbreCorchete(-5, -1),
  Coma(-5, -1),
  DosPuntos(-5, -1),
  CierraParentesis(-5, -1),
  AbreParentesis(-5, -1),
  DosPuntosIgual(-5, -1),
  Identificador(-5, -1),
  Enteros(-5, -1),
  Reales(-5, -1),
  Cadena(-5, -1),
  ERROR(-5, -1);


  private int number;
  private int tablePosition;

  Tokens(int number, int tablePosition) {
    this.number = number;
    this.tablePosition = tablePosition;
  }

  public int getNumber() {
    return number;
  }

  public int getTablePosition() {
    return tablePosition;
  }
}
