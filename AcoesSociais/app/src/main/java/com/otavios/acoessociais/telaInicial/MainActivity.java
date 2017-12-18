package com.otavios.acoessociais.telaInicial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.otavios.acoessociais.R;
import com.otavios.acoessociais.entidades.AcaoSocial;
import com.otavios.acoessociais.telaMostraConteudo.MostraConteudoActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView{

    @BindView(R.id.rv_actions) RecyclerView rvActions;
    @BindView(R.id.linear_layout_loading) LinearLayout loadingLayout;

    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter = new MainPresenter(this);
        mainPresenter.updateList();
    }

    @Override
    public void updateList(List<AcaoSocial> actionsList) {
        MainAdapter actionsAdapter = new MainAdapter(actionsList, this);
        actionsAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View view, int position) {
                //Toast.makeText(MoviesActivity.this, "Clique Rápido", Toast.LENGTH_SHORT).show();
                Intent openDetailActivity = new Intent(MainActivity.this, MostraConteudoActivity.class);
                openDetailActivity.putExtra("id", mainPresenter.getActionId(position));
                openDetailActivity.putExtra("name",mainPresenter.getActionName(position));
                openDetailActivity.putExtra("image",mainPresenter.getActionImage(position));
                openDetailActivity.putExtra("description",mainPresenter.getActionDescription(position));
                openDetailActivity.putExtra("site",mainPresenter.getActionSite(position));
                startActivity(openDetailActivity);
            }
        });

        rvActions.setAdapter(actionsAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvActions.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        rvActions.addItemDecoration(dividerItemDecoration);
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
}
