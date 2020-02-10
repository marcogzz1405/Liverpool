package com.example.liverpool.api;

import com.example.liverpool.models.Productos;
import com.example.liverpool.utilities.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PresenterBusqueda implements Callback<Productos> {

    public void attempBusqueda(String s){
        Retrofit retrofit = Utils.getClient();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<Productos> request = apiService
    }

    @Override
    public void onResponse(Call<Productos> call, Response<Productos> response) {

    }

    @Override
    public void onFailure(Call<Productos> call, Throwable t) {

    }
}
