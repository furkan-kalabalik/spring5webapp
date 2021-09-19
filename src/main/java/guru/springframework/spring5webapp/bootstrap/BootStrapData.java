package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Book one", "23121");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author furkan = new Author("Furkan", "Kalabalik");
        Book furkanBook = new Book("Book wto", "12311");

        furkan.getBooks().add(furkanBook);
        furkanBook.getAuthors().add(furkan);

        authorRepository.save(furkan);
        bookRepository.save(furkanBook);

        Publisher publisher1 = new Publisher("Publisher1", "Istanbul");
        Publisher publisher2 = new Publisher("Publisher2", "Çorum");

        publisherRepository.save(publisher1);
        publisherRepository.save(publisher2);

        System.out.println("Number of books: "+bookRepository.count());
        System.out.println("Number of authors: "+authorRepository.count());
        System.out.println("Number of publishers: "+publisherRepository.count());
    }
}
