package com.luv2code.controller;

import com.luv2code.dao.CustomerDAO;
import com.luv2code.entity.Customer;
import com.luv2code.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        List<Customer> theCostomers = customerService.getCustomers();

        theModel.addAttribute("customers", theCostomers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        Customer theCustomer = new Customer();

        model.addAttribute("customer",theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel) {
        Customer theCustomer = customerService.getCustomer(theId);

        theModel.addAttribute("customer",theCustomer);

        return "customer-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int theId) {

        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";

    }

    @GetMapping("/search")
    public String search(@RequestParam("theSearchName") String theSearchName,
                         Model model) {
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
        model.addAttribute("customers",theCustomers);

        return "list-customers";
    }


}
