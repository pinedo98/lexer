package lexico;

import java.io.File;

public class Generador {

  public static void main(String[] args) {
    String ruta = "src/lexico/Lexico.flex";
    generarLexer(ruta);
  }

  public static void generarLexer(String ruta) {
    File archivo = new File(ruta);
    JFlex.Main.generate(archivo);
  }
}
