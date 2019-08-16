package service;

import clase.Category;

public interface ICategoryService {

    public Category[] getCategories(String id);
    public boolean existCategory (String id, String idCategory);

}
