package br.com.gabriel.desafio_mobfiq.presentation.vitrine;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;

import java.util.List;

import br.com.gabriel.desafio_mobfiq.R;
import br.com.gabriel.desafio_mobfiq.injection.Injection;
import br.com.gabriel.desafio_mobfiq.model.Product;
import br.com.gabriel.desafio_mobfiq.presentation.categorias.CategoriasActivity;
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
    private DrawerLayout drawer_layout;
    private NavigationView left_drawer;
    private ImageView btn_drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitrine);
        vitrinePresenter = new VitrinePresenter(Schedulers.io(), AndroidSchedulers.mainThread(),Injection.provideMobfiq());
        vitrinePresenter.attachView(this);

        FirebaseApp.getInstance();

        rv_products = (RecyclerView) findViewById(R.id.rv_products);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        progressBarMore = (ProgressBar) findViewById(R.id.progressbar_more);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        left_drawer = (NavigationView) findViewById(R.id.left_drawer);
        btn_drawer = (ImageView) findViewById(R.id.icon_dehaze);

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

        btn_drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer_layout.openDrawer(left_drawer);
            }
        });

        left_drawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                item.setChecked(true);
                switch (id){
                    case R.id.menu_inicio:
                        //aqui não faz nada msm
                        drawer_layout.closeDrawers();
                        break;
                    case R.id.menu_categorias:
                        startActivity(new Intent(VitrineActivity.this, CategoriasActivity.class));
                        drawer_layout.closeDrawers();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

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
