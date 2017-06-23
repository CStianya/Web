package com.controller;

import com.dao.entity.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CS on 2017/6/23.
 */

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/product_input")
    public String inputProduct() {
        return "ProductForm";
    }

    @RequestMapping("/product_save")
    public String saveProduct(HttpServletRequest servletRequest, Product product, RedirectAttributes redirectAttributes) {
        List<MultipartFile> files = product.getImages();
        List<String> fileNames = new ArrayList<>();
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            fileNames.add(fileName);
            File imageFile = new File(servletRequest.getServletContext().getRealPath("/image"), fileName);
            try {
                file.transferTo(imageFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Product savedProduct = productService.add(product);
        redirectAttributes.addFlashAttribute("message", "The product was successfully added.");
        return "redirect:/product_view/" + savedProduct.getId();
    }

    @RequestMapping("/product_view/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        Product product = productService.get(id);
        model.addAttribute("product", product);
        return "ProductDetail";
    }

}
