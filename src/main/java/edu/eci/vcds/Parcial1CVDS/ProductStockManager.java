package edu.eci.vcds.Parcial1CVDS;

import java.util.ArrayList;
import java.util.List;

public class ProductStockManager {

  private List<StockObserver> observers = new ArrayList<>();
  private List<Product> products = new ArrayList<>();

  // Método para suscribir a un agente/observador
  public void addObserver(StockObserver observer) {
    observers.add(observer);
  }

  private void notifyObservers(String productName, int newQuantity) {
    for (StockObserver observer : observers) {
      observer.update(productName, newQuantity);
    }
  }

  public void addProduct(Product product) {
    products.add(product);
  }

  public void updateProductStock(String productName, int newQuantity) {
    for (Product product : products) {
      if (product.getName().equals(productName)) {
        product.setStock(newQuantity);
        notifyObservers(productName, newQuantity);
        break;
      }
    }
  }
}
