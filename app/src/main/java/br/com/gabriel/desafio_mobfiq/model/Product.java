
package br.com.gabriel.desafio_mobfiq.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import br.com.gabriel.desafio_mobfiq.data.remote.model.produto.Image;
import br.com.gabriel.desafio_mobfiq.data.remote.model.produto.Sku;
import br.com.gabriel.desafio_mobfiq.data.remote.model.produto.Specifications;

public class Product implements Parcelable
{

    @SerializedName("Availability")
    @Expose
    private Boolean availability;
    @SerializedName("Skus")
    @Expose
    private List<Sku> skus = null;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Brand")
    @Expose
    private String brand;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("Category")
    @Expose
    private String category;
    @SerializedName("Categories")
    @Expose
    private List<String> categories = null;
    @SerializedName("Specifications")
    @Expose
    private Specifications specifications;
    @SerializedName("Variations")
    @Expose
    private List<String> variations = null;
    @SerializedName("Videos")
    @Expose
    private List<String> videos = null;

    @SerializedName("Images")
    @Expose
    private List<Image> images = null;

    @SerializedName("RealId")
    @Expose
    private String realId;
    public final static Parcelable.Creator<Product> CREATOR = new Creator<Product>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Product createFromParcel(Parcel in) {
            Product instance = new Product();
            instance.availability = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            in.readList(instance.skus, (Sku.class.getClassLoader()));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.brand = ((String) in.readValue((String.class.getClassLoader())));
            instance.description = ((String) in.readValue((String.class.getClassLoader())));
            instance.category = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.categories, (java.lang.String.class.getClassLoader()));
            instance.specifications = ((Specifications) in.readValue((Specifications.class.getClassLoader())));
            in.readList(instance.variations, (java.lang.String.class.getClassLoader()));
            in.readList(instance.videos, (java.lang.String.class.getClassLoader()));
            in.readList(instance.images, (Image.class.getClassLoader()));
            instance.realId = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Product[] newArray(int size) {
            return (new Product[size]);
        }

    }
    ;

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Specifications getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Specifications specifications) {
        this.specifications = specifications;
    }

    public List<String> getVariations() {
        return variations;
    }

    public void setVariations(List<String> variations) {
        this.variations = variations;
    }

    public List<String> getVideos() {
        return videos;
    }

    public void setVideos(List<String> videos) {
        this.videos = videos;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getRealId() {
        return realId;
    }

    public void setRealId(String realId) {
        this.realId = realId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(availability);
        dest.writeList(skus);
        dest.writeValue(name);
        dest.writeValue(id);
        dest.writeValue(brand);
        dest.writeValue(description);
        dest.writeValue(category);
        dest.writeList(categories);
        dest.writeValue(specifications);
        dest.writeList(variations);
        dest.writeList(videos);
        dest.writeValue(images);
        dest.writeValue(realId);
    }

    public int describeContents() {
        return  0;
    }

}
