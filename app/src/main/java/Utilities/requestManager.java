package Utilities;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class requestManager {
    private  static requestManager rInstance;
    private RequestQueue mRequestQueue;
    private static Context mContext;

    private requestManager(Context context){
        mContext = context;
        mRequestQueue = getRequestQueue();
    }

    public static  synchronized requestManager getInstance(Context context){
        if (rInstance == null){
            rInstance = new requestManager(context);
        }
        return rInstance;
    }

    public RequestQueue getRequestQueue(){
        if (mRequestQueue == null){
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req){
        getRequestQueue().add(req);
    }

}
