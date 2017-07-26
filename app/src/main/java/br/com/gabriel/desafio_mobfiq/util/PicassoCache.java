package br.com.gabriel.desafio_mobfiq.util;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.Picasso;

/**
 * Created by Gabriel on 26/07/2017.
 */

public class PicassoCache {
    private static Picasso picassoInstance = null;

    private PicassoCache(Context context) {
        Downloader downloader = new OkHttp3Downloader(context, Integer.MAX_VALUE);
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(downloader);
        picassoInstance = builder.build();
    }

    public static Picasso getPicassoInstance(Context context) {
        if (picassoInstance == null) {
            new PicassoCache(context);
            return picassoInstance;
        }
        return picassoInstance;
    }
}
