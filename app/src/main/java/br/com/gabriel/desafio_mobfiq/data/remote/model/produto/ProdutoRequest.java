package br.com.gabriel.desafio_mobfiq.data.remote.model.produto;

/**
 * Created by Gabriel on 26/07/2017.
 */

public class ProdutoRequest {

    private String Query;
    private int Offset;
    private int Size;

    public ProdutoRequest(String query, int offset, int size) {
        Query = query;
        Offset = offset;
        Size = size;
    }

    public String getQuery() {
        return Query;
    }

    public void setQuery(String query) {
        Query = query;
    }

    public int getOffset() {
        return Offset;
    }

    public void setOffset(int offset) {
        Offset = offset;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }
}
