package edu.eci.vcds.Parcial1CVDS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductController {

  private final ProductStockManager productStockManager;

  @Autowired
  public ProductController(ProductStockManager productStockManager) {
    this.productStockManager = productStockManager;
    productStockManager.addObserver(new AgentLog());
    productStockManager.addObserver(new AgentWarning());
  }

  @PostMapping
  public ResponseEntity<String> addProduct(@RequestBody Product product) {
    productStockManager.addProduct(product);
    return ResponseEntity.ok("Producto añadido: " + product.getName());
  }

  @PutMapping("/{nombre}/stock")
  public ResponseEntity<String> updateStock(
    @PathVariable String nombre,
    @RequestParam int cantidad
  ) {
    productStockManager.updateProductStock(nombre, cantidad);
    return ResponseEntity.ok("Stock actualizado para el producto: " + nombre);
  }
}
