package br.com.gabriel.desafio_mobfiq.util;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;


/**
 * Created by Gabriel on 28/07/2017.
 */

public class PushwooshFCM extends FirebaseInstanceIdService {

    private static String TAG = "TOKEN";

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
    }
}
