package com.taco.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taco.demo.entity.Product;
import com.taco.demo.repository.ProductRepository;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	
	ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@GetMapping(value={"","/"})
	public String welcome() {
		return "index";
	}
	
	@GetMapping("/products")
	public String getProductList(Model model) {
		model.addAttribute("products", productRepository.findAll());
		return "products";
	}	
	
	@GetMapping("/add")
	public String addProduct(Model model) {
		model.addAttribute("products", new Product());
		return "products";
	}
	
	@GetMapping("/editProduct")
	public String getProductEditForm(@RequestParam("id") int id, Model model) {
		Product product = productRepository.findById(id).get();
		model.addAttribute("product", product);
		
		return "edit";
	}
	
	@PostMapping("/save")
	public String addProduct(@ModelAttribute("product") Product product) {
		productRepository.save(product);
		return "redirect:/productMain1";
	}
	
	@GetMapping("/delete")
	public String getDeleteProductForm(@RequestParam("id") int id, Model model) {
		model.addAttribute("product", productRepository.findById(id).get());
		return "delete";
	}
	
	@PostMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("id") int id) {
		productRepository.deleteById(id);
		return "redirect:/productMain1";
	}
}
