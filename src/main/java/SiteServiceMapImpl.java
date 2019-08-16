import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



public class SiteServiceMapImpl implements ISiteService {

    private Map<String, Site> siteMap;

    public SiteServiceMapImpl(){
        siteMap = new HashMap<String, Site>();

        Site[] sites= new Gson().fromJson(getJSON.get("https://api.mercadolibre.com/sites"),Site[].class);

        for (int i=1 ; i <= (sites.length) ; i++){
            siteMap.put(Integer.toString(i), sites[i-1]);
        }
    }

    // Ordena y devuelve los Sites.
    public Site[] getSites() {
        Site[] sites = (siteMap.values()).toArray(new Site[(siteMap.values()).size()]);
        Arrays.sort(sites);
        return sites;
    }



}
