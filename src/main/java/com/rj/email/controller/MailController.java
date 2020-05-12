package com.rj.email.controller;

import com.rj.email.dto.Mail;
import com.rj.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;

@RestController
@RequestMapping(path = "/mail")
public class MailController
{
    @Autowired
    private EmailService emailService;



    @PostMapping(path= "/send", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Mail mail)
    {
        emailService.sendSimpleMessage(mail);
        return ResponseEntity.ok("Sent successfully ..");
    }
}
