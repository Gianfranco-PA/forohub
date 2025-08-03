package com.gianfranco.forohub.controller;

import com.gianfranco.forohub.dto.TopicDTO;
import com.gianfranco.forohub.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/topic")
public class TopicController {

    private TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public ResponseEntity<List<TopicDTO>> findAll() {
        List<TopicDTO> list = topicService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDTO> findById(@PathVariable Long id) {
        TopicDTO dto = topicService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<TopicDTO> save(@RequestBody @Valid TopicDTO topicDTO) {
        TopicDTO saved = topicService.save(topicDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.id())
                .toUri();
        return ResponseEntity
                .created(location)
                .body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicDTO> update(@PathVariable Long id, @RequestBody @Valid TopicDTO topicDTO) {
        TopicDTO updated = topicService.update(id, topicDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        topicService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
