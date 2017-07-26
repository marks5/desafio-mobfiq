
package br.com.gabriel.desafio_mobfiq.data.remote.model.produto;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReferenceId implements Parcelable
{

    @SerializedName("Key")
    @Expose
    private String key;
    @SerializedName("Value")
    @Expose
    private String value;
    public final static Parcelable.Creator<ReferenceId> CREATOR = new Creator<ReferenceId>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ReferenceId createFromParcel(Parcel in) {
            ReferenceId instance = new ReferenceId();
            instance.key = ((String) in.readValue((String.class.getClassLoader())));
            instance.value = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public ReferenceId[] newArray(int size) {
            return (new ReferenceId[size]);
        }

    }
    ;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(key);
        dest.writeValue(value);
    }

    public int describeContents() {
        return  0;
    }

}
