package com.otavios.acoessociais.entidades;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AcoesListEntity {
    @SerializedName("acoes_sociais") @Expose
    private List<AcaoSocial> acoesSociais = null;

    public List<AcaoSocial> getAcoesSociais() {
        return acoesSociais;
    }
}
