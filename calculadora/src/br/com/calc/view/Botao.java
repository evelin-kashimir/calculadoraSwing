package br.com.calc.view;

import java.awt.Color;
import javax.swing.JButton;

public class Botao extends JButton {


  private final Color BG_PADRAO = new Color(9, 108, 147);
  private final Color BG_OPERTATION = new Color(208, 161, 6);
  private final Color BG_OTHERS = new Color(0, 0, 0);

  public Botao() {
    setBackground(BG_PADRAO);
  }
}
