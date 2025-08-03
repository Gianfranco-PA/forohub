package com.gianfranco.forohub.service;

import com.gianfranco.forohub.config.TopicMapper;
import com.gianfranco.forohub.dto.TopicDTO;
import com.gianfranco.forohub.model.Status;
import com.gianfranco.forohub.model.Topic;
import com.gianfranco.forohub.repository.TopicRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicServiceImpl implements TopicService {

    private TopicRepository topicRepository;
    private TopicMapper topicMapper;

    public TopicServiceImpl(TopicRepository topicRepository, TopicMapper topicMapper) {
        this.topicRepository = topicRepository;
        this.topicMapper = topicMapper;
    }

    @Override
    public List<TopicDTO> findAll() {
        return topicRepository.findAll().stream().map(topicMapper::toTopicDTO).collect(Collectors.toList());
    }

    @Override
    public TopicDTO findById(Long id) {
        return topicRepository.findById(id).map(topicMapper::toTopicDTO).orElseThrow(() -> new EntityNotFoundException("Topic " + id + " not found"));
    }

    @Override
    public TopicDTO save(TopicDTO topic) {
        Topic newTopic = topicMapper.toTopic(topic);
        if (newTopic.getStatus() == null) {
            newTopic.setStatus(Status.ACTIVE);
        }
        newTopic.setCreatedAt(LocalDateTime.now());
        return topicMapper.toTopicDTO(topicRepository.save(newTopic));
    }

    @Override
    public TopicDTO update(Long id, TopicDTO topic) {
        Topic foundTopic = topicRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Topic " + id + " not found"));
        Topic updatedTopic = topicMapper.toTopic(topic);
        if (updatedTopic.getStatus() == null) {
            updatedTopic.setStatus(foundTopic.getStatus());
        }
        updatedTopic.setId(foundTopic.getId());
        return topicMapper.toTopicDTO(topicRepository.save(updatedTopic));
    }

    @Override
    public void deleteById(Long id) {
        Topic foundTopic = topicRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Topic " + id + " not found"));
        topicRepository.delete(foundTopic);
    }
}
