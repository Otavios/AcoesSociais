package com.otavios.acoessociais.telaInicial;

import com.otavios.acoessociais.entidades.AcaoSocial;

import java.util.List;

public interface MainView {
    void updateList(List<AcaoSocial> movieList);
    void showMessage(String msg);
    void showLoading();
    void hideLoading();
}
