package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;

    @OneToMany
    private Set<Book> books = new HashSet<>();

    public Publisher() {
    }

    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Book> getBooks() {
        return this.books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Publisher)) {
            return false;
        }
        Publisher publisher = (Publisher) o;
        return id != null ? id.equals(publisher.id) : publisher.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", address='" + getAddress() + "'" + "}";
    }

}
