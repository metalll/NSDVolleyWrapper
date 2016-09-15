package application.nsd.nsdvolleywrapper.Wrapper.NSDNetworkUtils;

import java.util.Dictionary;
import java.util.Map;

/**
 * Created by NSD on 9/15/16.
 */
public class NSDParamsCoder {

    public static String encode(Map<String,String> dictionary){
        String retVal = "?";
        boolean isFirstIteration = true;
        for(Map.Entry<String,String> entry:dictionary.entrySet()){
            String tempKey = entry.getKey();
            String tempValue = entry.getValue();

            if(isFirstIteration){isFirstIteration = false;}
            else { retVal+="&"; }
            retVal += tempKey.concat("="+tempValue);
        }

        return retVal;
}


}
