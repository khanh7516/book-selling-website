package com.example.booksellingwebsite.controller;


import com.example.booksellingwebsite.entity.Book;
import com.example.booksellingwebsite.service.impl.AuthorService;
import com.example.booksellingwebsite.service.impl.BookService;
import com.example.booksellingwebsite.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
public class WebController {


    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AuthorService authorService;


    @GetMapping("/")
    public String getHome() {
        return "web/index";
    }

    @GetMapping("/shop")
    public String getShop(Model model) {

        Page<Book> pageData = bookService.listAllPage(1);

        model.addAttribute("currentPage", 1);
        model.addAttribute("totalPages", pageData.getTotalPages());
        model.addAttribute("totalItems", pageData.getTotalElements());
        model.addAttribute("pageData", pageData);
        model.addAttribute("categories", categoryService.listAllDTO());
        model.addAttribute("authors", authorService.listAllDTO());

        return "web/shop";
    }


    @GetMapping("/shop/{pageNum}")
    public String getShop(Model model, @PathVariable Integer pageNum) {

        Page<Book> pageData = bookService.listAllPage(pageNum);

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", pageData.getTotalPages());
        model.addAttribute("totalItems", pageData.getTotalElements());
        model.addAttribute("pageData", pageData);
        model.addAttribute("categories", categoryService.listAllDTO());
        model.addAttribute("authors", authorService.listAllDTO());

        return "web/shop";
    }

    @GetMapping("/shop/search")
    public String getSearchShop(Model model,
                          @RequestParam(name = "keyword", required = false) String name,
                          @RequestParam(name = "minPrice", required = false) Integer minPrice,
                          @RequestParam(name = "maxPrice", required = false) Integer maxPrice,
                          @RequestParam(name = "categories", required = false) Set<Integer> categoryIds,
                          @RequestParam(name = "author", required = false, defaultValue = "1") Integer authorId,
                          @RequestParam(name = "sort", defaultValue = "date-asc") String sort){

        // You may need to adjust the method signature and parameters based on your requirements
        Pageable pageable = PageRequest.of(1, 10);
        Page<Book> pageData = bookService.searchAndSort(name, authorId, categoryIds,minPrice, maxPrice, sort, pageable);

        System.out.println(pageData.getContent());

        model.addAttribute("currentPage", pageData.getNumber());
        model.addAttribute("totalPages", pageData.getTotalPages());
        model.addAttribute("totalItems", pageData.getTotalElements());
        model.addAttribute("pageData", pageData);
        model.addAttribute("categories", categoryService.listAllDTO());
        model.addAttribute("authors", authorService.listAllDTO());

        model.addAttribute("name", name);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("categoryIds", categoryIds);
        model.addAttribute("author", authorId);
        model.addAttribute("sort", sort);


        return "web/shop";
    }




    @GetMapping("/detail")
    public String getDetail() {
        return "web/detail";
    }
    @GetMapping("/checkout")
    public String getCheckout() {
        return "web/checkout";
    }
    @GetMapping("/cart")
    public String getCart() {
        return "web/cart";
    }
    @GetMapping("/contact")
    public String getContact() {
        return "web/contact";
    }

}
