package dev.patika.library.api;

import dev.patika.library.business.abstracts.BookService;
import dev.patika.library.business.abstracts.CategoryService;
import dev.patika.library.business.abstracts.PublisherService;
import dev.patika.library.core.config.modelMapper.ModelMapperService;
import dev.patika.library.core.result.Result;
import dev.patika.library.core.result.ResultData;
import dev.patika.library.core.utilities.ResultHelper;
import dev.patika.library.dto.request.book.BookSaveRequest;
import dev.patika.library.dto.request.book.BookUpdateRequest;
import dev.patika.library.dto.request.category.CategorySaveRequest;
import dev.patika.library.dto.request.category.CategoryUpdateRequest;
import dev.patika.library.dto.response.CursorResponse;
import dev.patika.library.dto.response.book.BookResponse;
import dev.patika.library.dto.response.category.CategoryResponse;
import dev.patika.library.entities.Book;
import dev.patika.library.entities.Category;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/books")
public class BookController {

    private  final BookService bookService;

    private  final ModelMapperService modelMapperService;

    private  final CategoryService categoryService;

    private  final PublisherService publisherService;

    public BookController(BookService bookService, ModelMapperService modelMapperService,
                          CategoryService categoryService, PublisherService publisherService) {
        this.bookService = bookService;
        this.modelMapperService = modelMapperService;
        this.categoryService = categoryService;
        this.publisherService = publisherService;
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookResponse> save (@Valid @RequestBody BookSaveRequest bookSaveRequest){
        Book saveBook= this.modelMapperService.forRequest().map(bookSaveRequest,Book.class);

        /*Category category = this.categoryService.get(bookSaveRequest.getCategoryId());

         */

        this.bookService.save(saveBook);
        return ResultHelper.created(this.modelMapperService.forResponse().map(saveBook,BookResponse.class));
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookResponse> update (@Valid @RequestBody BookUpdateRequest bookUpdateRequest){
        Book updateBook= this.modelMapperService.forRequest().map(bookUpdateRequest,Book.class);
        this.bookService.update(updateBook);
        return ResultHelper.success(this.modelMapperService.forResponse().map(updateBook,BookResponse.class));
    }

    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable ("bookId")int id){
        this.bookService.delete(id);
        return ResultHelper.successResult();
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<BookResponse>> cursor(
            @RequestParam(name= "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize",required = false,defaultValue = "10") int pageSize
    )
    {
        Page<Book> bookPage = this.bookService.cursor(page, pageSize);
        Page<BookResponse> bookResponsePage = bookPage
                .map(book -> this.modelMapperService.forResponse().map(book, BookResponse.class));

        return ResultHelper.cursor(bookResponsePage);
    }

    @GetMapping("/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public  ResultData<BookResponse> get (@PathVariable("bookId") int id){
        Book book= this.bookService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(book,BookResponse.class));
    }

}
