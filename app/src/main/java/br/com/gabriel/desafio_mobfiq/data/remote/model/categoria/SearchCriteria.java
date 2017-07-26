
package br.com.gabriel.desafio_mobfiq.data.remote.model.categoria;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchCriteria implements Parcelable
{

    @SerializedName("Query")
    @Expose
    private Object query;
    @SerializedName("OrderBy")
    @Expose
    private Integer orderBy;
    @SerializedName("Size")
    @Expose
    private Object size;
    @SerializedName("Offset")
    @Expose
    private Object offset;
    @SerializedName("Filter")
    @Expose
    private Object filter;
    @SerializedName("ApiQuery")
    @Expose
    private String apiQuery;
    @SerializedName("ProductId")
    @Expose
    private Object productId;
    @SerializedName("Hotsite")
    @Expose
    private Object hotsite;
    @SerializedName("RealProductId")
    @Expose
    private Object realProductId;
    @SerializedName("EAN")
    @Expose
    private Object eAN;
    @SerializedName("RealProductIdGroup")
    @Expose
    private Object realProductIdGroup;
    @SerializedName("FacetItems")
    @Expose
    private Object facetItems;
    @SerializedName("SearchApi")
    @Expose
    private Object searchApi;
    public final static Parcelable.Creator<SearchCriteria> CREATOR = new Creator<SearchCriteria>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SearchCriteria createFromParcel(Parcel in) {
            SearchCriteria instance = new SearchCriteria();
            instance.query = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.orderBy = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.size = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.offset = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.filter = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.apiQuery = ((String) in.readValue((String.class.getClassLoader())));
            instance.productId = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.hotsite = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.realProductId = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.eAN = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.realProductIdGroup = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.facetItems = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.searchApi = ((Object) in.readValue((Object.class.getClassLoader())));
            return instance;
        }

        public SearchCriteria[] newArray(int size) {
            return (new SearchCriteria[size]);
        }

    }
    ;

    public Object getQuery() {
        return query;
    }

    public void setQuery(Object query) {
        this.query = query;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public Object getSize() {
        return size;
    }

    public void setSize(Object size) {
        this.size = size;
    }

    public Object getOffset() {
        return offset;
    }

    public void setOffset(Object offset) {
        this.offset = offset;
    }

    public Object getFilter() {
        return filter;
    }

    public void setFilter(Object filter) {
        this.filter = filter;
    }

    public String getApiQuery() {
        return apiQuery;
    }

    public void setApiQuery(String apiQuery) {
        this.apiQuery = apiQuery;
    }

    public Object getProductId() {
        return productId;
    }

    public void setProductId(Object productId) {
        this.productId = productId;
    }

    public Object getHotsite() {
        return hotsite;
    }

    public void setHotsite(Object hotsite) {
        this.hotsite = hotsite;
    }

    public Object getRealProductId() {
        return realProductId;
    }

    public void setRealProductId(Object realProductId) {
        this.realProductId = realProductId;
    }

    public Object getEAN() {
        return eAN;
    }

    public void setEAN(Object eAN) {
        this.eAN = eAN;
    }

    public Object getRealProductIdGroup() {
        return realProductIdGroup;
    }

    public void setRealProductIdGroup(Object realProductIdGroup) {
        this.realProductIdGroup = realProductIdGroup;
    }

    public Object getFacetItems() {
        return facetItems;
    }

    public void setFacetItems(Object facetItems) {
        this.facetItems = facetItems;
    }

    public Object getSearchApi() {
        return searchApi;
    }

    public void setSearchApi(Object searchApi) {
        this.searchApi = searchApi;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(query);
        dest.writeValue(orderBy);
        dest.writeValue(size);
        dest.writeValue(offset);
        dest.writeValue(filter);
        dest.writeValue(apiQuery);
        dest.writeValue(productId);
        dest.writeValue(hotsite);
        dest.writeValue(realProductId);
        dest.writeValue(eAN);
        dest.writeValue(realProductIdGroup);
        dest.writeValue(facetItems);
        dest.writeValue(searchApi);
    }

    public int describeContents() {
        return  0;
    }

}
