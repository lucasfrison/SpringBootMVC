package com.teste.exemplo.view.controller;

//#region imports
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.teste.exemplo.model.Product;
import com.teste.exemplo.services.ProductService;
//#endregion

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> getAll() {
		return productService.getAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Product> getById(@PathVariable Integer id) {
		return productService.getById(id);
	}
	
	@PostMapping
	public Product add(@RequestBody Product product) {
		return productService.add(product);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		productService.delete(id);
		return "Produto com id: " + id + " deletado com sucesso!";
	}
	
	@PutMapping("/{id}")
	public Product update(@RequestBody Product product, @PathVariable Integer id) {
		return productService.update(id, product);
	}
}
