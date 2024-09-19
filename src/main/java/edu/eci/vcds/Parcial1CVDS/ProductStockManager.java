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

  // Método para notificar a todos los observadores
  private void notifyObservers(String productName, int newQuantity) {
    for (StockObserver observer : observers) {
      observer.update(productName, newQuantity);
    }
  }

  // Método para agregar un producto
  public void addProduct(Product product) {
    products.add(product);
  }

  // Método para modificar el stock de un producto
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
