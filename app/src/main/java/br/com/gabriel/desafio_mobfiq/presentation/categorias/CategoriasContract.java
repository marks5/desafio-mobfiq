package br.com.gabriel.desafio_mobfiq.presentation.categorias;

import java.util.List;

import br.com.gabriel.desafio_mobfiq.model.Category;
import br.com.gabriel.desafio_mobfiq.presentation.base.MvpPresenter;
import br.com.gabriel.desafio_mobfiq.presentation.base.MvpView;

/**
 * Created by Gabriel on 26/07/2017.
 */

public interface CategoriasContract {

    interface View extends MvpView {

        void showResults(List<Category> categories);

        void showLoading();

        void hideLoading();

        void showErrorSnack(String mensagem);

    }

    interface Presenter extends MvpPresenter<CategoriasContract.View> {
        void listCategorias();
    }

}
