package com.otavios.acoessociais.network.Api;

import com.otavios.acoessociais.entidades.AcoesListEntity;
import com.otavios.acoessociais.entidades.ConteudoEntity;
import com.otavios.acoessociais.network.Service.Service;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static Api instancia;
    private Service servico;
    private static final String BASE_URL = "https://dl.dropboxusercontent.com/s/50vmlj7dhfaibpj/";

    public static Api getInstance(){
        if (instancia == null){
            instancia = new Api();
        }

        return instancia;
    }

    private Api(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.servico = retrofit.create(Service.class);
    }

    public Call<AcoesListEntity> getAcoes(){
        return servico.getAcoes();
    }

    public Call<ConteudoEntity> getActionDetail(long movieId){
        return servico.getActionDetail(movieId);
    }
}
