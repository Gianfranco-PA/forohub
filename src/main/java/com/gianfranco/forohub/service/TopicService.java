package com.gianfranco.forohub.service;

import com.gianfranco.forohub.dto.TopicDTO;

import java.util.List;

public interface TopicService {

    List<TopicDTO> findAll();
    TopicDTO findById(Long id);
    TopicDTO save(TopicDTO topic);
    TopicDTO update(Long id,TopicDTO topic);
    void deleteById(Long id);
}
