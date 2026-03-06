package projektiharjoitus.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import projektiharjoitus.bookstore.model.AppUser;
import projektiharjoitus.bookstore.model.AppUserRepository;
import projektiharjoitus.bookstore.model.Book;
import projektiharjoitus.bookstore.model.BookRepository;
import projektiharjoitus.bookstore.model.Category;
import projektiharjoitus.bookstore.model.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

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
// Sovellus on sitten valmis käyttöä varten
	@Bean
	public CommandLineRunner bookdemo(
		BookRepository brepository, 
		CategoryRepository crepository,
		AppUserRepository urepository,
        BCryptPasswordEncoder passwordEncoder
	) {
		return (args) -> {
			// Your code...add some demo data to database
			log.info("tallensin kirjoja");

			Category kategoria1 = new Category("Lasten kirjat");
			Category kategoria2 = new Category("Tieto kirjat");
			Category kategoria3 = new Category("Jännittävät kirjat");
			
			crepository.save(kategoria1);
			crepository.save(kategoria2);
			crepository.save(kategoria3);

			// Lisää kirjat kategorioiden kanssa
			log.info("Lisätään kirjoja");
			brepository.save(new Book("Muumilaakson kesä", "Tove Jansson", 1950, 9789513149383L, 14.99, kategoria1));
			brepository.save(new Book("Muumien joulu", "Tove Jansson", 1952, 9789513149390L, 13.99, kategoria1));
			brepository.save(new Book("Pakkanen tulee", "Tove Jansson", 1948, 9789513144763L, 12.99, kategoria1));
			brepository.save(new Book("Muumilaakson talvi", "Tove Jansson", 1957, 9789513166763L, 13.99, kategoria1));
			brepository.save(new Book("Muumilaakson kummitukset", "Tove Jansson", 1954, 9789513150860L, 13.99, kategoria1));
			
			brepository.save(new Book("1984", "George Orwell", 1949, 9780451524935L, 9.99, kategoria3));
			brepository.save(new Book("Herran Renkaita", "J.R.R. Tolkien", 1954, 9780544003415L, 24.99, kategoria3));

			log.info("Etsi kaikki kirjat");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
			log.info("etsi teoksen nimellä ");
			for (Book book : brepository.findByTitle("Muumien joulu")) {
				log.info(book.toString());
			}
			//tässä lisään testi käyttäjät
			urepository.save(new AppUser("user",
                    passwordEncoder.encode("user"),
                    "USER"));

            urepository.save(new AppUser("admin",
                    passwordEncoder.encode("admin"),
                    "ADMIN"));
		};
	}		
}
