
package br.com.gabriel.desafio_mobfiq.data.remote.model.produto;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sku implements Parcelable
{

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Order")
    @Expose
    private Integer order;
    @SerializedName("Sellers")
    @Expose
    private List<Seller> sellers = null;
    @SerializedName("Images")
    @Expose
    private List<Image> images = null;
    @SerializedName("Variations")
    @Expose
    private Variations variations;
    @SerializedName("SkuName")
    @Expose
    private String skuName;
    @SerializedName("UnitMultiplier")
    @Expose
    private Integer unitMultiplier;
    @SerializedName("ComplementName")
    @Expose
    private String complementName;
    @SerializedName("MeasurementUnit")
    @Expose
    private String measurementUnit;
    @SerializedName("ReferenceId")
    @Expose
    private List<ReferenceId> referenceId = null;
    @SerializedName("EAN")
    @Expose
    private String eAN;
    public final static Parcelable.Creator<Sku> CREATOR = new Creator<Sku>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Sku createFromParcel(Parcel in) {
            Sku instance = new Sku();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.order = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(instance.sellers, (Seller.class.getClassLoader()));
            in.readList(instance.images, (Image.class.getClassLoader()));
            instance.variations = ((Variations) in.readValue((Variations.class.getClassLoader())));
            instance.skuName = ((String) in.readValue((String.class.getClassLoader())));
            instance.unitMultiplier = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.complementName = ((String) in.readValue((String.class.getClassLoader())));
            instance.measurementUnit = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.referenceId, (ReferenceId.class.getClassLoader()));
            instance.eAN = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Sku[] newArray(int size) {
            return (new Sku[size]);
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

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Variations getVariations() {
        return variations;
    }

    public void setVariations(Variations variations) {
        this.variations = variations;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Integer getUnitMultiplier() {
        return unitMultiplier;
    }

    public void setUnitMultiplier(Integer unitMultiplier) {
        this.unitMultiplier = unitMultiplier;
    }

    public String getComplementName() {
        return complementName;
    }

    public void setComplementName(String complementName) {
        this.complementName = complementName;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public List<ReferenceId> getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(List<ReferenceId> referenceId) {
        this.referenceId = referenceId;
    }

    public String getEAN() {
        return eAN;
    }

    public void setEAN(String eAN) {
        this.eAN = eAN;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(order);
        dest.writeList(sellers);
        dest.writeList(images);
        dest.writeValue(variations);
        dest.writeValue(skuName);
        dest.writeValue(unitMultiplier);
        dest.writeValue(complementName);
        dest.writeValue(measurementUnit);
        dest.writeList(referenceId);
        dest.writeValue(eAN);
    }

    public int describeContents() {
        return  0;
    }

}
