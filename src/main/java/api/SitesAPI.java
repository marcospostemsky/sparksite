package api;

import clase.Category;
import clase.Site;
import com.google.gson.Gson;
import service.ICategoryService;
import service.ISiteService;
import serviceImpl.CategoryServiceMapImpl;
import serviceImpl.SiteServiceMapImpl;

import static spark.Spark.*;

public class SitesAPI {

    public static void main(String[] args) {
        port(8084);
        ISiteService siteService = new SiteServiceMapImpl();
        ICategoryService categoryService = new CategoryServiceMapImpl();

        get("/sites", (req , res) -> {
            res.type("application/json");
            res.status(200);
            Site[] sites = siteService.getSites();
            return new Gson().toJson(new Gson().toJsonTree(sites));
        });

        get("/sites/:id/categories", (req , res) -> {
            res.type("application/json");
            res.status(200);
            Category[] categories = categoryService.getCategories(req.params(":id"));
            return new Gson().toJson(new Gson().toJsonTree(categories));
        });

        get("/sites/:id/categories/:idCat", (req , res) -> {
            res.type("application/json");
            if (categoryService.existCategory(req.params(":id"), req.params(":idCat"))) {
                System.out.println("funco");
                res.status(200);
                return "{ \"StatusCode\": \"OK\"}";
            }
                res.status(404);
            return null;
        });

    }
}
