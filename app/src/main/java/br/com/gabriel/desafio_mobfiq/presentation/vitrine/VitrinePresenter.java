package br.com.gabriel.desafio_mobfiq.presentation.vitrine;

import java.util.List;

import br.com.gabriel.desafio_mobfiq.data.MobfiqRepository;
import br.com.gabriel.desafio_mobfiq.data.remote.model.produto.ProdutoRequest;
import br.com.gabriel.desafio_mobfiq.model.Product;
import br.com.gabriel.desafio_mobfiq.presentation.base.BasePresenter;
import rx.Scheduler;
import rx.Subscriber;

/**
 * Created by Gabriel on 26/07/2017.
 */

public class VitrinePresenter extends BasePresenter<VitrineContract.View> implements VitrineContract.Presenter {

    private final Scheduler mainScheduler, ioScheduler;
    private MobfiqRepository mobfiqRepository;
    private int count;

    public VitrinePresenter(Scheduler mainScheduler, Scheduler ioScheduler, MobfiqRepository mobfiqRepository) {
        this.mainScheduler = mainScheduler;
        this.ioScheduler = ioScheduler;
        this.mobfiqRepository = mobfiqRepository;
    }

    @Override
    public void searchProducts(String query) {
        count = count +10;
        checkViewAttached();
        getView().showLoading();

        addSubscription(mobfiqRepository.searchProdutos(new ProdutoRequest(query,0,count)).subscribeOn(mainScheduler).observeOn(ioScheduler).subscribe(new Subscriber<List<Product>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                getView().hideLoading();
                getView().showErrorSnack(e.getMessage());
            }

            @Override
            public void onNext(List<Product> products) {
                getView().hideLoading();
                getView().showResults(products);
            }
        }));
    }

    @Override
    public void showFirstAccessMessage(String message) {
        getView().showFirstAccessMessage(message);
    }
}
