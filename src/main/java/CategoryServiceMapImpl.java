import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class CategoryServiceMapImpl implements ICategoryService{

    // Devuelve categories según ID y los ordena
    @Override
    public Category[] getCategories(String id) {
        String url = "https://api.mercadolibre.com/sites/"+id+"/categories";
        Category[] categories= new Gson().fromJson(getJSON.get(url),Category[].class);
        Arrays.sort(categories);
        return categories;
    }

    @Override
    public boolean existCategory(String id, String idCategory) {
        String url = "https://api.mercadolibre.com/sites/"+id+"/categories";

        Category[] categories = new Gson().fromJson(getJSON.get(url), Category[].class);


        for(int i=0; i < categories.length; i++) {
            if((categories[i].getId()).equals(idCategory)) {
                return true;
            }
        }

        return false;
    }
}
