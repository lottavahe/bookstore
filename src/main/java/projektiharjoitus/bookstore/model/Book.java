package projektiharjoitus.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**entity tarkoittaaa table tässä tietokannassa 
 * tämä luokka = tietokantataulu "Book"
 * Luokan attribuutit = sarakkeet taulussa
*/

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private int publicationYear;
    private long isbn;
    private double price;

/**pitää luoda tämmöinen parametriton konstruktori se saa jpa json 
 * ja springin toimimaan oikein  */
    public Book(){

    }
/** ei ID luokkaa konstruktoriin koska tietokanta hallinnoi sitä
 * automaattisesti
*/
    public Book(String title, String author, int publicationYear, int isbn, double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    


}