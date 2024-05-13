package dev.patika.library.api;

import dev.patika.library.business.abstracts.CategoryService;
import dev.patika.library.core.config.modelMapper.ModelMapperService;
import dev.patika.library.core.result.Result;
import dev.patika.library.core.result.ResultData;
import dev.patika.library.core.utilities.ResultHelper;
import dev.patika.library.dto.request.category.CategorySaveRequest;
import dev.patika.library.dto.request.category.CategoryUpdateRequest;
import dev.patika.library.dto.request.publisher.PublisherSaveRequest;
import dev.patika.library.dto.request.publisher.PublisherUpdateRequest;
import dev.patika.library.dto.response.CursorResponse;
import dev.patika.library.dto.response.category.CategoryResponse;
import dev.patika.library.dto.response.publisher.PublisherResponse;
import dev.patika.library.entities.Category;
import dev.patika.library.entities.Publisher;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private  final ModelMapperService modelMapperService;

    public CategoryController(CategoryService categoryService, ModelMapperService modelMapperService) {
        this.categoryService = categoryService;
        this.modelMapperService = modelMapperService;
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CategoryResponse> save (@Valid @RequestBody CategorySaveRequest categorySaveRequest){
        Category saveCategory= this.modelMapperService.forRequest().map(categorySaveRequest,Category.class);
        this.categoryService.save(saveCategory);
        return ResultHelper.created(this.modelMapperService.forResponse().map(saveCategory,CategoryResponse.class));
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CategoryResponse> update (@Valid @RequestBody CategoryUpdateRequest categoryUpdateRequest){
        Category updateCategory= this.modelMapperService.forRequest().map(categoryUpdateRequest,Category.class);
        this.categoryService.update(updateCategory);
        return ResultHelper.success(this.modelMapperService.forResponse().map(updateCategory,CategoryResponse.class));
    }

    @DeleteMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable ("categoryId")int id){
        this.categoryService.delete(id);
        return ResultHelper.successResult();
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<CategoryResponse>> cursor(
            @RequestParam(name= "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize",required = false,defaultValue = "10") int pageSize
    )
    {
        Page<Category> categoryPage = this.categoryService.cursor(page, pageSize);
        Page<CategoryResponse> categoryResponsePage = categoryPage
                .map(category -> this.modelMapperService.forResponse().map(category, CategoryResponse.class));

        return ResultHelper.cursor(categoryResponsePage);
    }

    @GetMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public  ResultData<CategoryResponse> get (@PathVariable("categoryId") int id){
        Category category= this.categoryService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(category,CategoryResponse.class));
    }

}
