package br.com.gabriel.desafio_mobfiq.data;

import java.io.IOException;
import java.util.List;

import br.com.gabriel.desafio_mobfiq.data.remote.MobfiqRestService;
import br.com.gabriel.desafio_mobfiq.model.Category;
import br.com.gabriel.desafio_mobfiq.model.Product;
import br.com.gabriel.desafio_mobfiq.data.remote.model.produto.ProdutoRequest;
import rx.Observable;

/**
 * Created by Gabriel on 26/07/2017.
 */

public class MobfiqRepositoryImp implements MobfiqRepository {

    private MobfiqRestService mobfiqRestService;

    public MobfiqRepositoryImp(MobfiqRestService fruitsRestService) {
        this.mobfiqRestService = fruitsRestService;
    }

    @Override
    public Observable<List<Product>> searchProdutos(ProdutoRequest pr) {
        return Observable.defer(() -> mobfiqRestService.buscaProduto(pr).concatMap(
                produtos -> Observable.from(produtos.getProducts()).toList()))
                .retryWhen(observable -> observable.flatMap(o -> {
                    if (o instanceof IOException) {
                        return Observable.just(null);
                    }
                    return Observable.error(o);
                }));
    }

    @Override
    public Observable<List<Category>> listCategorias() {
        return Observable.defer(() -> mobfiqRestService.listarCategorias().concatMap(
                categorias -> Observable.from(categorias.getCategories()).toList()))
                .retryWhen(observable -> observable.flatMap(o -> {
                    if(o instanceof IOException){
                        return Observable.just(null);
                    }
                    return Observable.error(o);
                }));
    }
}