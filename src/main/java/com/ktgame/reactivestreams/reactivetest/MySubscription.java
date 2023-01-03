package com.ktgame.reactivestreams.reactivetest;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Iterator;

// 구독정보 (구독자, 구독데이터)
public class MySubscription implements Subscription {

    private Subscriber subscriber;
    private Iterator<Integer> data;

    public MySubscription(Subscriber subscriber, Iterable<Integer> data) {
        this.subscriber = subscriber;
        this.data = data.iterator();
    }

    @Override
    public void request(long l) {
        while (l > 0) {
            if (data.hasNext()) {
                subscriber.onNext(data.next());
            } else {
                subscriber.onComplete();
                break;
            }
            l--;
        }
    }

    @Override
    public void cancel() {

    }
}
