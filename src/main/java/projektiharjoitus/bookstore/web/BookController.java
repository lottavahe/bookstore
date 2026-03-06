package projektiharjoitus.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import projektiharjoitus.bookstore.model.Book;
import projektiharjoitus.bookstore.model.BookRepository;
import projektiharjoitus.bookstore.model.CategoryRepository;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BookController {
    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;

    // constructor injection
    public BookController(BookRepository repository, CategoryRepository crepository) {
        this.bookRepository = repository;
        this.categoryRepository = crepository;
    }
    //näytä kirjat
    @RequestMapping(value= "/index")
    public String bookList(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }
//lisään kirjan
    @RequestMapping(value = "/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }
    //tallenna uusikirja
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book) {
        bookRepository.save(book);
        return "redirect:/index";
    }
    //poista kirja
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable Long id, Model model) {
        bookRepository.deleteById(id);
        return "redirect:/index";
    }
    ///muokkaa kirjaa
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookRepository.findById(id));
        model.addAttribute("categories", categoryRepository.findAll());
        return "editbook";
    }
    // RESTful service to get kaikki kirjat
	@RequestMapping(value="/allBooks", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {	
	        return (List<Book>) bookRepository.findAll();
	}    

	// RESTful service to get kirja id:llä
	@RequestMapping(value="/allBooks/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
        return bookRepository.findById(bookId);
	}       
	    
	// RESTful service to save uusi kirja
	@RequestMapping(value="/allBooks", method = RequestMethod.POST)
	public @ResponseBody Book saveNewBookRest(@RequestBody Book book) {
        return bookRepository.save(book);
	}  
}
