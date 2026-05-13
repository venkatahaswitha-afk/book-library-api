package org.example.booklibraryapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Book getBookById(Long id){
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }
    public List<Book> searchByAuthor(String author){
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }
    public List<Book> searchByTitle(String title){
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }
    public List<Book>  searchByGenre(String genre){
        return bookRepository.findByGenreIgnoreCase(genre);
    }
    public Book addBook(Book book){
        return bookRepository.save(book);
    }
    public Book updateBook(Long id, Book updatedBook){
        Book existing = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        existing.setTitle(updatedBook.getTitle());
        existing.setAuthor(updatedBook.getAuthor());
        existing.setDescription(updatedBook.getDescription());
        existing.setGenre(updatedBook.getGenre());
        existing.setAvailableCopies(updatedBook.getAvailableCopies());
        existing.setPublishedYear(updatedBook.getPublishedYear());
        return bookRepository.save(existing);
    }
    public void deleteBook(Long id){
        bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        bookRepository.deleteById(id);
    }
    public List<Book> findBooksPublishedAfter(int year){
        return bookRepository.findBooksPublishedAfter(year);
    }
}
