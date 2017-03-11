package jwd.wafepa;

import javax.annotation.PostConstruct;

import jwd.wafepa.model.Author;
import jwd.wafepa.model.Book;
import jwd.wafepa.service.ActivityService;
import jwd.wafepa.service.AddressService;
import jwd.wafepa.service.AuthorService;
import jwd.wafepa.service.BookService;
import jwd.wafepa.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestData {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;

	@Autowired
	private ActivityService activityService;

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorService authorService;

	@PostConstruct
	public void init(){
/*		Author francKafka = new Author("Franc", "Kafka");
		authorService.save(francKafka);
		Author alberKami = new Author("Alber", "Kami");
		authorService.save(alberKami);
		Author martinHajdeger = new Author("Martin", "Hajdeger");
		authorService.save(martinHajdeger);
		Author fridrihNice = new Author("Fridrih", "Nice");
		authorService.save(fridrihNice);
		Author sorenKjerkegar = new Author("Soren", "Kjerkegar");
		authorService.save(sorenKjerkegar);
		Book proces = new Book("Proces", 1200, 2015, francKafka);
		bookService.save(proces);
		Book stranac = new Book("Stranac", 880, 2013, alberKami);
		bookService.save(stranac);
		Book mitOSizifu = new Book("Mit o Sizifu", 780, 2010, alberKami);
		bookService.save(mitOSizifu);
		Book bitakIVreme = new Book("Bitak i vreme", 1000, 2009, martinHajdeger);
		bookService.save(bitakIVreme);
		Book voljaZaMoc = new Book("Volja za moc", 1200, 2015, fridrihNice);
		bookService.save(voljaZaMoc);
		Book iliIli = new Book("Ili ili", 1300, 2015, sorenKjerkegar);
		bookService.save(iliIli);
*/		
/*	       for (int i = 1; i <= 100; i++) {
	            User user = new User();
	            user.setFirstName("First name " + i);
	            user.setLastName("Last name " + i);
	            user.setEmail("email" + i + "@example.com");
	            user.setPassword("123");
	            userService.save(user);

	            for (int j = 1; j <= 3; j++) {
	                Address address = new Address();
	                address.setNumber(j + "c/7");
	                address.setStreat("Narodnog fronta");

	                address.setUser(user);
	                user.addAddress(address);
	                addressService.save(address);
	            }
	            Activity a = new Activity("Activity_"+i);
	            activityService.save(a);
	       }
*/	}
}
