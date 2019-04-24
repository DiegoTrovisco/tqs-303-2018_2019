package com.tqs303.clouddeliveries;


import com.tqs303.clouddeliveries.entities.Pedido;
import com.tqs303.clouddeliveries.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;


@SpringBootApplication
public class ClouddeliveriesApplication  {
//    @Autowired
//    private ApplicationContext appContext;

    public static void main(String[] args) {
        SpringApplication.run(ClouddeliveriesApplication.class, args);
    }

    @Bean(name = "passinstace")
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean(name = "userinstance")
    public User userInstance(){
        return new User();
    }

    @Bean(name = "pedidoinstance")
    public Pedido pedidoInstance(){
        return new Pedido();
    }
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("forward:/index.xhtml");
//    }

//    @Bean
//    public SpringResourceTemplateResolver templateResolver(){
//        // SpringResourceTemplateResolver automatically integrates with Spring's own
//        // resource resolution infrastructure, which is highly recommended.
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setApplicationContext(this.appContext);
//        templateResolver.setPrefix("/WEB-INF/templates/");
//        templateResolver.setSuffix(".html");
//        // HTML is the default value, added here for the sake of clarity.
//        templateResolver.setTemplateMode(TemplateMode.HTML);
//        // Template cache is true by default. Set to false if you want
//        // templates to be automatically updated when modified.
//        templateResolver.setCacheable(true);
//        return templateResolver;
//    }
//
//
//    @Bean
//    public SpringTemplateEngine templateEngine(){
//        // SpringTemplateEngine automatically applies SpringStandardDialect and
//        // enables Spring's own MessageSource message resolution mechanisms.
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        // Enabling the SpringEL compiler with Spring 4.2.4 or newer can
//        // speed up execution in most scenarios, but might be incompatible
//        // with specific cases when expressions in one template are reused
//        // across different data types, so this flag is "false" by default
//        // for safer backwards compatibility.
//        templateEngine.setEnableSpringELCompiler(true);
//        return templateEngine;
//    }



}
