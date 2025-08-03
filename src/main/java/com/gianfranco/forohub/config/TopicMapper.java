package com.gianfranco.forohub.config;

import com.gianfranco.forohub.dto.TopicDTO;
import com.gianfranco.forohub.model.Topic;
import org.springframework.stereotype.Component;

@Component
public class TopicMapper {

    public TopicDTO toTopicDTO(Topic topic) {
        return new TopicDTO(topic.getId(),topic.getTitle(), topic.getMessage(), topic.getStatus(), topic.getAuthor(), topic.getCourse());
    }

    public Topic toTopic(TopicDTO topicDTO) {
        return  Topic.builder()
                .id(topicDTO.id())
                .title(topicDTO.title())
                .message(topicDTO.message())
                .status(topicDTO.status())
                .author(topicDTO.author())
                .course(topicDTO.course())
                .build();
    }
}
