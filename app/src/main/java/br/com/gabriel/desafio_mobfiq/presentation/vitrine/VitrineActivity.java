package br.com.gabriel.desafio_mobfiq.presentation.vitrine;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import java.util.List;

import br.com.gabriel.desafio_mobfiq.R;
import br.com.gabriel.desafio_mobfiq.model.Product;

public class VitrineActivity extends AppCompatActivity implements VitrineContract.View {

    private Snackbar snackbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitrine);
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
    public void showFirstAccessMessage(String message) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
