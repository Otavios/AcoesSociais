package com.otavios.acoessociais.telaMostraConteudo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.otavios.acoessociais.R;
import com.otavios.acoessociais.entidades.ConteudoEntity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MostraConteudoActivity extends AppCompatActivity implements MostraConteudoView{

    MostraConteudoPresenter presenter;

    @BindView(R.id.image_view_header) ImageView imagem;
    @BindView(R.id.action_description) TextView descricao;
    @BindView(R.id.linear_layout_loading) LinearLayout loadingLayout;

    long campo_id;
    String campo_nome;
    String campo_descricao;
    String campo_site;
    String campo_imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_conteudo);
        ButterKnife.bind(this);

        presenter = new MostraConteudoPresenter(this);

        Intent intent = getIntent();

        campo_id = intent.getLongExtra("id", 0);
        campo_nome = intent.getStringExtra("name");
        campo_descricao = intent.getStringExtra("description");
        campo_imagem = intent.getStringExtra("image");
        campo_site = intent.getStringExtra("site");

        presenter.getActionDetail(campo_id);

    }

    @Override
    public void showDetails(ConteudoEntity detailEntity) {
        setTitle(campo_nome);
        descricao.setText(campo_descricao);
        Picasso.with(this).load(campo_imagem).centerCrop().fit().into(imagem);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        loadingLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loadingLayout.setVisibility(View.GONE);
    }

    @OnClick(R.id.info) public void openSite(View view){
        if (campo_site != null || !campo_site.isEmpty()) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(campo_site));
            startActivity(i);
        }
    }
}
