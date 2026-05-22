package eu.anembok.budget.service;

import eu.anembok.budget.entity.Category;
import eu.anembok.budget.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    private Sort sortByIdAsc(){
        return Sort.by(Sort.Direction.ASC, "id");
    }

    public void save(Category category){
        categoryRepository.save(category);
    }

    public void delete(int id){
        Category category = getById(id);
        categoryRepository.delete(category);
    }

    public List<Category> getAllSort(){
        return categoryRepository.findAll(sortByIdAsc());
    }


    public Category getById(int id){
        return categoryRepository.getReferenceById(id);
    }
}
