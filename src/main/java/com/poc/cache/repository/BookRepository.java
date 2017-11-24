package com.poc.cache.repository;

import com.poc.cache.entity.Book;

public interface BookRepository {

    Book getByIsbn(String isbn);

}