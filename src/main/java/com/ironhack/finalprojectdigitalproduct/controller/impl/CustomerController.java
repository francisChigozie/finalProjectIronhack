package com.ironhack.finalprojectdigitalproduct.controller.impl;

import com.ironhack.finalprojectdigitalproduct.controller.interfaces.CustomerControllerInterface;
import com.ironhack.finalprojectdigitalproduct.dto.onlyDto.ProductDTO;
import com.ironhack.finalprojectdigitalproduct.model.user.User;
import com.ironhack.finalprojectdigitalproduct.repository.UserRepository;
import com.ironhack.finalprojectdigitalproduct.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class CustomerController implements CustomerControllerInterface {
    @Autowired private UserRepository userRepository;
    @Autowired private UserServiceImpl userService;

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public User createNewCustomer(@Valid @RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {
        return userService.getUsers();
    }


    @GetMapping("/getUsername")
    @ResponseStatus(HttpStatus.OK)
    public User getUserByUsername(String username){
        return userService.getUser(username);
    }

    @GetMapping("/customers/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public User getCustomerById(@PathVariable(name="customerId")long customerId) {
        return userService.findById(customerId);
    }
    @PutMapping("/customers/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable("id") Long id,@RequestBody User customer) {
        userService.updateCustomer(id,customer);
    }
    @PutMapping("/customerProduct/{customerId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public User addProductToCustomer(
            @PathVariable long customerId,
            @RequestBody ProductDTO productDTO) {
        User customer = userRepository.findById(customerId).get();

        customer.addProductToCustomer(productDTO);
        customer.setUpdatedAt(productDTO.modifyDate());
        return userRepository.save(customer);
    }
    @PatchMapping("/customers/{id}")
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateCustomerPWD(@PathVariable("id") Long id,@RequestParam String password) {
        userService.updateCustomerPWD(id,password);
    }
    @SneakyThrows
    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Boolean> deleteCustomer(@PathVariable(name="id")long id) {
        return userService.deleteCustomerById(id);
    }

}