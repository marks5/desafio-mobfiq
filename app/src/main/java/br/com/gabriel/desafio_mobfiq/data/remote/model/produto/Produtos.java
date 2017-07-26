
package br.com.gabriel.desafio_mobfiq.data.remote.model.produto;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Produtos implements Parcelable
{

    @SerializedName("Size")
    @Expose
    private Integer size;
    @SerializedName("Offset")
    @Expose
    private Integer offset;
    @SerializedName("Total")
    @Expose
    private Integer total;
    @SerializedName("Delay")
    @Expose
    private Double delay;
    @SerializedName("Products")
    @Expose
    private List<Product> products = null;
    @SerializedName("ApiQuery")
    @Expose
    private String apiQuery;
    public final static Parcelable.Creator<Produtos> CREATOR = new Creator<Produtos>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Produtos createFromParcel(Parcel in) {
            Produtos instance = new Produtos();
            instance.size = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.offset = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.delay = ((Double) in.readValue((Double.class.getClassLoader())));
            in.readList(instance.products, (br.com.gabriel.desafio_mobfiq.data.remote.model.Product.class.getClassLoader()));
            instance.apiQuery = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Produtos[] newArray(int size) {
            return (new Produtos[size]);
        }

    }
    ;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Double getDelay() {
        return delay;
    }

    public void setDelay(Double delay) {
        this.delay = delay;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getApiQuery() {
        return apiQuery;
    }

    public void setApiQuery(String apiQuery) {
        this.apiQuery = apiQuery;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(size);
        dest.writeValue(offset);
        dest.writeValue(total);
        dest.writeValue(delay);
        dest.writeList(products);
        dest.writeValue(apiQuery);
    }

    public int describeContents() {
        return  0;
    }

}
