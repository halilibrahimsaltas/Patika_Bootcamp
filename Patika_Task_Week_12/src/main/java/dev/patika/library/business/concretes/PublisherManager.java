package dev.patika.library.business.concretes;

import dev.patika.library.business.abstracts.PublisherService;
import dev.patika.library.core.exception.NotFoundException;
import dev.patika.library.core.utilities.Msg;
import dev.patika.library.dao.PublisherRepo;
import dev.patika.library.entities.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PublisherManager implements PublisherService {
    private  final PublisherRepo publisherRepo;

    public PublisherManager(PublisherRepo publisherRepo) {
        this.publisherRepo = publisherRepo;
    }
    @Override
    public Publisher save (Publisher publisher){
        return this.publisherRepo.save(publisher);
    }

    @Override
    public  Publisher get (int id){
        return this.publisherRepo.findById(id).orElseThrow(() ->  new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Publisher> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page,pageSize);
        return this.publisherRepo.findAll(pageable);
    }

    @Override
    public Publisher update(Publisher publisher) {
        this.get(publisher.getPublisherId());
        return this.publisherRepo.save(publisher);
    }

    @Override
    public boolean delete(int id) {
        Publisher publisher=this.get(id);
        this.publisherRepo.delete(publisher);
        return true;
    }
}
