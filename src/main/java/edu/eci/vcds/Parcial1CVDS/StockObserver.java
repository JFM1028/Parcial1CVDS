package edu.eci.vcds.Parcial1CVDS;

public interface StockObserver {
  void update(String productName, int newQuantity);
}
