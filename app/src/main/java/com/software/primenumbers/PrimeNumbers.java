package com.software.primenumbers;

import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;


public class PrimeNumbers {
    private final Executor executor = Executors.newSingleThreadExecutor();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private AtomicBoolean loading = new AtomicBoolean(false);
    private List<Integer> items = new ArrayList<>();

    public PrimeNumbers() {
        items.add(2);
    }

    public void loadMore(final OnLoadListener onLoadListener) {
        if (!loading.compareAndSet(false, true))
            return;
        executor.execute(new Runnable() {
            @Override
            public void run() {
                final List<Integer> nextItems = new ArrayList<>();
                int previous = items.get(items.size() - 1);
                for (int i = 0; i < 15; i++) {
                    previous = PrimeNumberGenerator.generatePrime(previous);
                    nextItems.add(previous);
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        items.addAll(nextItems);
                        onLoadListener.onLoad(items.size() -nextItems.size(),nextItems.size());
                        loading.set(false);
                    }
                });
            }
        });
    }
    public int size() {
        return items.size();
    }
    public int get(int position) {
        return items.get(position);
    }

    interface OnLoadListener {
        void onLoad(int position,int counter);
    }

}
