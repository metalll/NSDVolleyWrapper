package application.nsd.nsdvolleywrapper.Wrapper;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;
import java.util.Map;

import application.nsd.nsdvolleywrapper.Wrapper.Interfaces.IAfterLoad;
import application.nsd.nsdvolleywrapper.Wrapper.NSDNetworkUtils.NSDParamsCoder;

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
    }}, new ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {}
    });

    addToQueue(stringRequest);
}

public static void sendGet(String url,boolean responceAsJSON,final IAfterLoad afterLoad){
    Request request;
    if(responceAsJSON)
        request = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if(afterLoad!=null) {
                    afterLoad.afterLoad(new Object[]{response});
                }
            }
        },
                new ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });



    else request = new StringRequest(url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            if (afterLoad != null) {
                afterLoad.afterLoad(new Object[]{response});
            }
        }
    }, new ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {}
    });


    addToQueue(request);

}

public static void sendGet(String url, Map<String,String> params, boolean responceAsJson,final IAfterLoad afterLoad){
    sendGet(url+ NSDParamsCoder.encode(params),responceAsJson,afterLoad);
}


private static synchronized void addToQueue(Request request){
        NSDQueue.getInstance().getQueue().add(request);
    }




}






