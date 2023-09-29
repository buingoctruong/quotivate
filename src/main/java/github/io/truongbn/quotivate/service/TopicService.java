package github.io.truongbn.quotivate.service;

import java.util.List;

import github.io.truongbn.quotivate.model.Topic;

public interface TopicService {
    List<Topic> getTopicsByPage(int page, int per_page);

    List<Object[]> getNameAndImageByLink(String topicLink);
}
