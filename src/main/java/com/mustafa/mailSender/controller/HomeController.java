package com.mustafa.mailSender.controller;

import com.mustafa.mailSender.model.data.Mail;
import com.mustafa.mailSender.services.EmailService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class HomeController {

    @Autowired
    private Environment env;
    @Autowired
    private EmailService emailService;

    public HomeController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("main")
    public void sendMail(){
        Mail mail = new Mail();
        mail.setFrom(env.getProperty("spring.mail.username"));
        mail.setTo("mail.m.karakas@gmail.com");
        mail.setSubject("Konu");
        mail.setContent("Java ile yazıldı");
        emailService.sendSimpleMessage(mail);
    }
}
