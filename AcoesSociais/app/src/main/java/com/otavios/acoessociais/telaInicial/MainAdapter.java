package com.otavios.acoessociais.telaInicial;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.otavios.acoessociais.R;
import com.otavios.acoessociais.entidades.AcaoSocial;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{

    private List<AcaoSocial> actionsList;
    private Context context;
    OnRecyclerViewSelected onRecyclerViewSelected;

    public MainAdapter(List<AcaoSocial> actionsList, Context context){
        this.actionsList = actionsList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflada = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);
        return new ViewHolder(inflada);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvHeading.setText(actionsList.get(position).getName());
        Picasso.with(context).load(actionsList.get(position).getImage()).centerCrop().fit().into(holder.ivBackground);
    }

    @Override
    public int getItemCount() {
        return actionsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_background)
        ImageView ivBackground;
        @BindView(R.id.iv_heading)
        TextView tvHeading;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        //seta o clique rápido
        @OnClick(R.id.container)
        void onItemClick(View view){
            if(onRecyclerViewSelected != null)
                onRecyclerViewSelected.onClick(view, getAdapterPosition());

        }
    }

    public void setOnRecyclerViewSelected(OnRecyclerViewSelected onRecyclerViewSelected){
        this.onRecyclerViewSelected = onRecyclerViewSelected;
    }
}
