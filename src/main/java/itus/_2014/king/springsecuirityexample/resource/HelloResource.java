package itus._2014.king.springsecuirityexample.resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class HelloResource {
    @GetMapping("/all")
    public String hello() {
        return "Hello there";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secure/all")
    public String secureHello() {
        return "Secure Hello";
    }

    @GetMapping("/secure/alternate")
    public String alternate() {
        return "alternate";
    }
}
