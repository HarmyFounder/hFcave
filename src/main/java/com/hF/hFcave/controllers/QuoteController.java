package com.hF.hFcave.controllers;

import com.hF.hFcave.models.User;
import com.hF.hFcave.repositories.UserDetailRepo;
import com.hF.hFcave.services.MailSender;
import com.hF.hFcave.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @Autowired
    private MailSender mailSender;

    @PostMapping("/setQuotesSending")
    public void setQuoteNotifications(@AuthenticationPrincipal User user, @RequestParam int hour, int minute) throws IOException, MessagingException {
        String quote = quoteService.getQuote();
        mailSender.send(user.getEmail(), quote, "Quote from hFcave",hour, minute);
    }


}
