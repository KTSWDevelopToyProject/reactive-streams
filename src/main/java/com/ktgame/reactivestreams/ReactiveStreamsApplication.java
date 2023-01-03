package com.ktgame.reactivestreams;

import com.ktgame.reactivestreams.reactivetest.MyPublisher;
import com.ktgame.reactivestreams.reactivetest.MySubscriber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveStreamsApplication {

    public static void main(String[] args) {

        SpringApplication.run(ReactiveStreamsApplication.class, args);

        MyPublisher myPublisher = new MyPublisher();
        MySubscriber mySubscriber = new MySubscriber();

        myPublisher.subscribe(mySubscriber);

    }

}
