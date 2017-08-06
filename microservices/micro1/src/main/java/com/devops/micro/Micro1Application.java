package com.devops.micro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Micro1Application {


	@Value("${grpc.port}")
	static int gport;
	public static void main(String[] args) throws IOException {

		SpringApplication.run(Micro1Application.class, args);
	}
}
