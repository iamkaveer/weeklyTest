package com.example.Weekly_Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class Config {
    @Bean
    public Customer customer() {
        return new Customer("Kaveer", 1234);
    }
    @Bean
    public MailService mailService() {
        return new MailService();
    }
}
