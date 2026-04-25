package com.adib.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

// import java.io.IOException;
import java.lang.System;

@Service
public class ConsumerService {
    // @RabbitListener(queues = "myQueue")
    // public void receivedMessage(String message) {
    //     String command = message.trim().toLowerCase();
        
    //     if (command.equals("open youtube")) {
    //         try {
    //             String os = System.getProperty("os.name").toLowerCase();
    //             ProcessBuilder pb;

    //             if (os.contains("win")) {
    //                 // Windows: Needs 'cmd /c' to execute shell commands
    //                 pb = new ProcessBuilder("cmd", "/c", "start", "https://www.youtube.com");
    //             } else if (os.contains("mac")) {
    //                 // macOS: 'open' is the native command
    //                 pb = new ProcessBuilder("open", "https://www.youtube.com");
    //             } else {
    //                 // Linux: 'xdg-open' is the standard
    //                 pb = new ProcessBuilder("xdg-open", "https://www.youtube.com");
    //             }

    //             pb.start();
    //             System.out.println("Command executed successfully!");
                
    //         } catch (IOException e) {
    //             System.err.println("Error launching browser: " + e.getMessage());
    //         }
    //     }

    //     System.out.println("Received: " + message);
    // }

    @RabbitListener(queues = "myQueue")
    public void receivedMessage(MessageDTO message) {
        System.out.println("Received name: " + message.getName());
        System.out.println("Received age: " + message.getAge());
    }
}
