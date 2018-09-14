package project.springwebmvcdemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dt.b190043.demoproject.dao.ProductDao;
import dt.b190043.demoproject.dao.SubCategoryDao;
import dt.b190043.demoproject.factory.ProductFactory;
import dt.b190043.demoproject.model.Mobile;
import dt.b190043.demoproject.model.Product;

@Controller
@RequestMapping("/seller")
public class SellerController {

	@Autowired
	private SubCategoryDao subCategoryDao;

	
	@Autowired
	private ProductDao<Product> productDao;
	
	
	@GetMapping
	public String sellerPage(Model model) {
		model.addAttribute("subcategories", subCategoryDao.getAll());
		return "seller";
	}

	@PostMapping("/getmodel")
	public String getModelForProduct(HttpServletRequest request, Model model) {
		
		switch (request.getParameter("subcategory")) {
		
		case "mobile":
			model.addAttribute("product", ProductFactory.getMobile());
			break;
		case "books":model.addAttribute("product", ProductFactory.getBook());	
		}

		return "product";
	}
	
	
	@PostMapping("/addproduct")
	public <T extends Product> String addProduct(HttpServletRequest httpServletRequest)
	{
		
		System.out.println(httpServletRequest.getAttribute("product"));
		//productDao.addProduct(t);
		return "redirect:/seller";
	}
}
