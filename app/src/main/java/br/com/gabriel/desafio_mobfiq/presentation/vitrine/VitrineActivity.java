package br.com.gabriel.desafio_mobfiq.presentation.vitrine;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import br.com.gabriel.desafio_mobfiq.R;
import br.com.gabriel.desafio_mobfiq.injection.Injection;
import br.com.gabriel.desafio_mobfiq.model.Product;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class VitrineActivity extends AppCompatActivity implements VitrineContract.View {

    private Snackbar snackbar;
    private VitrinePresenter vitrinePresenter;
    private RecyclerView rv_products;
    private VitrineAdapter vitrineAdapter;
    private ProgressBar progressBar, progressBarMore;
    private TextView tv_oi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitrine);
        vitrinePresenter = new VitrinePresenter(Schedulers.io(), AndroidSchedulers.mainThread(),Injection.provideMobfiq());
        vitrinePresenter.attachView(this);

        rv_products = (RecyclerView) findViewById(R.id.rv_products);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        progressBarMore = (ProgressBar) findViewById(R.id.progressbar_more);
        tv_oi = (TextView) findViewById(R.id.tv_oi);

        vitrineAdapter = new VitrineAdapter(null);
        GridLayoutManager glm = new GridLayoutManager(this, 2);
        rv_products.setLayoutManager(glm);
        rv_products.setAdapter(vitrineAdapter);

        snackbar = Snackbar.make(findViewById(R.id.mConstraintLayout), R.string.err_,Snackbar.LENGTH_SHORT);
    }

    @Override
    public void showResults(List<Product> produtos) {

    }

    @Override
    public void showErrorSnack(String message) {
        snackbar.setAction(message, view -> {
            //try again search
        });

        snackbar.show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoadingMore() {

    }

    @Override
    public void hideLoadingMore() {

    }

    @Override
    public void showFirstAccessMessage(String message) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
