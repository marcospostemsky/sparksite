import java.io.BufferedReader;
import java.util.Collection;

public interface ICategoryService {

    public Category[] getCategories(String id);
    public boolean existCategory (String id, String idCategory);

}
