package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    Book create(String title, String author) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    List<Book> list() {
        return bookRepository.findAll();
    }

    Book update(long id, String title, String author) {
        Book book = bookRepository.findById(id).get();
        book.setTitle(title);
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    void delete(long id) {
        bookRepository.deleteById(id);
    }

}
