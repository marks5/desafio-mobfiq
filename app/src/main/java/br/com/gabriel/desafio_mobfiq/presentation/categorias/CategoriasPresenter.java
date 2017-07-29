package br.com.gabriel.desafio_mobfiq.presentation.categorias;

import java.util.List;

import br.com.gabriel.desafio_mobfiq.data.MobfiqRepository;
import br.com.gabriel.desafio_mobfiq.data.remote.model.produto.ProdutoRequest;
import br.com.gabriel.desafio_mobfiq.model.Category;
import br.com.gabriel.desafio_mobfiq.model.Product;
import br.com.gabriel.desafio_mobfiq.presentation.base.BasePresenter;
import br.com.gabriel.desafio_mobfiq.presentation.vitrine.VitrineContract;
import rx.Scheduler;
import rx.Subscriber;

/**
 * Created by Gabriel on 26/07/2017.
 */

public class CategoriasPresenter extends BasePresenter<CategoriasContract.View> implements CategoriasContract.Presenter {

    private final Scheduler mainScheduler, ioScheduler;
    private MobfiqRepository mobfiqRepository;

    public CategoriasPresenter(Scheduler mainScheduler, Scheduler ioScheduler, MobfiqRepository mobfiqRepository) {
        this.mainScheduler = mainScheduler;
        this.ioScheduler = ioScheduler;
        this.mobfiqRepository = mobfiqRepository;
    }

    @Override
    public void listCategorias() {
        checkViewAttached();
        getView().showLoading();

        addSubscription(mobfiqRepository.listCategorias().subscribeOn(mainScheduler).observeOn(ioScheduler).subscribe(new Subscriber<List<Category>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                getView().hideLoading();
                getView().showErrorSnack(e.getMessage());
            }

            @Override
            public void onNext(List<Category> categories) {
                getView().hideLoading();
                getView().showResults(categories);
            }
        }));
    }
}
