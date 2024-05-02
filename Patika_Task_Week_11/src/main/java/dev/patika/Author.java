package dev.patika;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", unique = true, nullable = false)
    private Integer authorId;

    @Column(name = "author_name", length = 100, nullable = false)
    private String customerName;

    @Column(name = "birth_date")
    private Integer birthDate;

    @Column(name = "author_country")
    private String authorCountry;


    @OneToMany(mappedBy = "author",cascade = CascadeType.REMOVE)
    private List<Book>  bookList;


    public Author() {
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Integer birthDate) {
        this.birthDate = birthDate;
    }

    public String getAuthorCountry() {
        return authorCountry;
    }

    public void setAuthorCountry(String authorCountry) {
        this.authorCountry = authorCountry;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", customerName='" + customerName + '\'' +
                ", birthDate=" + birthDate +
                ", authorCountry='" + authorCountry + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
