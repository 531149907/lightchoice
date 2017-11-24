package p.hin.ec.controller;

import p.hin.ec.dao.News;
import p.hin.ec.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class NewsController {
    @Autowired
    NewsService service;

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public List<News> getNews() {
        return service.getNewsList();
    }
}
