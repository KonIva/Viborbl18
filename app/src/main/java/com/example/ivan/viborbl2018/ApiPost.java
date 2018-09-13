package com.example.ivan.viborbl2018;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiPost {
    @POST("elections/api/getcandidates.php")
    public Call<List<Device_id>> device_id(@Body Device_name device_name);




}
