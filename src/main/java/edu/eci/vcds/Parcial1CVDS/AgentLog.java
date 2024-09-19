package edu.eci.vcds.Parcial1CVDS;

public class AgentLog implements StockObserver {

  @Override
  public void update(String productName, int newQuantity) {
    System.out.println(
      "Producto: " +
      productName +
      " -> " +
      newQuantity +
      " unidades disponibles."
    );
  }
}
