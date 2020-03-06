package lexico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.SVGPath;

public class MainViewController {

  @FXML
  private TextArea txtInput;

  @FXML
  private TextArea txtOutput;


  public void initialize() {
    txtInput.setOnKeyPressed(event -> {
      if (event.getCode() == KeyCode.ENTER && event.isControlDown()) {
      System.out.println(txtInput.getText() + event.getText());
      analyze(txtInput.getText() + event.getText());
      }
    });
  }

  public void analyze(String text) {
    File archivo = new File("archivo.txt");
    PrintWriter printWriter;
    try {
      printWriter = new PrintWriter(archivo);
      printWriter.print(text);
      printWriter.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    try {
      Reader lector = new BufferedReader(new FileReader("archivo.txt"));
      Lexico lexico = new Lexico(lector);
      String output = "";
      while (true) {
        Token token = lexico.yylex();
        String string = lexico.lexeme;

        if (token == null) {
          //          output += "Completado";
          txtOutput.setText(output);
          return;
        }

        // si es una cadena de texto con comillas
        if (string.startsWith("\"") && string.endsWith("\"") && string.length() != 1) {
          string = string.substring(1, string.length() - 1); // quitar comillas para mostrar solo el texto
        }

        if (token.equals(Token.Comentario)) {
          string = string.replace("\\\\", "");
          continue;
        }

        string = string.replace("\\\"", "\"");

        output += token +
            " (" + string + "," + token.getNumber() + "," + token.getTablePosition() + ","
            + (lexico.getLine() + 1) + ")\n";
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
