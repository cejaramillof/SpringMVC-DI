package com.example.springbootweb;

import com.example.springbootweb.models.domain.ItemInvoice;
import com.example.springbootweb.models.domain.Product;
import com.example.springbootweb.models.service.FirstService;
import com.example.springbootweb.models.service.IFirstService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

// this class can be used by spring like a beans repository
// is more used when is external class like from api, frameworks
@Configuration
public class AppConfig {

    //@Bean("name")
    public IFirstService firstService(){
        return new FirstService();
    }

    @Bean("ItemsInvoice")
    public List<ItemInvoice> addItems(){
        Product productOne = new Product("Bike", 50);
        Product productTwo = new Product("MotorBike", 100);

        ItemInvoice itemInvoiceOne = new ItemInvoice(productOne, 4);
        ItemInvoice itemInvoiceTwo = new ItemInvoice(productTwo, 2);

        return Arrays.asList(itemInvoiceOne, itemInvoiceTwo);
    }

    @Bean("ItemsInvoiceTwo")
    public List<ItemInvoice> addItemsInvoiceTwo(){
        Product productOne = new Product("Ferrari", 350);
        Product productTwo = new Product("Lamborghini", 400);
        Product productThree = new Product("Corvete", 300);
        Product productFour = new Product("Chevrolet", 100);


        ItemInvoice itemInvoiceOne = new ItemInvoice(productOne, 4);
        ItemInvoice itemInvoiceTwo = new ItemInvoice(productTwo, 2);
        ItemInvoice itemInvoiceThree = new ItemInvoice(productThree, 3);
        ItemInvoice itemInvoiceFour = new ItemInvoice(productFour, 8);

        return Arrays.asList(itemInvoiceOne, itemInvoiceTwo, itemInvoiceThree, itemInvoiceFour);
    }
}
