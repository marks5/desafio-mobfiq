package br.com.gabriel.desafio_mobfiq.presentation.vitrine;

import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import br.com.gabriel.desafio_mobfiq.R;
import br.com.gabriel.desafio_mobfiq.injection.Injection;
import br.com.gabriel.desafio_mobfiq.model.Product;
import br.com.gabriel.desafio_mobfiq.util.EndlessRecyclerViewScrollListener;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class VitrineActivity extends AppCompatActivity implements VitrineContract.View {

    private Snackbar snackbar;
    private VitrinePresenter vitrinePresenter;
    private RecyclerView rv_products;
    private VitrineAdapter vitrineAdapter;
    private ProgressBar progressBar, progressBarMore;
    private SearchView searchView;
    private Toolbar toolbar;
    private EndlessRecyclerViewScrollListener scrollListener;
    private String querye = "";
    private int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitrine);
        vitrinePresenter = new VitrinePresenter(Schedulers.io(), AndroidSchedulers.mainThread(),Injection.provideMobfiq());
        vitrinePresenter.attachView(this);

        rv_products = (RecyclerView) findViewById(R.id.rv_products);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        progressBarMore = (ProgressBar) findViewById(R.id.progressbar_more);

        vitrineAdapter = new VitrineAdapter(null,this);
        GridLayoutManager glm = new GridLayoutManager(this, 2);
        rv_products.setLayoutManager(glm);

        scrollListener = new EndlessRecyclerViewScrollListener(glm) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                count = count +10;
                vitrinePresenter.searchProducts(querye,count);
            }
        };

        rv_products.addOnScrollListener(scrollListener);
        rv_products.setAdapter(vitrineAdapter);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        snackbar = Snackbar.make(findViewById(R.id.coordinator_main), R.string.err_,Snackbar.LENGTH_SHORT);

        vitrinePresenter.searchProducts("",count);
    }

    @Override
    public void showResults(List<Product> produtos) {
        rv_products.setVisibility(View.VISIBLE);
        scrollListener.resetState();
        vitrineAdapter.setItems(produtos);
    }

    @Override
    public void showErrorSnack(String message) {
        snackbar.setAction(message, view -> {
            vitrinePresenter.searchProducts(querye,count);
        });

        snackbar.show();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
        rv_products.setVisibility(View.GONE);
        progressBarMore.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        rv_products.setVisibility(View.VISIBLE);
        progressBarMore.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showLoadingMore() {
        progressBarMore.setVisibility(View.VISIBLE);
        rv_products.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void hideLoadingMore() {
        progressBarMore.setVisibility(View.GONE);
        rv_products.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_search, menu);
        final MenuItem item = menu.findItem(R.id.action_search);
        searchView = (SearchView) item.getActionView();
        searchView.setQueryHint("Buscar...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override public boolean onQueryTextSubmit(String query) {
                if (!searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                querye = query;
                count = 0;
                vitrinePresenter.searchProducts(query,count);
                toolbar.setTitle(query);
                item.collapseActionView();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        vitrinePresenter.detachView();
    }

    @Override
    public void showResultsMore(List<Product> produtos) {
        rv_products.setVisibility(View.VISIBLE);
        vitrineAdapter.arrangeItems(produtos);
    }
}
