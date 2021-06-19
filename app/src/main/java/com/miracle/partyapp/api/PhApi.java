package com.miracle.partyapp.api;

import com.miracle.partyapp.model.LoginPhUser;
import com.miracle.partyapp.model.PhResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PhApi{
    @POST("user/login-user/")
    public Call<PhResponse> getUserToken(@Body LoginPhUser user);
}
