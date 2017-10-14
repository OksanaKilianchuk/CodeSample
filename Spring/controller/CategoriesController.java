package content.com.ua.controller.blog;

import content.com.ua.entities.blog.Category;
import content.com.ua.service.iservice.blog.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/blog/categories")
public class CategoriesController {

    private CategoryService categoryService;

    @Autowired
    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getCategoriesByDomain(@RequestParam("d") String domain) {
        return categoryService.findAllByDomain(domain);
    }

    @RequestMapping(value = "/{url}", method = RequestMethod.GET)
    public Category getCategory(@PathVariable("url") String url, @RequestParam("d") String domain) {
        return categoryService.findByUrlAndDomain(url, domain);
    }
}
