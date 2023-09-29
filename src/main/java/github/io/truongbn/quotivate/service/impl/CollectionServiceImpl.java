package github.io.truongbn.quotivate.service.impl;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import github.io.truongbn.quotivate.model.Collection;
import github.io.truongbn.quotivate.repository.CollectionRepository;
import github.io.truongbn.quotivate.service.CollectionService;
import lombok.RequiredArgsConstructor;

@Service
@EnableCaching
@RequiredArgsConstructor
public class CollectionServiceImpl implements CollectionService {
    private final CollectionRepository collectionRepository;
    @Override
    @Cacheable(value = "collections", key = "{#page, #per_page}")
    public List<Collection> getCollectionsByPage(int page, int per_page) {
        int offset = (page - 1) * per_page;
        return collectionRepository.findCollectionsByPage(offset, per_page);
    }

    @Override
    @Cacheable(value = "collectionNameImage", key = "#collectionLink")
    public List<Object[]> getNameAndImageByLink(String collectionLink) {
        return collectionRepository.findNameAndImageByLink(collectionLink);
    }
}
