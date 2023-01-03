package com.ktgame.reactivestreams.reactivetest;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MySubscriber implements Subscriber<Integer> {

    private Subscription subscription;
    private Integer bufferSize = 2;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("구독자 : 구독 정보 잘 받았어!!");
        this.subscription = subscription;
        System.out.println("구독자 : 나 이제 매일 신문 2개씩 줘!");
        subscription.request(bufferSize); // 구독자(Subscriber)가 한 번에 받을 구독데이터 갯수 (backpressure)
    }

    @Override
    public void onNext(Integer integer) {
        System.out.println("onNext() : " + integer);
        bufferSize--;
        if (bufferSize == 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("하루 지남");
            bufferSize = 2;
            subscription.request(bufferSize);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("구독 중 에러");
    }

    @Override
    public void onComplete() {
        System.out.println("구독 완료");
    }
}
