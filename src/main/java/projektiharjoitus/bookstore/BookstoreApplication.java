package projektiharjoitus.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import projektiharjoitus.bookstore.model.Book;
import projektiharjoitus.bookstore.model.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
//Beanilla voi lisätä testidataa tietokannan
//kirjastoon sovelluksen käynnistyessä
//Sovellus käynnistyy
// CommandLineRunner:n run()-metodi ajetaan automaattisesti
// Kirja lisätään tietokantaan 
// tällä tavalla kirja lisätään -> 
// repository.save(new Book("1984", "George Orwell", 1949, 9780451524935, 9.99));
// Sovellus on valmis käyttöä varten
	@Bean
	public CommandLineRunner bookdemo(BookRepository repository) {
		return (args) -> {
			// Your code...add some demo data to database
			System.out.print("Tallensin esimerkki kirjoja kirjastoon");
			repository.save(new Book("Muumilaakson kesä", "Tove Jansson", 1950, 9789513149383, 14.99));
            repository.save(new Book("Muumien joulu", "Tove Jansson", 1952, 9789513149390, 13.99));
            repository.save(new Book("Pakkanen tulee", "Tove Jansson", 1948, 9789513144763, 12.99));
            repository.save(new Book("Muumilaakson talvi", "Tove Jansson", 1957, 9789513166763, 13.99));
            repository.save(new Book("Muumilaakson kummitukset", "Tove Jansson", 1954, 9789513150860, 13.99));
		};
	}

}
