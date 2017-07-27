package br.com.gabriel.desafio_mobfiq.presentation.vitrine;

import java.util.List;

import br.com.gabriel.desafio_mobfiq.model.Product;
import br.com.gabriel.desafio_mobfiq.presentation.base.MvpPresenter;
import br.com.gabriel.desafio_mobfiq.presentation.base.MvpView;

/**
 * Created by Gabriel on 26/07/2017.
 */

public interface VitrineContract {
    interface View extends MvpView {

        void showResults(List<Product> produtos);

        void showErrorSnack(String message);

        void showLoading();

        void hideLoading();

        void showFirstAccessMessage(String message);
    }

    interface Presenter extends MvpPresenter<View> {
        void searchProducts(String query);

        void showFirstAccessMessage(String message);
    }
}
