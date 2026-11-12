package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  private static final String template = "你好, %s!";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/greeting")
  public Greeting greeting(@RequestParam(defaultValue = "World") String name) {
    return new Greeting(counter.incrementAndGet(), template.formatted(name));
  }

  @GetMapping("/goodbye")
  public Greeting goodbye(@RequestParam(defaultValue="World") String name){
    return new Greeting(counter.incrementAndGet(),"再见，%s!".formatted(name));
  }
  @GetMapping("/welcome")
  public Greeting welcome(@RequestParam(defaultValue="World") String name){
    return new Greeting (counter.incrementAndGet(),"欢迎，%s!".formatted(name));
  }
}
