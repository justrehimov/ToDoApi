package com.nsp.todo.service.impl;

import com.nsp.todo.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@AllArgsConstructor
@Service
public class MailServiceImpl implements MailService {
    private final JavaMailSender mailSender;

    @Async
    @Override
    public void sendMail(SimpleMailMessage message) {
        mailSender.send(message);
    }

    @Async
    @Override
    public void sendMail(MimeMessage message) {
        mailSender.send(message);
    }
}
