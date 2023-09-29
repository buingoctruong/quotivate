package github.io.truongbn.quotivate.service;

import java.util.List;

import github.io.truongbn.quotivate.model.Collection;

public interface CollectionService {
    List<Collection> getCollectionsByPage(int page, int per_page);

    List<Object[]> getNameAndImageByLink(String collectionLink);
}
