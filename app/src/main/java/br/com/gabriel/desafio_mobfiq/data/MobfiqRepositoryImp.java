package br.com.gabriel.desafio_mobfiq.data;

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
        return null;
    }

    @Override
    public Observable<List<Category>> listCategorias() {
        return null;
    }
}