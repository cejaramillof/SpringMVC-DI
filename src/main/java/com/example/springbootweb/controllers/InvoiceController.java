package com.example.springbootweb.controllers;

import com.example.springbootweb.models.domain.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private Invoice invoice;

    @GetMapping("/show")
    public String show(Model model) {
        model.addAttribute("title", "Invoice example with DI");
        model.addAttribute("invoice", invoice);
        return "invoice/show";
    }
}
