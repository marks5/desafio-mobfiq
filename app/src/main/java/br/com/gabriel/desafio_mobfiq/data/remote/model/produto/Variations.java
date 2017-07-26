
package br.com.gabriel.desafio_mobfiq.data.remote.model.produto;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Variations implements Parcelable
{

    @SerializedName("Cor")
    @Expose
    private List<String> cor = null;
    @SerializedName("Tamanho")
    @Expose
    private List<String> tamanho = null;
    public final static Parcelable.Creator<Variations> CREATOR = new Creator<Variations>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Variations createFromParcel(Parcel in) {
            Variations instance = new Variations();
            in.readList(instance.cor, (java.lang.String.class.getClassLoader()));
            in.readList(instance.tamanho, (java.lang.String.class.getClassLoader()));
            return instance;
        }

        public Variations[] newArray(int size) {
            return (new Variations[size]);
        }

    }
    ;

    public List<String> getCor() {
        return cor;
    }

    public void setCor(List<String> cor) {
        this.cor = cor;
    }

    public List<String> getTamanho() {
        return tamanho;
    }

    public void setTamanho(List<String> tamanho) {
        this.tamanho = tamanho;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(cor);
        dest.writeList(tamanho);
    }

    public int describeContents() {
        return  0;
    }

}
