package com.ktgame.reactivestreams.reactivetest;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.Arrays;

public class MyPublisher implements Publisher<Integer> {

    Iterable<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        System.out.println("1. 구독자 : 신문사야 나 너희 신문 볼께");
        System.out.println("2. 신문사 : 구독 정보를 만들어서 전달해 줄게");
        MySubscription mySubscription = new MySubscription(subscriber, data);
        System.out.println("3. 신문사 : 구독 정보 생성 완료했으니 잘 받아");
        subscriber.onSubscribe(mySubscription);
    }
}
