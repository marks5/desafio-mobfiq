
package br.com.gabriel.desafio_mobfiq.data.remote.model.produto;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image implements Parcelable
{

    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("ImageTag")
    @Expose
    private String imageTag;
    @SerializedName("Label")
    @Expose
    private Object label;
    public final static Parcelable.Creator<Image> CREATOR = new Creator<Image>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Image createFromParcel(Parcel in) {
            Image instance = new Image();
            instance.imageUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.imageTag = ((String) in.readValue((String.class.getClassLoader())));
            instance.label = ((Object) in.readValue((Object.class.getClassLoader())));
            return instance;
        }

        public Image[] newArray(int size) {
            return (new Image[size]);
        }

    };

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageTag() {
        return imageTag;
    }

    public void setImageTag(String imageTag) {
        this.imageTag = imageTag;
    }

    public Object getLabel() {
        return label;
    }

    public void setLabel(Object label) {
        this.label = label;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(imageUrl);
        dest.writeValue(imageTag);
        dest.writeValue(label);
    }

    public int describeContents() {
        return 0;
    }

}