package github.io.truongbn.quotivate.service.impl;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import github.io.truongbn.quotivate.model.Topic;
import github.io.truongbn.quotivate.repository.TopicRepository;
import github.io.truongbn.quotivate.service.TopicService;
import lombok.RequiredArgsConstructor;

@Service
@EnableCaching
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;
    @Override
    @Cacheable(value = "topics", key = "{#page, #per_page}")
    public List<Topic> getTopicsByPage(int page, int per_page) {
        int offset = (page - 1) * per_page;
        return topicRepository.findTopicsByPage(offset, per_page);
    }

    @Override
    @Cacheable(value = "topicNameImage", key = "#topicLink")
    public List<Object[]> getNameAndImageByLink(String topicLink) {
        return topicRepository.findNameAndImageByLink(topicLink);
    }
}
