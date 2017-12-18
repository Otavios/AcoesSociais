package com.otavios.acoessociais.telaMostraConteudo;

import com.otavios.acoessociais.entidades.ConteudoEntity;
import com.otavios.acoessociais.network.Api.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MostraConteudoPresenter {
    private MostraConteudoView view;

    public MostraConteudoPresenter(MostraConteudoView view) {
        this.view = view;
    }

    public void getActionDetail(long idMovieSelected) {
        final Api acoesApi =  Api.getInstance();
        view.showLoading();
        acoesApi.getActionDetail(idMovieSelected).enqueue(new Callback<ConteudoEntity>() {
            @Override
            public void onResponse(Call<ConteudoEntity> call, Response<ConteudoEntity> response) {
                view.hideLoading();
                ConteudoEntity conteudoEntity = response.body();
                if(conteudoEntity != null)
                    view.showDetails(conteudoEntity);
                else
                    view.showMessage("Falha no login");
            }

            @Override
            public void onFailure(Call<ConteudoEntity> call, Throwable t) {
                view.hideLoading();
                view.showMessage("Falha no acesso ao servidor");
            }
        });
    }

}
