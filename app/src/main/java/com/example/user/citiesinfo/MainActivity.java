package com.example.user.citiesinfo;

import android.service.autofill.UserData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.citiesinfo.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recView;
    private List <CitiesData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();

    }

    private void initRecyclerView(){
        recView = findViewById(R.id.recView);
        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.setHasFixedSize(false);
        RecViewAdapter recViewAdapter = new RecViewAdapter(initCitiesData());
        recView.setAdapter(recViewAdapter);
    }

    private List<CitiesData> initCitiesData() {
        list = new ArrayList<>();
        list.add(new CitiesData(R.drawable.ekb,R.string.ekbString));
        list.add(new CitiesData(R.drawable.kazan,R.string.kazanString));
        list.add(new CitiesData(R.drawable.krasnodar,R.string.krasnodarString));
        list.add(new CitiesData(R.drawable.london,R.string.londonString));
        list.add(new CitiesData(R.drawable.moscow,R.string.mocsowString));
        list.add(new CitiesData(R.drawable.piter,R.string.piterString));
        return list;
    }


}
