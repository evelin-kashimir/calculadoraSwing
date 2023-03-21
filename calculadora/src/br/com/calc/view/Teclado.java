package br.com.calc.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class Teclado extends JPanel {
  private final Color BG_PADRAO = new Color(9, 108, 147);
  private final Color BG_OPERTATION = new Color(248, 204, 64);
  private final Color BG_OTHERS = new Color(100, 98, 98);

  public Teclado(){
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();
    setLayout(layout);

    //Linha 1
    adicionarBotao("AC", BG_OTHERS, c, 0, 0);
    adicionarBotao("+/-", BG_OTHERS, c, 1, 0);
    adicionarBotao("%", BG_OTHERS, c, 2, 0);
    adicionarBotao("/", BG_OPERTATION, c, 3, 0);

    //Linha 2
    adicionarBotao("7", BG_OTHERS, c, 0, 1);
    adicionarBotao("8", BG_OTHERS, c, 1, 1);
    adicionarBotao("9", BG_OTHERS, c, 2, 1);
    adicionarBotao("x", BG_OPERTATION, c, 3, 1);

    //Linha 3
    adicionarBotao("4", BG_OTHERS, c, 0, 2);
    adicionarBotao("5", BG_OTHERS, c, 1, 2);
    adicionarBotao("6", BG_OTHERS, c, 2, 2);
    adicionarBotao("-", BG_OPERTATION, c, 3, 2);

    //Linha 4
    adicionarBotao("1", BG_OTHERS, c, 0, 3);
    adicionarBotao("2", BG_OTHERS, c, 1, 3);
    adicionarBotao("3", BG_OTHERS, c, 2, 3);
    adicionarBotao("+", BG_OPERTATION, c, 3, 3);

    //Linha 5
    adicionarBotao("0", BG_OTHERS, c, 0, 4);
    adicionarBotao("0", BG_OTHERS, c, 1, 4);
    adicionarBotao(".", BG_OTHERS, c, 2, 4);
    adicionarBotao("=", BG_OPERTATION, c, 3, 4);
  }

  private void adicionarBotao(String texto, Color cor, GridBagConstraints c, int x, int y) {
    c.gridx = x;
    c.gridy = y;
    Botao botao = new Botao(texto, cor);
    add(botao, c);
  }
}
