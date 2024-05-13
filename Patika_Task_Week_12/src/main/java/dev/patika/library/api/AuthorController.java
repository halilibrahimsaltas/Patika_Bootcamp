package dev.patika.library.api;


import dev.patika.library.business.abstracts.AuthorService;
import dev.patika.library.business.abstracts.BookService;
import dev.patika.library.business.abstracts.CategoryService;
import dev.patika.library.business.abstracts.PublisherService;
import dev.patika.library.core.config.modelMapper.ModelMapperService;
import dev.patika.library.core.result.Result;
import dev.patika.library.core.result.ResultData;
import dev.patika.library.core.utilities.ResultHelper;
import dev.patika.library.dto.request.author.AuthorSaveRequest;
import dev.patika.library.dto.request.author.AuthorUpdateRequest;
import dev.patika.library.dto.request.book.BookSaveRequest;
import dev.patika.library.dto.request.book.BookUpdateRequest;
import dev.patika.library.dto.response.CursorResponse;
import dev.patika.library.dto.response.author.AuthorResponse;
import dev.patika.library.dto.response.book.BookResponse;
import dev.patika.library.entities.Author;
import dev.patika.library.entities.Book;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/authors")
public class AuthorController {

    private  final AuthorService authorService;
    private  final BookService bookService;

    private  final ModelMapperService modelMapperService;

    public AuthorController(AuthorService authorService, BookService bookService, ModelMapperService modelMapperService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.modelMapperService = modelMapperService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AuthorResponse> save (@Valid @RequestBody AuthorSaveRequest authorSaveRequest){
        Author saveAuthor= this.modelMapperService.forRequest().map(authorSaveRequest,Author.class);

        this.authorService.save(saveAuthor);
        return ResultHelper.created(this.modelMapperService.forResponse().map(saveAuthor,AuthorResponse.class));
    }
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AuthorResponse> update (@Valid @RequestBody AuthorUpdateRequest authorUpdateRequest){
        Author updateAuthor= this.modelMapperService.forRequest().map(authorUpdateRequest,Author.class);
        this.authorService.update(updateAuthor);
        return ResultHelper.success(this.modelMapperService.forResponse().map(updateAuthor,AuthorResponse.class));
    }

    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable ("authorId")int id){
        this.authorService.delete(id);
        return ResultHelper.successResult();
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<AuthorResponse>> cursor(
            @RequestParam(name= "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize",required = false,defaultValue = "10") int pageSize
    )
    {
        Page<Author> authorPage = this.authorService.cursor(page, pageSize);
        Page<AuthorResponse> authorResponsePage = authorPage
                .map(author -> this.modelMapperService.forResponse().map(author, AuthorResponse.class));

        return ResultHelper.cursor(authorResponsePage);
    }
    @GetMapping("/{authorId}")
    @ResponseStatus(HttpStatus.OK)
    public  ResultData<AuthorResponse> get (@PathVariable("authorId") int id){
        Author author= this.authorService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(author,AuthorResponse.class));
    }
}
