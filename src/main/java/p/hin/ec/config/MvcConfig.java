package p.hin.ec.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{
    //可以直接使用WebMvcConfigurerAdapter中的addViewControllers方法来映射html，适用于MVC架构中不需要交互的，不用传统的Controller
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /*registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");*/
    }

}
