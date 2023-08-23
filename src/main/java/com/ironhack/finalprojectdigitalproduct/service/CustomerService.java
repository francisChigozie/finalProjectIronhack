package com.ironhack.finalprojectdigitalproduct.service;

import com.ironhack.finalprojectdigitalproduct.model.products.Book;
import com.ironhack.finalprojectdigitalproduct.model.products.Product;
import com.ironhack.finalprojectdigitalproduct.model.users.Customer;
import com.ironhack.finalprojectdigitalproduct.model.users.Review;
import com.ironhack.finalprojectdigitalproduct.resository.CustomerRepository;
import com.ironhack.finalprojectdigitalproduct.resository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;
    public Customer createNewCustomer (@Valid Customer customer){
        return customerRepository.save(customer);
    }

    public Customer findById(long customerId){
        return customerRepository.findById(customerId).orElseThrow(
                ()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Customer with id " + customerId + " not found.")
        );
    }

    @Transactional
    public ResponseEntity<Customer> updateCustomer(Long id, Customer customerDetails)
            throws EntityNotFoundException {
        Customer customer =
                    customerRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new EntityNotFoundException(
                                        "Customer not found on :: " + id));

        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        customer.setPermanentAddress(customerDetails.getPermanentAddress());
        customer.setUpdatedAt(customerDetails.modifyDate());
        final Customer updatedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    public void updateCustomerPWD(Long id, String password) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Password not found")
        );
        //customer.getId();
        customer.setPassword(password);
        customer.setUpdatedAt(customer.modifyDate());
        customerRepository.save(customer);
    }

    public Map<String, Boolean> deleteCustomerById(Long id) throws Exception {
        Customer customer =
                    customerRepository
                        .findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Customer not found on :: " + id));

        customerRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Customer deleted !", Boolean.TRUE);
        return response;
    }

    @Transactional
    public ResponseEntity<Customer> addProductToCustomer(Long id, Customer customerDetails)
            throws EntityNotFoundException {
        Customer customer =
                customerRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new EntityNotFoundException(
                                        "CustomerToProduct not found on :: " + id));

        customer.setProducts(customerDetails.getProducts());
        customer.setUpdatedAt(customerDetails.modifyDate());
        final Customer updatedProduct = customerRepository.save(customer);
        return ResponseEntity.ok(updatedProduct);
    }
}
