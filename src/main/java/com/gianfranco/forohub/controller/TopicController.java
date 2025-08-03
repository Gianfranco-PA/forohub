package com.gianfranco.forohub.controller;

import com.gianfranco.forohub.dto.TopicDTO;
import com.gianfranco.forohub.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topic")
public class TopicController {

    private TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public List<TopicDTO> findAll() {
        return topicService.findAll();
    }

    @GetMapping("/{id}")
    public TopicDTO findById(@PathVariable Long id) {
        return topicService.findById(id);
    }

    @PostMapping
    public TopicDTO save(@RequestBody @Valid TopicDTO topicDTO) {
        return topicService.save(topicDTO);
    }

    @PutMapping("/{id}")
    public TopicDTO update(@PathVariable Long id,@RequestBody @Valid TopicDTO topicDTO) {
        return topicService.update(id, topicDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        topicService.deleteById(id);
    }
}
