package com.agenciacristal.mycrud.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//(path = "/")a la ruta principal

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {

    private final ProductService productService;

//anotacion para inyectar esta clase en el constructor
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
//conectado service con este controlador
    }

    @GetMapping
    public List<Product> getProducts(){
        return this.productService.getProducts();
    }//objeto inyectado


    @PostMapping
    public ResponseEntity<Object> registrarProducto(@RequestBody Product product){//se necesita el cuerpo de la solicitud, son los datos del producto
        return this.productService.newProduct(product);

    }

    @PutMapping
    public ResponseEntity<Object> actualizarProducto(@RequestBody Product product){//se necesita el cuerpo de la solicitud, son los datos del producto
        return this.productService.newProduct(product);

    }

    @DeleteMapping(path = "{productId}")
    public ResponseEntity<Object> eliminarProducto(@PathVariable("productId") Long id){
        return this.productService.deleteProduct(id);
    }
}


