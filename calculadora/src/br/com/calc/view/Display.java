package br.com.calc.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Display extends JPanel {

  //Define o texto dentro do display
  private JLabel numeros;
  private final Color BG_PADRAO = new Color(72, 70, 70);

  public Display() {
    setBackground(BG_PADRAO);
    numeros = new JLabel("123");
    numeros.setForeground(Color.WHITE);
    numeros.setFont(new Font("courier", Font.BOLD, 35));

    setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 15)); //alinhamento de texto com o FlowLayout
    add(numeros);
  }
}
