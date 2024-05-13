package dev.patika.library.dto.response.bookBorrowingResponse;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingResponse {

    private int bookBorrowingId;

    private String borrowerName;

    private LocalDate borrowingDate;

    public int getBookBorrowingId() {
        return bookBorrowingId;
    }

    public void setBookBorrowingId(int bookBorrowingId) {
        this.bookBorrowingId = bookBorrowingId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(LocalDate borrowingDate) {
        this.borrowingDate = borrowingDate;
    }
}
