package projektiharjoitus.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			// Your code...add some demo data to database
		};
	}

}
