package br.com.gabriel.desafio_mobfiq.presentation.vitrine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Callback;

import java.util.List;

import br.com.gabriel.desafio_mobfiq.R;
import br.com.gabriel.desafio_mobfiq.data.remote.model.produto.Produtos;
import br.com.gabriel.desafio_mobfiq.model.Product;
import br.com.gabriel.desafio_mobfiq.util.PicassoCache;

/**
 * Created by Gabriel on 26/07/2017.
 */

public class VitrineAdapter extends RecyclerView.Adapter<VitrineViewHolder> {

    private List<Product> items;
    private Context context;

    public VitrineAdapter(List<Product> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public VitrineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        context = parent.getContext();
        return new VitrineViewHolder(v);
    }

    @Override
    public void onBindViewHolder(VitrineViewHolder holder, int position) {
        Product product = items.get(position);

        holder.tv_desconto.setText(String.format("%s\n off",product.getSkus().get(0).getSellers().get(0).getDesconto()));
        holder.tv_name_product.setText(String.format("%s",product.getName()));
        holder.tv_preco_tabela.setText(String.format("%s",product.getSkus().get(0).getSellers().get(0).getListPrice()));
        holder.tv_preco.setText(String.format("%s",product.getSkus().get(0).getSellers().get(0).getPrice()));
        holder.tv_opcao_parcel.setText(String.format("%s de R$ %s",product.getSkus().get(0).getSellers().get(0).getBestInstallment().getCount(),product.getSkus().get(0).getSellers().get(0).getBestInstallment().getValue()));

        holder.progressBar.setVisibility(View.VISIBLE);
//        PicassoCache.getPicassoInstance(context).load(product.getImages().get(0).getImageUrl()).into(holder.img_, new Callback() {
//            @Override
//            public void onSuccess() {
//                holder.progressBar.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void onError() {
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    void setItems(List<Product> products){
        this.items = products;
        this.notifyDataSetChanged();
    }

    void arrangeItems(List<Product> products){
        this.items.addAll(products);
        this.notifyItemChanged(items.size()-1);
    }
}
