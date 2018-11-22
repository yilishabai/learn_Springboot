package com.sevice;

import com.model.Book;
import com.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private com.repository.BookRepository BookRepository;

    public List<Book> findAll(){
        List<Book> all = BookRepository.findAll();
        return all;
    }
}
