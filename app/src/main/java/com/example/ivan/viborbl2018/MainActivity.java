package com.example.ivan.viborbl2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

public class MainActivity extends AppCompatActivity {
    private  RecyclerView recyclerView;
    private List<Device_id> device_id;
    private RecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Device_name name=new Device_name();
        name.device_id="ID_АППАРАТА";
        name.device_name="НАЗВАНИЕ_АПАРАТА";
        recyclerView=(RecyclerView)findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://adlibtech.ru").addConverterFactory(GsonConverterFactory.create()).build();
        final ApiPost apiPost=retrofit.create(ApiPost.class);

        Call<List<Device_id>> call=apiPost.device_id(name);
        call.enqueue(new Callback<List<Device_id>>() {
            @Override
            public void onResponse(Call<List<Device_id>> call, Response<List<Device_id>> response) {
                List<Device_id> device_id=response.body();

                adapter=new RecyclerAdapter(getApplicationContext(),device_id);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Device_id>> call, Throwable t) {

            }
        });
    }


}
