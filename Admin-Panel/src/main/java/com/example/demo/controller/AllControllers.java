package com.example.demo.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Product;
import com.example.demo.service.AllInterfaces;

@Controller
@RequestMapping("/product")
public class AllControllers {
	

	private AllInterfaces allS;
	
	@Autowired
	public AllControllers(AllInterfaces allS) {
		this.allS = allS;
	}
	
	@GetMapping("/showFormForAllProduct")
	public String findAll(Model model){
		List <Product> listProducts = allS.findAll();
		model.addAttribute("products", listProducts);
		return "product";
	}
	
	@GetMapping("/showFormForLogin")
	public String showFormForLogin(Model model){
		return "login-form";
	}
	
	@GetMapping("/showFormForAddProduct")
	public String showFormForAddProduct(Model model){
		Product product = new Product();
		model.addAttribute("product", product);
		return "addProduct";
	}
	
	@GetMapping("/showFormForUpdateProduct")
	public String showFormForUpdateProduct(@RequestParam("productId") int id, Model model){
		Product product = allS.findById(id);
		model.addAttribute("product", product);
		return "updateProduct";
	}
	
	@GetMapping("/findById")
	public String findById(@RequestParam(name="id") int theId, Model model) {
		Product product = allS.findById(theId);
		model.addAttribute("product", product);
		return "product";
	}
	
	
	@PostMapping("/save")
	public String save(@ModelAttribute("product") @Valid Product product, BindingResult bindResult) {
		if(bindResult.hasErrors()) {
			System.out.println(bindResult.getFieldError());
			return "addProduct";
		}else {
			allS.save(product);
		return "redirect:showFormForAllProduct";
		}
	}
	
	@GetMapping("/deleteById")
	public String deleteById(@RequestParam(name="id") int theId) {
		allS.deleteById(theId);
		return "redirect:showFormForAllProduct";
	}

	@GetMapping("/sortByIdAsc")
	public List<Product> sortByIdAsc(){
		return allS.sortByIdAsc();
	}
	
	@GetMapping("/sortByIdDesc")
	public List<Product> sortByIdDesc(){
		return allS.sortByIdDesc();
	}
	
	@GetMapping("/sortByNameAsc")
	public List<Product> sortByNameAsc(){
		return allS.sortByNameAsc();
	}
	
	@GetMapping("/sortByNameDesc")
	public List<Product> sortByNameDesc(){
		return allS.sortByNameDesc();
	}
	
	@GetMapping("/sortByActualPriceAsc")
	public List<Product> sortByActualPriceAsc(){
		return allS.sortByActualPriceAsc();
	}
	
	@GetMapping("/sortByActualPriceDesc")
	public List<Product> sortByActualPriceDesc(){
		return allS.sortByActualPriceDesc();
	}
	


	
}
