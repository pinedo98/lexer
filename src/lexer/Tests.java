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
    List<Token> actualTokens = getTokens(reader);
    Assert.assertTrue(actualTokens.stream().allMatch(token ->
        token.getNumber() <= -1 && token.getNumber() >= -20)
    );
  }

  @Test
  public void constantes() throws IOException {
    List<Token> expectedTokens = new ArrayList<>();
    expectedTokens.add(Token.Cadena);
    expectedTokens.add(Token.Enteros);
    expectedTokens.add(Token.Reales);
    expectedTokens.add(Token.ERROR);

    Reader reader = new StringReader("\"cadena\" 5313 1512.65 156.36.55");
    List<Token> actualTokens = getTokens(reader);
    Assert.assertEquals(expectedTokens, actualTokens);
  }

  @Test
  public void codigoCompleto() throws IOException {
    Reader reader = new BufferedReader(new FileReader("pruebas/codigo-completo.txt"));
    List<Token> actualTokens = getTokens(reader);
    System.out.println(actualTokens);
    Assert.assertFalse(actualTokens.contains(Token.ERROR));
  }

  private List<Token> getTokens(Reader reader) throws IOException {
    Lexer lexer = new Lexer(reader);

    List<Token> tokens = new ArrayList<>();
    while (true) {
      Token token = lexer.yylex();
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
