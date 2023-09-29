package github.io.truongbn.quotivate.service;

import java.util.List;

import github.io.truongbn.quotivate.model.Author;

public interface AuthorService {
    List<Author> getAuthorByPage(int page, int per_page);

    List<Object[]> getNameAndImageByLink(String authorLink);
}
