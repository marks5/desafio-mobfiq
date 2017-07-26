
package br.com.gabriel.desafio_mobfiq.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import br.com.gabriel.desafio_mobfiq.data.remote.model.categoria.Redirect;
import br.com.gabriel.desafio_mobfiq.data.remote.model.categoria.SubCategory;

public class Category implements Parcelable
{

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Image")
    @Expose
    private Object image;
    @SerializedName("Redirect")
    @Expose
    private Redirect redirect;
    @SerializedName("SubCategories")
    @Expose
    private List<SubCategory> subCategories = null;
    @SerializedName("Highlight")
    @Expose
    private Boolean highlight;
    @SerializedName("Icon")
    @Expose
    private String icon;
    @SerializedName("CategoryListOrder")
    @Expose
    private Integer categoryListOrder;
    @SerializedName("CategoryTreeOrder")
    @Expose
    private Integer categoryTreeOrder;
    @SerializedName("LinkId")
    @Expose
    private Integer linkId;
    public final static Parcelable.Creator<Category> CREATOR = new Creator<Category>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Category createFromParcel(Parcel in) {
            Category instance = new Category();
            instance.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.image = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.redirect = ((Redirect) in.readValue((Redirect.class.getClassLoader())));
            in.readList(instance.subCategories, (SubCategory.class.getClassLoader()));
            instance.highlight = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.icon = ((String) in.readValue((String.class.getClassLoader())));
            instance.categoryListOrder = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.categoryTreeOrder = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.linkId = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Category[] newArray(int size) {
            return (new Category[size]);
        }

    }
    ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public Redirect getRedirect() {
        return redirect;
    }

    public void setRedirect(Redirect redirect) {
        this.redirect = redirect;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    public Boolean getHighlight() {
        return highlight;
    }

    public void setHighlight(Boolean highlight) {
        this.highlight = highlight;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getCategoryListOrder() {
        return categoryListOrder;
    }

    public void setCategoryListOrder(Integer categoryListOrder) {
        this.categoryListOrder = categoryListOrder;
    }

    public Integer getCategoryTreeOrder() {
        return categoryTreeOrder;
    }

    public void setCategoryTreeOrder(Integer categoryTreeOrder) {
        this.categoryTreeOrder = categoryTreeOrder;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(image);
        dest.writeValue(redirect);
        dest.writeList(subCategories);
        dest.writeValue(highlight);
        dest.writeValue(icon);
        dest.writeValue(categoryListOrder);
        dest.writeValue(categoryTreeOrder);
        dest.writeValue(linkId);
    }

    public int describeContents() {
        return  0;
    }

}
