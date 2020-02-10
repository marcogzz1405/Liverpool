package com.example.liverpool.api;

import com.example.liverpool.models.Productos;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("tienda")
    @FormUrlEncoded
    Call<Productos> getProductos(@Field("s") String producto,
                            @Field("d3106047a194921c01969dfdec083925") String json);

}
