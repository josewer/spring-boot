package com.josewer.demo01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "greeting")
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();
    private static final String template = "Hola %s";

    // http://localhost:8080/greeting?name=jose
    @GetMapping
    public Greeting greeting(@RequestParam(value = "name" , defaultValue = "World") String name) {
        Long id = counter.incrementAndGet();
        String message = String.format(template , name);
        return new Greeting(id , message);
    }
}
