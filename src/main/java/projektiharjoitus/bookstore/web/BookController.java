package projektiharjoitus.bookstore.web;

import java.util.Locale.Category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import projektiharjoitus.bookstore.model.Book;
import projektiharjoitus.bookstore.model.BookRepository;
import projektiharjoitus.bookstore.model.CategoryRepository;

import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class BookController {
    private BookRepository repository;
    private CategoryRepository crepository;

    // constructor injection. Can only be one constructor then.
    public BookController(BookRepository repository) {
        this.repository = repository;
    }
    public BookController(CategoryRepository crepository) {
        this.crepository = crepository;
    }

    @RequestMapping(value= "/index")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @RequestMapping(value = "/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:/index";
    }    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable Long id, Model model) {
        repository.deleteById(id);
        return "redirect:/index";  
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", repository.findById(id));
        model.addAttribute("categories",crepository.findAll());
        return "editbook";
} 


}
