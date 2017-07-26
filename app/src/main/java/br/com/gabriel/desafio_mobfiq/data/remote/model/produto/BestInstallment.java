
package br.com.gabriel.desafio_mobfiq.data.remote.model.produto;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BestInstallment implements Parcelable
{

    @SerializedName("Count")
    @Expose
    private Integer count;
    @SerializedName("Value")
    @Expose
    private Double value;
    @SerializedName("Total")
    @Expose
    private Double total;
    @SerializedName("Rate")
    @Expose
    private Integer rate;
    public final static Parcelable.Creator<BestInstallment> CREATOR = new Creator<BestInstallment>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BestInstallment createFromParcel(Parcel in) {
            BestInstallment instance = new BestInstallment();
            instance.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.value = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.total = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.rate = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public BestInstallment[] newArray(int size) {
            return (new BestInstallment[size]);
        }

    }
    ;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeValue(value);
        dest.writeValue(total);
        dest.writeValue(rate);
    }

    public int describeContents() {
        return  0;
    }

}
