package br.com.calc.model;

@FunctionalInterface
public interface MemoriaObserver {

  void valorAlterado(String novoValor);
}
