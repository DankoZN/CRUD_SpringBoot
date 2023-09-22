package com.agenciacristal.mycrud;

import com.agenciacristal.mycrud.product.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController //anotaciones, consumir y consultar info desde este archivo
public class MyCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCrudApplication.class, args);
	}


}

