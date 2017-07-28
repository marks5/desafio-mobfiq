package br.com.gabriel.desafio_mobfiq.presentation.categorias;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.gabriel.desafio_mobfiq.R;

/**
 * Created by Gabriel on 26/07/2017.
 */

public class CategoriasViewHolder extends RecyclerView.ViewHolder {

    public TextView tv_name_categoria;

    public CategoriasViewHolder(View itemView) {
        super(itemView);
        tv_name_categoria = (TextView) itemView.findViewById(R.id.tv_name_categoria);
    }
}