package elib.controller.category;

import elib.controller.category.requests.CreateCategoryRequest;
import elib.entity.Category;
import elib.service.category.CategoryService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/category")
public class CategoryController {

  private final CategoryService categoryService;

  @Autowired
  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @RequestMapping(path = "/get/{categoryId}", method = RequestMethod.GET)
  public ResponseEntity getCategoryById(@PathVariable Long categoryId) {
    categoryService.find(categoryId);
    return ResponseEntity.ok("Get category by id " + categoryId);
  }

  @RequestMapping(path = "/get", method = RequestMethod.GET)
  public ResponseEntity getAllCategories() {
    categoryService.findAll();
    return ResponseEntity.ok("Get All categories");
  }

  @RequestMapping(path = "/create", method = RequestMethod.POST)
  public ResponseEntity createCategory(ModelAndView modelAndView, @ModelAttribute(name = "category") CreateCategoryRequest category,
                                       BindingResult bindingResult,
                                       HttpServletRequest request) {
    Category category1 = new Category();
    category1.setCategoryName(category.getCategoryName());
    category1.setDescription(category.getDescription());
    categoryService.create(category1);
    return ResponseEntity.ok("Category created");
  }

  @RequestMapping(path = "/update", method = RequestMethod.PUT)
  public ResponseEntity updateCategory(@RequestBody Category category) {
    categoryService.update(category);
    return ResponseEntity.ok("Category updated");
  }

  @RequestMapping(path = "/delete/{categoryId}", method = RequestMethod.DELETE)
  public ResponseEntity deleteCategory(@PathVariable(name = "categoryId") Long categoryId) {
    return ResponseEntity.ok("Book deleted Id " + categoryId);
  }
}
