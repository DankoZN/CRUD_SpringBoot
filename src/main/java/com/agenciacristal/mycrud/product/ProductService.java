package com.agenciacristal.mycrud.product;

import org.hibernate.engine.jdbc.env.internal.NormalizingIdentifierHelperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    HashMap<String, Object> datos;


    private final ProductRepository productRepository;

    @Autowired  //permite devolver esta lista
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {//retorna una lista coon info
        return this.productRepository.findAll();
    }

    public ResponseEntity<Object> newProduct(Product product) {

        Optional<Product> res = productRepository.findProductByName(product.getName());
        datos = new HashMap<>();


        if (res.isPresent() && product.getId() == null) {
            datos.put("error", true);
            datos.put("message", "ya existe un producto con ese nombre");
            //permite saber si encontro el prod atraves del name
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        datos.put("message", "Guardado exitosamente");

        if (product.getId() != null) {
            datos.put("message", "Actualizado exitosamente");

        }

        productRepository.save(product);
        datos.put("data", product);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED

        );
    }

    public ResponseEntity<Object> deleteProduct(Long id) {
        datos = new HashMap<>();
        boolean exist = this.productRepository.existsById(id);

        if (!exist) { //si no existe...
            datos.put("error", true);
            datos.put("message", "No existe un producto con ese id");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        datos.put("message", "Producto eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}
