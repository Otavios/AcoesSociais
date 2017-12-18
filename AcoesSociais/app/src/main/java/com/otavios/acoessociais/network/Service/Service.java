package com.otavios.acoessociais.network.Service;

import com.otavios.acoessociais.entidades.AcoesListEntity;
import com.otavios.acoessociais.entidades.ConteudoEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {
    @GET("sociais.json")
    Call<AcoesListEntity> getAcoes();

    @GET("id")
    Call<ConteudoEntity> getActionDetail(@Query("id") long actionId);
}
