package dev.patika.library.api;


import dev.patika.library.business.abstracts.PublisherService;
import dev.patika.library.core.config.modelMapper.ModelMapperService;
import dev.patika.library.core.result.Result;
import dev.patika.library.core.result.ResultData;
import dev.patika.library.core.utilities.ResultHelper;
import dev.patika.library.dto.request.publisher.PublisherSaveRequest;
import dev.patika.library.dto.request.publisher.PublisherUpdateRequest;
import dev.patika.library.dto.response.CursorResponse;
import dev.patika.library.dto.response.publisher.PublisherResponse;
import dev.patika.library.entities.Publisher;
import jakarta.validation.Valid;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/publishers")
public class PublisherController {
    private  final PublisherService publisherService;
    private  final ModelMapperService modelMapperService;
    private final ModelMapper modelMapper;



    public PublisherController(PublisherService publisherService, ModelMapperService modelMapperService,
                               ModelMapper modelMapper) {
        this.publisherService = publisherService;
        this.modelMapperService = modelMapperService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<PublisherResponse> save (@Valid @RequestBody PublisherSaveRequest publisherSaveRequest){
        Publisher savePublisher= this.modelMapperService.forRequest().map(publisherSaveRequest,Publisher.class);
        this.publisherService.save(savePublisher);
        return ResultHelper.created(this.modelMapperService.forResponse().map(savePublisher,PublisherResponse.class));
    }
    @GetMapping("/{publisherId}")
    @ResponseStatus(HttpStatus.OK)
    public  ResultData<PublisherResponse> get (@PathVariable("publisherId") int id){
        Publisher publisher= this.publisherService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(publisher,PublisherResponse.class));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<PublisherResponse>> cursor(
            @RequestParam(name= "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize",required = false,defaultValue = "10") int pageSize
    )
    {
        Page<Publisher> publisherPage = this.publisherService.cursor(page, pageSize);
        Page<PublisherResponse> publisherResponsePage = publisherPage
                .map(publisher -> this.modelMapperService.forResponse().map(publisher, PublisherResponse.class));

        return ResultHelper.cursor(publisherResponsePage);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<PublisherResponse> update (@Valid @RequestBody PublisherUpdateRequest publisherUpdateRequest){
        Publisher updatePublisher= this.modelMapperService.forRequest().map(publisherUpdateRequest,Publisher.class);
        this.publisherService.update(updatePublisher);
        return ResultHelper.success(this.modelMapperService.forResponse().map(updatePublisher,PublisherResponse.class));
    }

    @DeleteMapping("/{publisherId}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable ("publisherId")int id){
        this.publisherService.delete(id);
        return ResultHelper.successResult();
    }

}
