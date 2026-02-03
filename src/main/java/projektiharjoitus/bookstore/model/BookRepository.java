package projektiharjoitus.bookstore.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    /**Jos halutaan automaatti joka hakee esim nimellä kirjan
     * List<Book> findByTitle (String title);
     */
}
