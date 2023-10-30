package com.wallisonlemos.produtosdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProdutosDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdutosDemoApplication.class, args);
	}

}
