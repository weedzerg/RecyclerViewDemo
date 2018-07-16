package com.lx.ltuddd.demorecyclerview.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lx.ltuddd.demorecyclerview.R;
import com.lx.ltuddd.demorecyclerview.adapters.AdapterViewHero;
import com.lx.ltuddd.demorecyclerview.objects.HeroObject;
import com.lx.ltuddd.demorecyclerview.utils.AssetsReader;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerHero;
    private AdapterViewHero mAdapterHero;
    private ArrayList<HeroObject> mArrHero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
    }

    public void setUpView() {
        mRecyclerHero = (RecyclerView) findViewById(R.id.recycler_hero);
        mRecyclerHero.setLayoutManager(new LinearLayoutManager(getBaseContext(),
                LinearLayoutManager.VERTICAL,
                false));
        mArrHero = AssetsReader.readArrHerro(getBaseContext());
        mAdapterHero = new AdapterViewHero(getBaseContext(), mArrHero);
        mRecyclerHero.setAdapter(mAdapterHero);
    }
}
