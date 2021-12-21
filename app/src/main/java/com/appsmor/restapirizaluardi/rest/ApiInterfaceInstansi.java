package com.appsmor.restapirizaluardi.rest;

import com.appsmor.restapirizaluardi.model.GetInstansi;
import com.appsmor.restapirizaluardi.model.PostPutDelInstansi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterfaceInstansi {
    @GET("instansi_android")
    Call<GetInstansi> getInstansi();

    @FormUrlEncoded
    @POST("instansi")
    Call<PostPutDelInstansi> postInstansi(@Field("instansi") String instansi,
                                      @Field("telepon") String telepon);

    @FormUrlEncoded
    @PUT("instansi")
    Call<PostPutDelInstansi> putInstansi(@Field("id") String id,
                                     @Field("instansi") String instansi,
                                     @Field("telepon") String telepon);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "instansi", hasBody = true)
    Call<PostPutDelInstansi> deleteInstansi(@Field("id") String id);
}