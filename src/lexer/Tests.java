package lexer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class Tests {

  @Test
  public void palabrasClave() throws IOException {
    Reader reader = new StringReader(
        "PROG VAR PROC INICIO FIN ENTERO REAL STRING LIMPIAR VEXY LEER ESCRIBIR REPITE HASTA MIENTRAS SI SINO EJECUTA AND OR");
    List<Tokens> actualTokens = getTokens(reader);
    Assert.assertTrue(actualTokens.stream().allMatch(tokens ->
        tokens.getNumber() <= -1 && tokens.getNumber() >= -20)
    );
  }

  @Test
  public void constantes() throws IOException {
    List<Tokens> expectedTokens = new ArrayList<>();
    expectedTokens.add(Tokens.Cadena);
    expectedTokens.add(Tokens.Enteros);
    expectedTokens.add(Tokens.Reales);
    expectedTokens.add(Tokens.ERROR);

    Reader reader = new StringReader("\"cadena\" 5313 1512.65 156.36.55");
    List<Tokens> actualTokens = getTokens(reader);
    Assert.assertEquals(expectedTokens, actualTokens);
  }

  @Test
  public void codigoCompleto() throws IOException {
    Reader reader = new BufferedReader(new FileReader("pruebas/codigo-completo.txt"));
    List<Tokens> actualTokens = getTokens(reader);
    System.out.println(actualTokens);
    Assert.assertFalse(actualTokens.contains(Tokens.ERROR));
  }

  private List<Tokens> getTokens(Reader reader) throws IOException {
    Lexer lexer = new Lexer(reader);

    List<Tokens> tokens = new ArrayList<>();
    while (true) {
      Tokens token = lexer.yylex();
      if (token == null) {
        break;
      }
      tokens.add(token);
      System.out.println(token);
    }
    reader.close();
    return tokens;
  }
}
