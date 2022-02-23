package com.mehdisarf.mvc.initializer;

import com.mehdisarf.mvc.config.WebAppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        // Bootstrapping our IOC container
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();

        context.register(WebAppConfig.class);

        // register our Dispatcher Servlet with the Servlet Context.
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        ServletRegistration.Dynamic registration =
                servletContext.addServlet("dispatcher",dispatcherServlet);

        registration.addMapping("/");
        registration.setLoadOnStartup(1);

        System.out.println("233");
    }
}
