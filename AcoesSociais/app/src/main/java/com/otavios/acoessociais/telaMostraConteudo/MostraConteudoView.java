package com.otavios.acoessociais.telaMostraConteudo;

import com.otavios.acoessociais.entidades.ConteudoEntity;

public interface MostraConteudoView {

    void showDetails(ConteudoEntity detailEntity);
    void showMessage(String msg);
    void showLoading();
    void hideLoading();

}
