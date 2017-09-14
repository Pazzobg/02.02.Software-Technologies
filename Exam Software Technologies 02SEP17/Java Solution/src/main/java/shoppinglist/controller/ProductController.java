package shoppinglist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import shoppinglist.bindingModel.ProductBindingModel;
import shoppinglist.entity.Product;
import shoppinglist.repository.ProductRepository;

import java.util.List;

@Controller
public class ProductController {

	private final ProductRepository productRepository;

	@Autowired
	public ProductController(ProductRepository productRepository) {

		this.productRepository = productRepository;
	}

	@GetMapping("/")
	public String index(Model model) {
		List<Product> products = productRepository.findAll();

		model.addAttribute("products", products);
		model.addAttribute("view", "product/index");

		return "base-layout";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("view", "product/create");
		return "base-layout";
	}

	@PostMapping("/create")
	public String createProcess(Model model, ProductBindingModel productBindingModel) {
		if (productBindingModel == null || productBindingModel.getPriority().equals("") ||
				productBindingModel.getName().equals("") ||
				productBindingModel.getQuantity().equals("")) {
			model.addAttribute("view", "product/create");
			return "base-layout";
		}

		Product currentlyCreatedProduct = new Product(
				productBindingModel.getPriority(),
				productBindingModel.getName(),
				productBindingModel.getQuantity(),
				productBindingModel.getStatus()
		);

		productRepository.saveAndFlush(currentlyCreatedProduct);

		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable int id) {
		if (!this.productRepository.exists(id)) {
			return "redirect:/";
		}

		Product productForEdit = this.productRepository.findOne(id);

		model.addAttribute("product", productForEdit);
		model.addAttribute("view", "product/edit");

		return "base-layout";
	}

	@PostMapping("/edit/{id}")
	public String editProcess(Model model, @PathVariable int id, ProductBindingModel productBindingModel) {
		if (!this.productRepository.exists(id) ||
				productBindingModel.getPriority().equals("") ||
				productBindingModel.getName().equals("") ||
				productBindingModel.getQuantity().equals("") ||
				productBindingModel.getStatus().equals("")) {
			return "redirect:/";
		}

		Product productForEdit = this.productRepository.findOne(id);

		productForEdit.setPriority(productBindingModel.getPriority());
		productForEdit.setName(productBindingModel.getName());
		productForEdit.setQuantity(productBindingModel.getQuantity());
		productForEdit.setStatus(productBindingModel.getStatus());

		this.productRepository.saveAndFlush(productForEdit);

		return "redirect:/";
	}
}
