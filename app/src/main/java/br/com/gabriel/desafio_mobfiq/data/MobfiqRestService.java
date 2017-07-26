package br.com.gabriel.desafio_mobfiq.data;

import br.com.gabriel.desafio_mobfiq.data.remote.model.categoria.Categorias;
import br.com.gabriel.desafio_mobfiq.data.remote.model.produto.ProdutoRequest;
import br.com.gabriel.desafio_mobfiq.data.remote.model.produto.Produtos;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Gabriel on 26/07/2017.
 */

public interface MobfiqRestService {
    @POST("Search/Criteria")
    Call<Produtos> buscaProduto(@Body ProdutoRequest body);

    @GET("StorePreference/CategoryTree")
    Call<Categorias> listarCategorias();
}
