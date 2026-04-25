package com.ihsan.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producer")
public class ProducerController {
    @Autowired
    private ProducerService producerService;

    // @GetMapping("/send")
    // public String sendMessage(@RequestParam String message, @RequestParam String additional) {
    //     producerService.sendMessage(message);
    //     return "Message sent: " + message;
    // }

    @PostMapping("/send")
    public ResponseEntity<String> send(@RequestBody MessageDTO dto) {
        producerService.sendMessage(dto);
        return ResponseEntity.ok("Message sent: ");
    }
}
