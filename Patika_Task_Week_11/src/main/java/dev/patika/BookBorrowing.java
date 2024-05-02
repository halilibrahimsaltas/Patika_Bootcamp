package dev.patika;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="book_borrowing")
public class BookBorrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_borrowing_id", unique = true, nullable = false)
    private Integer bookBorrowingId;

    @Column(name = "borrower_name", length = 100, nullable = false)
    private String borrowerName;

    @Column(name = "borrowing_date",nullable = false)
    private Date borrowingDate;

    @Column(name = "return_date")
    private Date returnDate;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="borrowing_book_id",referencedColumnName = "book_id")
    private Book book;

    public BookBorrowing() {
    }

    public Integer getBookBorrowingId() {
        return bookBorrowingId;
    }

    public void setBookBorrowingId(Integer bookBorrowingId) {
        this.bookBorrowingId = bookBorrowingId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(Date borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookBorrowing{" +
                "bookBorrowingId=" + bookBorrowingId +
                ", borrowerName='" + borrowerName + '\'' +
                ", borrowingDate=" + borrowingDate +
                ", returnDate=" + returnDate +
                ", book=" + book +
                '}';
    }
}
