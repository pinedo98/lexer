package lexico;

import java.io.File;

public class Generador {

  public static void main(String[] args) {
    String ruta = "src/lexico/Lexico.flex";
    generarLexico(ruta);
  }

  public static void generarLexico(String ruta) {
    File archivo = new File(ruta);
    JFlex.Main.generate(archivo);
  }
}
