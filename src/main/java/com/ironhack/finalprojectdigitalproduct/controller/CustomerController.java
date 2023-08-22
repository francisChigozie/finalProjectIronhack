package com.ironhack.finalprojectdigitalproduct.controller;

import com.ironhack.finalprojectdigitalproduct.model.products.Product;
import com.ironhack.finalprojectdigitalproduct.model.users.Customer;
import com.ironhack.finalprojectdigitalproduct.resository.CustomerRepository;
import com.ironhack.finalprojectdigitalproduct.service.CustomerService;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;


    @PostMapping("/createCustomer")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createNewCustomer(@RequestBody @Valid Customer customer){
        return customerService.createNewCustomer(customer);
    }

    @GetMapping("/customers/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerById(@PathVariable(name="bookId")long customerId) {
        return customerService.findById(customerId);
    }

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PatchMapping("/customers/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateCustomerPWD(@PathVariable("id") Long id,@RequestParam String password) {
        customerService.updateCustomerPWD(id,password);
    }

    @PutMapping("/customers/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable("id") Long id,@RequestBody Customer customer) {
        customerService.updateCustomer(id,customer);
    }

   @PatchMapping("/customers/{id}/products")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addProductToCustomer(@PathVariable("id") Long id, @RequestBody Product product) {
       customerService.addProductToCustomer(id, product);
    }

    @SneakyThrows
    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Boolean> deleteCustomer(@PathVariable(name="id")long id) {
        return customerService.deleteCustomerById(id);
    }


}
