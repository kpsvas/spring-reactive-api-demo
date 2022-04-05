package com.example.reactive.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author Srinivas Komatipally
 *
 */

@RestController
public class FooReactiveAPIResource {

    @GetMapping(value="/foo", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getSpeech() {
        Foo foo = new Foo(1, "foo");
        return Flux.just(foo.toString())
                .delayElements(Duration.ofSeconds(1))
                .repeat()
                .log();
    }
}