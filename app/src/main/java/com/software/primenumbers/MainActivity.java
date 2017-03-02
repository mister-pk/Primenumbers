package com.software.primenumbers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("djinni-primes");
    }
    private RecyclerView rvPrimeNumbers;
    private PrimeNumbersAdapter primesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPrimeNumbers =(RecyclerView) findViewById(R.id.rvPrimeNumbers);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvPrimeNumbers.setLayoutManager(layoutManager);
        primesAdapter = new PrimeNumbersAdapter(this,new PrimeNumbers());

        rvPrimeNumbers.setAdapter(primesAdapter);
    }


}
