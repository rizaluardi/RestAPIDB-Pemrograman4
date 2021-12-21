package com.appsmor.restapirizaluardi.rest;

import com.appsmor.restapirizaluardi.model.GetAlamat;
import com.appsmor.restapirizaluardi.model.PostPutDelAlamat;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterfaceAlamat {
    @GET("alamat_android")
    Call<GetAlamat> getAlamat();

    @FormUrlEncoded
    @POST("alamat")
    Call<PostPutDelAlamat> postAlamat(@Field("alamat") String alamat,
                                      @Field("kodepos") String kodepos);

    @FormUrlEncoded
    @PUT("alamat")
    Call<PostPutDelAlamat> putAlamat(@Field("id") String id,
                                     @Field("alamat") String alamat,
                                     @Field("kodepos") String kodepos);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "alamat", hasBody = true)
    Call<PostPutDelAlamat> deleteAlamat(@Field("id") String id);
}