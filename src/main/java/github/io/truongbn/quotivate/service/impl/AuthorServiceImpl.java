package github.io.truongbn.quotivate.service.impl;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import github.io.truongbn.quotivate.model.Author;
import github.io.truongbn.quotivate.repository.AuthorRepository;
import github.io.truongbn.quotivate.service.AuthorService;
import lombok.RequiredArgsConstructor;

@Service
@EnableCaching
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    @Override
    @Cacheable(value = "authors", key = "{#page, #per_page}")
    public List<Author> getAuthorByPage(int page, int per_page) {
        int offset = (page - 1) * per_page;
        return authorRepository.findAuthorsByPage(offset, per_page);
    }

    @Override
    @Cacheable(value = "authorNameImage", key = "#authorLink")
    public List<Object[]> getNameAndImageByLink(String authorLink) {
        return authorRepository.findNameAndImageByLink(authorLink);
    }
}
