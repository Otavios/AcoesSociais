package com.otavios.acoessociais.telaInicial;

import com.otavios.acoessociais.entidades.AcaoSocial;
import com.otavios.acoessociais.entidades.AcoesListEntity;
import com.otavios.acoessociais.network.Api.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private MainView mainView;
    private AcoesListEntity actionsListEntity;
    private List<AcaoSocial> actionsList;

    MainPresenter(MainView mainView){
        this.mainView = mainView;
    }

    void updateList(){
        final Api acoesApi = Api.getInstance();
        mainView.showLoading();
        acoesApi.getAcoes().enqueue(new Callback<AcoesListEntity>() {
            @Override
            public void onResponse(Call<AcoesListEntity> call, Response<AcoesListEntity> response) {
                mainView.hideLoading();
                actionsListEntity = response.body();
                if(actionsListEntity != null){
                    actionsList = actionsListEntity.getAcoesSociais();
                    mainView.updateList(actionsList);
                } else {
                    mainView.showMessage("Falha no acesso ao servidor");
                }
            }

            @Override
            public void onFailure(Call<AcoesListEntity> call, Throwable t) {
                mainView.hideLoading();
                mainView.showMessage("Falha no acesso ao servidor");
            }
        });
    }

    long getActionId(int position) throws IndexOutOfBoundsException {
        return actionsList.get(position).getId();
    }

    String getActionName(int position) throws IndexOutOfBoundsException {
        return actionsList.get(position).getName();
    }
    String getActionDescription(int position) throws IndexOutOfBoundsException {
        return actionsList.get(position).getDescription();
    }
    String getActionSite(int position) throws IndexOutOfBoundsException {
        return actionsList.get(position).getSite();
    }
    String getActionImage(int position) throws IndexOutOfBoundsException {
        return actionsList.get(position).getImage();
    }
}
