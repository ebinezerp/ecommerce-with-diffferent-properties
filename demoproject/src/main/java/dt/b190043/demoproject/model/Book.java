package dt.b190043.demoproject.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.stereotype.Component;

@Component
@Entity
@PrimaryKeyJoinColumn(name = "productId")
public class Book extends Product {

	/*
	 * @ManyToMany(cascade=CascadeType.ALL) private Set<Author> authors;
	 */
	private String author;
	private String genere;

	/*
	 * public Set<Author> getAuthors() { return authors; } public void
	 * setAuthors(Set<Author> authors) { this.authors = authors; }
	 */

	public String getGenere() {
		return genere;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

}
