package application.nsd.nsdvolleywrapper.Wrapper;


import android.app.Activity;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by NSD on 9/14/16.
 */
public class NSDQueue {

    private static NSDQueue instance = null;


    private RequestQueue queue = null;
    private static Activity context = null;

    private NSDQueue(){

    }

    public static NSDQueue getInstance(){
        if(instance==null)
        instance = new NSDQueue();
        return instance;
    }

    public static void InitWithActivity(Activity activity){
        if(context!=null){
        Log.w("NSDLogger","You are initialize NSDQueue! Activity will not changed! If you want change activity see DeleteActivity");
        return;
        }
        context = activity;
    }

    public void DeleteActivity(){
        context = null;
    }

    public RequestQueue getQueue(){
        if(queue==null){
            queue = Volley.newRequestQueue(context.getBaseContext());
        }
        return queue;
    }




}
