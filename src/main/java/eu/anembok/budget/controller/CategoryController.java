package eu.anembok.budget.controller;

import eu.anembok.budget.dto.CategoryCreateRequest;
import eu.anembok.budget.entity.Category;
import eu.anembok.budget.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin("http://localhost:8080")
@RestController
@AllArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryService.getAllSort();
    }

    @PostMapping()
    void save(@RequestBody CategoryCreateRequest request){
        Category category = new Category();
        category.setName(request.name());
        categoryService.save(category);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id){

        System.out.print("Delete category with id: " + id);
        categoryService.delete(id);
    }
}
