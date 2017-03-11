package jwd.wafepa.web.dto;


public class BookDTO {

	public BookDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookDTO(Long id, String title, double price, int year,
			AuthorDTO author) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.year = year;
		this.author = author;
	}

	public BookDTO(String title, double price, int year,
			AuthorDTO author) {
		super();
		this.title = title;
		this.price = price;
		this.year = year;
		this.author = author;
	}
	
	private Long id;

	private String title;
	
	private double price;
	
	private int year;
	
	private AuthorDTO author;

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

}
