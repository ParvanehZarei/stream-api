package com.demo.stream.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@RequestMapping("/api/stream")
@RestController
public class StreamAPI {
    @GetMapping(value="/data")
    public ResponseEntity<StreamingResponseBody> streamData() {
        StreamingResponseBody responseBody = response -> {
            for (int i = 1; i <= 100; i++) {
                try {
                    Thread.sleep(i * 100);
                    response.write(("Java microservices are a set of software applications written in the Java programming " +
                            "language (and typically leverage the vast ecosystem of Java tools and frameworks), designed for " +
                            "limited scope that work with each other to form a bigger solution. Each microservice, as the name " +
                            "implies, has minimal capabilities for the sake of creating a very modularized overall architecture." +
                            " A microservices architecture is analogous to a manufacturing assembly line, where each microservice " +
                            "is like a station in the assembly line. Just as each station is responsible for one specific task, " +
                            "the same holds true for microservices. Each station and microservice are “experts” in their given " +
                            "responsibilities, thus promoting efficiency, consistency, and quality in the workflow and the outputs. " +
                            "Contrast that to a manufacturing environment in which each station is responsible for building the " +
                            "entire product itself. This is analogous to a monolithic software application that performs all " +
                            "tasks within the same process. " +
                            "line - " + i + "\n").getBytes());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(responseBody);
    }
}
