package com.agenciacristal.mycrud.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository//permite  que se trabaje desde service con la informaciom que hay desde la bd
public interface ProductRepository extends JpaRepository<Product, Long> {
    //automaticamente crea un metood con estas caracteristicas
    //@Query("SELECT * FROM Products WHERE = p.name = ?1")

    Optional<Product> findProductByName(String name);

}
