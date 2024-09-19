package edu.eci.vcds.Parcial1CVDS;

public class AgentWarning implements StockObserver {

  @Override
  public void update(String productName, int newQuantity) {
    if (newQuantity < 5) {
      System.out.println(
        "ALERTA!!! El stock del producto: " +
        productName +
        " es muy bajo, solo quedan " +
        newQuantity +
        " unidades."
      );
    }
  }
}
