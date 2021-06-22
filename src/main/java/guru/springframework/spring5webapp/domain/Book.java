package guru.springframework.spring5webapp.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String title;
	private String isbn;

	@ManyToMany
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors;

	public Book(Long Id, String title, String isbn, Set<Author> authors) {
		this.Id = Id;
		this.title = title;
		this.isbn = isbn;
		this.authors = authors;
	}

	public Book() {
	}

	public Book(String title, String isbn, Set<Author> authors) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.authors = authors;
	}

	public String getTitle() {
		return title;
	}

	public Long getId() {
		return this.Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

}
