package com.example.managercustomer.controller;

import com.example.managercustomer.model.Customer;
import com.example.managercustomer.model.service.CustomerService;
import com.example.managercustomer.model.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private ICustomerService iCustomerService = new CustomerService();

    @GetMapping("")
    public String list(Model model) {
        List<Customer> customerList = iCustomerService.findAll();
        model.addAttribute("customer",customerList);
        return "/list";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer",new Customer());
        return "/create";
    }
    @PostMapping("/save")
    public String save (Customer customer) {
        customer.setId((int) (Math.random() * 10000));
        iCustomerService.save(customer);
        return "redirect:/customers";
    }
    @GetMapping("/{id}/edit")
    public String update (@PathVariable int id,Model model) {
        model.addAttribute("customer",iCustomerService.findById(id));
        return "/update";
    }
    @PostMapping("/update")
    public String update (Customer customer) {
        iCustomerService.update(customer,customer.getId());
        return "redirect:/customers";
    }
    @GetMapping("/{id}/delete")
    public String delete (@PathVariable int id,Model model) {
        model.addAttribute("customer",iCustomerService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete (Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customers";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id,Model model) {
        model.addAttribute("customer",iCustomerService.findById(id));
        return "/view";
    }
}
