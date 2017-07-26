package br.com.gabriel.desafio_mobfiq.data;

import java.util.List;

import br.com.gabriel.desafio_mobfiq.model.Category;
import br.com.gabriel.desafio_mobfiq.model.Product;
import br.com.gabriel.desafio_mobfiq.data.remote.model.produto.ProdutoRequest;
import rx.Observable;

/**
 * Created by Gabriel on 26/07/2017.
 */

public interface MobfiqRepository {
    Observable<List<Product>> searchProdutos(ProdutoRequest pr);
    Observable<List<Category>> listCategorias();
}
