package com.mongodbdemo.unab;

import com.mongodbdemo.unab.entity.Book;
import com.mongodbdemo.unab.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemobooksApplication implements CommandLineRunner {
    @Autowired
    private BookRepository repositorio;

    public static void main(String[] args) {
        SpringApplication.run(DemobooksApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //borrar todos los documentos
        repositorio.deleteAll();

        //Crear un libro
        Book unLibro = new Book();
        Book otroLibro = new Book();

        //Asignar valores a cada atributo del libro
        unLibro.setIsbn("123");
        unLibro.setTitle("EL GENERAL EN SU LABERINTO");
        unLibro.setAuthor("GABRIEL GARCIA MARQUEZ");

        otroLibro.setIsbn("1234");
        otroLibro.setTitle("EL VIAJE DEL ELEFANTE");
        otroLibro.setAuthor("JOSE SARAMAGO");

        repositorio.insert(unLibro);
        repositorio.insert(otroLibro);

        System.out.println("Catalogo de libros\n");
        List<Book> catalogo = repositorio.findAll();
        for (Book libro : catalogo) {
            System.out.println(libro);
        }
    }
}
