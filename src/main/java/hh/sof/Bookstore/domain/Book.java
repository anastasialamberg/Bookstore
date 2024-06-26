package hh.sof.Bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookid")
    private Integer id;
    private String title;
    private String author;
    private Integer publicationYear;
    private String isbn;
    private Double price;

    @ManyToOne
    @JsonIgnoreProperties("books")
    @JoinColumn(name = "category_id")
    private Category category;

    public Book(Integer id, String title, String author, int publicationYear, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    public Book() {
        this.id = (Integer) null;
        this.title = null;
        this.author = null;
        this.publicationYear = (Integer) null;
        this.isbn = null;
        this.price = (Double) null;
    }

    public Integer getId() {
        return this.id != null ? this.id.intValue() : null;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPublicationYear() {
        return this.publicationYear != null ? this.publicationYear.intValue() : null;
    }

    public String getIsbn() {
        return isbn;
    }

    public Double getPrice() {
        return this.price != null ? this.price.doubleValue() : null;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        if (this.category != null)
            return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publicationYear=" + publicationYear
                    + ", isbn=" + isbn + ", price=" + price + ", category="
                    + this.getCategory() + "]";
        else
            return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publicationYear=" + publicationYear
                    + ", isbn=" + isbn + ", price=" + price + "]";
    }

}
