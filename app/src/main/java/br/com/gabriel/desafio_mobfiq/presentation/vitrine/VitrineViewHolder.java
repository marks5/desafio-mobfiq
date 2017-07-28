package br.com.gabriel.desafio_mobfiq.presentation.vitrine;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import br.com.gabriel.desafio_mobfiq.R;
import br.com.gabriel.desafio_mobfiq.data.remote.model.produto.Image;

/**
 * Created by Gabriel on 26/07/2017.
 */

public class VitrineViewHolder extends RecyclerView.ViewHolder {

    public TextView tv_desconto, tv_name_product, tv_preco_tabela, tv_preco, tv_opcao_parcel;
    public ImageView img_;
    public ProgressBar progressBar;

    public VitrineViewHolder(View itemView) {
        super(itemView);
        tv_desconto = (TextView) itemView.findViewById(R.id.tv_desconto);
        tv_name_product = (TextView) itemView.findViewById(R.id.tv_name_product);
        tv_preco_tabela = (TextView) itemView.findViewById(R.id.tv_preco_tabela);
        tv_preco = (TextView) itemView.findViewById(R.id.tv_preco);
        tv_opcao_parcel = (TextView) itemView.findViewById(R.id.tv_opcao_parcel);
        progressBar = (ProgressBar) itemView.findViewById(R.id.progressbar_item);

        img_ = (ImageView) itemView.findViewById(R.id.img_);
    }

}
