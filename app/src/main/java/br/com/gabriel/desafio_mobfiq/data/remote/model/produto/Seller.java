
package br.com.gabriel.desafio_mobfiq.data.remote.model.produto;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Seller implements Parcelable
{

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Quantity")
    @Expose
    private Integer quantity;
    @SerializedName("Price")
    @Expose
    private Double price;
    @SerializedName("ListPrice")
    @Expose
    private Double listPrice;
    @SerializedName("BestInstallment")
    @Expose
    private BestInstallment bestInstallment;
    @SerializedName("Offer")
    @Expose
    private Object offer;
    public final static Parcelable.Creator<Seller> CREATOR = new Creator<Seller>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Seller createFromParcel(Parcel in) {
            Seller instance = new Seller();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.quantity = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.price = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.listPrice = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.bestInstallment = ((BestInstallment) in.readValue((BestInstallment.class.getClassLoader())));
            instance.offer = ((Object) in.readValue((Object.class.getClassLoader())));
            return instance;
        }

        public Seller[] newArray(int size) {
            return (new Seller[size]);
        }

    }
    ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public BestInstallment getBestInstallment() {
        return bestInstallment;
    }

    public void setBestInstallment(BestInstallment bestInstallment) {
        this.bestInstallment = bestInstallment;
    }

    public Object getOffer() {
        return offer;
    }

    public Double getDesconto(){
        return (((this.price * 100)/this.listPrice) - 100) * -1;
    }

    public void setOffer(Object offer) {
        this.offer = offer;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(quantity);
        dest.writeValue(price);
        dest.writeValue(listPrice);
        dest.writeValue(bestInstallment);
        dest.writeValue(offer);
    }

    public int describeContents() {
        return  0;
    }

}
