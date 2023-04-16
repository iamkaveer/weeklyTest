package com.example.Weekly_Test.controller;
import com.example.Weekly_Test.MailService;
import com.example.Weekly_Test.Customer;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class CustomerController {

    @Autowired
    private Customer customer;
    @Autowired
    private MailService mailService;
    @GetMapping("/customer")
    public List<Customer> getCustomers() {
        return List.of(customer);
    }
    @GetMapping("/sendmail")
    public String sendMail() throws MessagingException {
        String objectDetails = customer.toString();
        mailService.sendEmail("Customer Details", objectDetails);
        return "Email sent successfully!";
    }
}
