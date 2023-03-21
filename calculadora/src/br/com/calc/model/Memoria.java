package br.com.calc.model;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

  private enum TipoComando {
      ZERAR, NUMERO,VIRGULA, IGUAL,
      SOMA, SUBTRACAO, MULTIPLICACAO, DIVISAO, SINAL
  }

  private static final Memoria instancia = new Memoria();
  private final List<MemoriaObserver> observadores = new  ArrayList<>();
  private TipoComando ultimaOperacao = null;
  private boolean substituir = false;
  private String textoAtual = "";
  private String textoBuffer = "";

  private Memoria(){ }

  public static Memoria getInstance() {
    return instancia;
  }

  public void addObserver(MemoriaObserver mo) {
    observadores.add(mo);
  }

  public String getTextoAtual() {
    return textoAtual.isEmpty() ? "0" : textoAtual;
  }

  public void processarComando(String texto) {
    TipoComando tpComando = detectarTipoComando(texto);
    System.out.println(tpComando);

    if(tpComando == null) {
      return;
    } else if (tpComando == TipoComando.ZERAR) {
      textoAtual = "";
      textoBuffer = "";
      substituir = false;
      ultimaOperacao = null;

    } else if (tpComando == TipoComando.SINAL && textoAtual.contains("-")) {
      textoAtual = textoAtual.substring(1);
    } else if (tpComando == TipoComando.SINAL && !textoAtual.contains("-")){
      textoAtual = "-" + textoAtual;
    } else if (tpComando == TipoComando.NUMERO || tpComando == TipoComando.VIRGULA) {
      textoAtual = substituir ? texto : textoAtual + texto;
      substituir = false;
    } else {
      substituir = true;
      textoAtual = obterResultadoOperacao();
      textoBuffer = textoAtual;
      ultimaOperacao = tpComando;
    }
    observadores.forEach(o -> o.valorAlterado(getTextoAtual()));
  }

  private String obterResultadoOperacao() {
    if(ultimaOperacao == null || ultimaOperacao == TipoComando.IGUAL){
      return textoAtual;
    }

    double numeroBuffer = Double.parseDouble(textoBuffer);
    double numeroAtual = Double.parseDouble(textoAtual);
    double resultado = 0;

    switch (ultimaOperacao) {
      case SOMA:
        resultado = numeroBuffer + numeroAtual;
        break;
      case SUBTRACAO:
        resultado = numeroBuffer - numeroAtual;
        break;
      case DIVISAO:
        resultado = numeroBuffer / numeroAtual;
        break;
      case MULTIPLICACAO:
        resultado = numeroBuffer * numeroAtual;
        break;
    }

    String resultadoString = String.valueOf(resultado);
    boolean inteiro = resultadoString.endsWith(".0");

    return inteiro ? resultadoString.replace(".0", "") : resultadoString;
  }

  private TipoComando detectarTipoComando(String texto) {
    //Evitar que seja digitado vários zeros a esquerda
    if(textoAtual.isEmpty() && texto == "0") {
      return null;
    }

    try {
      Integer.parseInt(texto);
      return TipoComando.NUMERO;
    } catch (NumberFormatException nfe) {

      //Quando não for número

      switch (texto) {
        case "AC":
          return TipoComando.ZERAR;
        case "/":
          return TipoComando.DIVISAO;
        case "x":
          return TipoComando.MULTIPLICACAO;
        case "-":
          return TipoComando.SUBTRACAO;
        case "+":
          return TipoComando.SOMA;
        case "=":
          return TipoComando.IGUAL;
        case "+/-":
          return TipoComando.SINAL;
        case ".":
            if (!textoAtual.contains(".")) {
              return TipoComando.VIRGULA;
            }
        default:
          return null;
      }
    }
  }
}
