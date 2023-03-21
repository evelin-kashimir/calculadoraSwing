package br.com.calc.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Botao extends JButton {

  public Botao(String texto, Color cor) {
    setText(texto);
    setOpaque(true); //deixando o botão mais claro
    setForeground(Color.white);
    setBackground(cor);
    setFont(new Font("courier", Font.PLAIN, 20));
    setBorder(BorderFactory.createLineBorder(Color.black));
  }
}
