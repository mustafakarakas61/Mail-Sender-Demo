package com.mustafa.mailSender.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class MailConfig {

    private Environment env;
    public MailConfig(Environment env){
        this.env = env;
    }

    @Bean
    public JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("spring.mail.host"));
        mailSender.setPort(Integer.valueOf(env.getProperty("spring.mail.port")));

        mailSender.setUsername(env.getProperty("spring.mail.username"));
        mailSender.setPassword(env.getProperty("spring.mail.password"));

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", env.getProperty("spring.mail.protocol"));
        props.put("mail.smtp.auth", env.getProperty("spring.mail.properties.mail.smtp.auth"));
        props.put("mail.smtp.starttls.enable",env.getProperty("spring.mail.properties.mail.smtp.starttls.enabled"));
        props.put("mail.debug",env.getProperty("spring.mail.debug"));

        return mailSender;
    }
}
