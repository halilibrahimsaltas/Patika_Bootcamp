package dev.patika.library.api;

import dev.patika.library.business.abstracts.BookBorrowingService;
import dev.patika.library.business.abstracts.BookService;
import dev.patika.library.core.config.modelMapper.ModelMapperService;
import dev.patika.library.core.result.Result;
import dev.patika.library.core.result.ResultData;
import dev.patika.library.core.utilities.ResultHelper;
import dev.patika.library.dto.request.author.AuthorSaveRequest;
import dev.patika.library.dto.request.book.BookUpdateRequest;
import dev.patika.library.dto.request.bookBorrowing.BookBorrowingSaveRequest;
import dev.patika.library.dto.request.bookBorrowing.BookBorrowingUpdateRequest;
import dev.patika.library.dto.response.CursorResponse;
import dev.patika.library.dto.response.author.AuthorResponse;
import dev.patika.library.dto.response.book.BookResponse;
import dev.patika.library.dto.response.bookBorrowingResponse.BookBorrowingResponse;
import dev.patika.library.entities.Author;
import dev.patika.library.entities.Book;
import dev.patika.library.entities.BookBorrowing;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/bookBorrowings")
public class BookBorrowingController {

    private  final BookBorrowingService bookBorrowingService;

    private  final BookService bookService;

    private  final ModelMapperService modelMapperService;

    public BookBorrowingController(BookBorrowingService bookBorrowingService, BookService bookService, ModelMapperService modelMapperService) {
        this.bookBorrowingService = bookBorrowingService;
        this.bookService = bookService;
        this.modelMapperService = modelMapperService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookBorrowingResponse> save (@Valid @RequestBody BookBorrowingSaveRequest bookBorrowingSaveRequest){
        BookBorrowing saveBookBorrowing= this.modelMapperService.forRequest().map(bookBorrowingSaveRequest,BookBorrowing.class);

        this.bookBorrowingService.save(saveBookBorrowing);
        return ResultHelper.created(this.modelMapperService.forResponse().map(saveBookBorrowing,BookBorrowingResponse.class));
    }
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookBorrowingResponse> update (@Valid @RequestBody BookBorrowingUpdateRequest bookBorrowingUpdateRequest){
        BookBorrowing updateBookBorrowing= this.modelMapperService.forRequest().map(bookBorrowingUpdateRequest,BookBorrowing.class);
        this.bookBorrowingService.update(updateBookBorrowing);
        return ResultHelper.success(this.modelMapperService.forResponse().map(updateBookBorrowing,BookBorrowingResponse.class));
    }
    @DeleteMapping("/{bookBorrowingId}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable ("bookBorrowingId")int id){
        this.bookBorrowingService.delete(id);
        return ResultHelper.successResult();
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<BookBorrowingResponse>> cursor(
            @RequestParam(name= "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize",required = false,defaultValue = "10") int pageSize
    )
    {
        Page<BookBorrowing> bookBorrowingPage = this.bookBorrowingService.cursor(page, pageSize);
        Page<BookBorrowingResponse> bookBorrowingResponsePage = bookBorrowingPage
                .map(bookBorrowing -> this.modelMapperService.forResponse().map(bookBorrowing, BookBorrowingResponse.class));

        return ResultHelper.cursor(bookBorrowingResponsePage);
    }

    @GetMapping("/{bookBorrowingId}")
    @ResponseStatus(HttpStatus.OK)
    public  ResultData<BookBorrowingResponse> get (@PathVariable("bookBorrowingId") int id){
        BookBorrowing bookBorrowing= this.bookBorrowingService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(bookBorrowing,BookBorrowingResponse.class));
    }
}
