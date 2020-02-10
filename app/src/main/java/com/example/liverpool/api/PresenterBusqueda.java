package com.example.liverpool.api;

import com.example.liverpool.models.Productos;
import com.example.liverpool.utilities.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PresenterBusqueda implements Callback<Productos> {

    public ListenerBusqueda listener;

    public void attempBusqueda(String s){
        Retrofit retrofit = Utils.getClient();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<Productos> request = apiService.getProductos(s, "json");
        request.enqueue(this);
        if(listener != null){
            listener.showProgress();
        }
    }

    @Override
    public void onResponse(Call<Productos> call, Response<Productos> response) {
        if(response.isSuccessful()){
            Productos productos = response.body();
            if(productos != null) {
                if(listener != null) {
                    listener.successEntry(productos);
                }
            } else {
                if(listener != null){
                    listener.showErrorMessage("Successful is failed");
                }
            }
        } else {
            if(listener != null){
                listener.showErrorMessage("Error");
            }
        }
        if(listener != null){
            listener.hideProgress();
        }
    }

    @Override
    public void onFailure(Call<Productos> call, Throwable t) {
        if(listener != null){
            listener.hideProgress();
            listener.showErrorMessage(t.getMessage());
        }
    }
}
