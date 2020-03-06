package lexico;

public enum Token {
  // palabras reservadas
  programa(-1, -1),
  inicio(-2, -1),
  fin(-3, -1),
  entrada(-4, -1),
  salida(-5, -1),
  entero(-6, -1),
  real(-7, -1),
  cadena(-8, -1),
  si(-9, -1),
  sino(-10, -1),
  entonces(-11, -1),
  mientras(-12, -1),
  repetir(-13, -1),
  hasta(-14, -1),
  limpiar(-15, -1),
  ejecutar(-16, -1),
  posxy(-17, -1),
  proc(-18, -1),

  Suma(-24, -1),
  Resta(-25, -1),
  Multiplicacion(-21, -1),
  Division(-22, -1),
  Modulo(-23, -1),

  Igual(-26, -1),
  MayorIgual(-34, -1),
  Mayor(-32, -1),
  MenorIgual(-33, -1),
  Menor(-31, -1),
  IgualIgual(-35, -1),
  Diferente(-36, -1),

  PuntoYComa(-73, -1),
  CierraCorchete(-76, -1),
  AbreCorchete(-75, -1),
  Coma(-74, -1),
  DosPuntos(-77, -1),
  CierraParentesis(-72, -1),
  AbreParentesis(-71, -1),
  DosPuntosIgual(-78, -1),
  AbreLlave(-79, -1),
  CierraLlave(-80, -1),


  Identificador(-51, -2),
  Enteros(-52, -1),
  Reales(-53, -1),
  Cadena(-54, -1),
  Rutina(-55,-1),
  ConstanteEntera(-61, -1),
  ConstanteReal(-62, -1),
  ConsranteString(-63,-1),

  LogicoAND(-42, -1),
  LogicoOR(-41, -1),
  Negacion(-43, -1),

  Comentario(-90, -1),

  ERROR(-100, -1);


  private int number;
  private int tablePosition;

  Token(int number, int tablePosition) {
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