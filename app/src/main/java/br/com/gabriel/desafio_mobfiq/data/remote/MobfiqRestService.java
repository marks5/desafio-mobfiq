package br.com.gabriel.desafio_mobfiq.data.remote;

import br.com.gabriel.desafio_mobfiq.data.remote.model.categoria.Categorias;
import br.com.gabriel.desafio_mobfiq.data.remote.model.produto.ProdutoRequest;
import br.com.gabriel.desafio_mobfiq.data.remote.model.produto.Produtos;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Gabriel on 26/07/2017.
 */

public interface MobfiqRestService {
    @POST("Search/Criteria")
    Observable<Produtos> buscaProduto(@Body ProdutoRequest body);

    @GET("StorePreference/CategoryTree")
    Observable<Categorias> listarCategorias();
}
