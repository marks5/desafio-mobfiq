package br.com.gabriel.desafio_mobfiq.presentation.categorias;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.List;

import br.com.gabriel.desafio_mobfiq.R;
import br.com.gabriel.desafio_mobfiq.injection.Injection;
import br.com.gabriel.desafio_mobfiq.model.Category;
import br.com.gabriel.desafio_mobfiq.model.Product;
import br.com.gabriel.desafio_mobfiq.presentation.vitrine.VitrineAdapter;
import br.com.gabriel.desafio_mobfiq.presentation.vitrine.VitrinePresenter;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CategoriasActivity extends AppCompatActivity implements CategoriasContract.View {

    private ImageView icon_back;
    private RecyclerView rv_categorias;
    private ProgressBar progress_bar_item;
    private CategoriasPresenter categoriasPresenter;
    private CategoriasAdapter categoriasAdapter;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);
        categoriasPresenter = new CategoriasPresenter(Schedulers.io(), AndroidSchedulers.mainThread(), Injection.provideMobfiq());
        categoriasPresenter.attachView(this);

        rv_categorias = (RecyclerView) findViewById(R.id.rv_categorias);
        progress_bar_item = (ProgressBar) findViewById(R.id.progress_bar_item);
        icon_back = (ImageView) findViewById(R.id.icon_back);

        categoriasAdapter = new CategoriasAdapter(null,this);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv_categorias.setLayoutManager(llm);

        rv_categorias.setAdapter(categoriasAdapter);

        icon_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        snackbar = Snackbar.make(findViewById(R.id.coordinator_main_no), R.string.err_,Snackbar.LENGTH_SHORT);

        categoriasPresenter.listCategorias();
    }

    @Override
    public void showResults(List<Category> categories) {
        rv_categorias.setVisibility(View.VISIBLE);
        categoriasAdapter.setItems(categories);
    }

    @Override
    public void showLoading() {
        rv_categorias.setVisibility(View.GONE);
        progress_bar_item.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        rv_categorias.setVisibility(View.VISIBLE);
        progress_bar_item.setVisibility(View.GONE);
    }

    @Override
    public void showErrorSnack(String mensagem) {
        snackbar.setAction(mensagem, view -> {
            categoriasPresenter.listCategorias();
        });

        snackbar.show();
    }
}
