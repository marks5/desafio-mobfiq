
package br.com.gabriel.desafio_mobfiq.data.remote.model.categoria;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Redirect implements Parcelable
{

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("SearchCriteria")
    @Expose
    private SearchCriteria searchCriteria;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Type")
    @Expose
    private Integer type;
    public final static Parcelable.Creator<Redirect> CREATOR = new Creator<Redirect>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Redirect createFromParcel(Parcel in) {
            Redirect instance = new Redirect();
            instance.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.searchCriteria = ((SearchCriteria) in.readValue((SearchCriteria.class.getClassLoader())));
            instance.title = ((String) in.readValue((String.class.getClassLoader())));
            instance.type = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Redirect[] newArray(int size) {
            return (new Redirect[size]);
        }

    }
    ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SearchCriteria getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(searchCriteria);
        dest.writeValue(title);
        dest.writeValue(type);
    }

    public int describeContents() {
        return  0;
    }

}
