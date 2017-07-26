
package br.com.gabriel.desafio_mobfiq.data.remote.model.categoria;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Categorias implements Parcelable
{
    @SerializedName("Categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("Id")
    @Expose
    private Integer id;
    public final static Parcelable.Creator<Categorias> CREATOR = new Creator<Categorias>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Categorias createFromParcel(Parcel in) {
            Categorias instance = new Categorias();
            in.readList(instance.categories, (Category.class.getClassLoader()));
            instance.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Categorias[] newArray(int size) {
            return (new Categorias[size]);
        }

    }
    ;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(categories);
        dest.writeValue(id);
    }

    public int describeContents() {
        return  0;
    }

}
