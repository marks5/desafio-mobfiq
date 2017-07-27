package br.com.gabriel.desafio_mobfiq.presentation.base;

/**
 * Created by Gabriel on 26/07/2017.
 */

public interface MvpPresenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}