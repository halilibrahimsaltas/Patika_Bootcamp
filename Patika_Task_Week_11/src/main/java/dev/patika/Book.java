package dev.patika;

import jakarta.persistence.*;

import javax.xml.namespace.QName;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", unique = true, nullable = false)
    private Integer bookId;

    @Column(name = "book_name", length = 100, nullable = false)
    private String customerName;


    @Column(name = "publication_year")
    private Integer publicationYear;

    @Column(name = "book_stock")
    private Integer bookStock;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name="book_author_id", referencedColumnName = "author_id")
    private Author author;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_publisher_id", referencedColumnName = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book")
    private List<BookBorrowing> bookBorrowingList;


    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "book2cate",
            joinColumns = {@JoinColumn(name = "book2cate_book_id")},
            inverseJoinColumns = {@JoinColumn (name= "book2cate_category_id")}

    )
    private List<Category> categoryList;


    public Book() {
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Integer getBookStock() {
        return bookStock;
    }

    public void setBookStock(Integer bookStock) {
        this.bookStock = bookStock;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<BookBorrowing> getBookBorrowingList() {
        return bookBorrowingList;
    }

    public void setBookBorrowingList(List<BookBorrowing> bookBorrowingList) {
        this.bookBorrowingList = bookBorrowingList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", customerName='" + customerName + '\'' +
                ", publicationYear=" + publicationYear +
                ", bookStock=" + bookStock +
                ", author=" + author +
                ", publisher=" + publisher +
                ", bookBorrowingList=" + bookBorrowingList +
                ", categoryList=" + categoryList +
                '}';
    }
}
