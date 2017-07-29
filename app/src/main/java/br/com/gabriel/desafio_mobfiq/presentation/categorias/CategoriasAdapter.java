package br.com.gabriel.desafio_mobfiq.presentation.categorias;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Callback;

import java.util.List;

import br.com.gabriel.desafio_mobfiq.R;
import br.com.gabriel.desafio_mobfiq.data.remote.model.categoria.Categorias;
import br.com.gabriel.desafio_mobfiq.model.Category;
import br.com.gabriel.desafio_mobfiq.model.Product;
import br.com.gabriel.desafio_mobfiq.presentation.vitrine.VitrineViewHolder;
import br.com.gabriel.desafio_mobfiq.util.PicassoCache;

/**
 * Created by Gabriel on 26/07/2017.
 */

public class CategoriasAdapter extends RecyclerView.Adapter<CategoriasViewHolder> {

    private List<Category> items;
    private Context context;

    public CategoriasAdapter(List<Category> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public CategoriasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categoria, parent, false);
        context = parent.getContext();
        return new CategoriasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CategoriasViewHolder holder, int position) {
        Category category = items.get(position);
        holder.tv_name_categoria.setText(String.format("%s",category.getName()));
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    void setItems(List<Category> categorias){
        this.items = categorias;
        this.notifyDataSetChanged();
    }

}
