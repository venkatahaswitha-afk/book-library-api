package org.example.booklibraryapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthorContainingIgnoreCase(String author);
    List<Book> findByGenreIgnoreCase(String genre);
    List<Book> findByTitleContainingIgnoreCase(String title);
    @Query("SELECT b FROM Book b WHERE b.publishedYear > :year ORDER BY b.publishedYear DESC")
    List<Book> findBooksPublishedAfter(@Param("year") int year);

}
