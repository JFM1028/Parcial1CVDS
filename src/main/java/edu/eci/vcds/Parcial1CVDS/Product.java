package edu.eci.vcds.Parcial1CVDS;

public class Product {

  private String name;
  private int stock;

  public Product(String name, int stock) {
    this.name = name;
    this.stock = stock;
  }

  public String getName() {
    return name;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }
}
