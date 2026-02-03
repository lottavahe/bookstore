package projektiharjoitus.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import projektiharjoitus.bookstore.model.BookRepository;


@Controller
public class BookController {
    private BookRepository repository;
	// constructor injection. Can only be one constructor then.
	public BookController(BookRepository repository) {
		this.repository = repository;
    }
    @GetMapping("/index")
    public String showBookstore() {
        return "index";
    }
    

}
