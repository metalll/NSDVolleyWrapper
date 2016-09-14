package application.nsd.nsdvolleywrapper.Wrapper;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.io.IOException;

import application.nsd.nsdvolleywrapper.Wrapper.Interfaces.IAfterLoad;

/**
 * Created by NSD on 9/14/16.
 */
public class NSDVolleyWrapper {

public static void sendGet(String url,final IAfterLoad afterLoad) {

    StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {

           if(afterLoad!=null){ afterLoad.afterLoad(new Object[]{response});

        }


    }}, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    });

    addToQueue(stringRequest);


}

private static synchronized void addToQueue(Request request){
        NSDQueue.getInstance().getQueue().add(request);
    }




}






