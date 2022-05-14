package com.nsp.todo.service;

import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;

public interface MailService {
    void sendMail(SimpleMailMessage message);
    void sendMail(MimeMessage message);
}
