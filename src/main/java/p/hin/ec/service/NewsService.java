package p.hin.ec.service;

import p.hin.ec.dao.News;
import p.hin.ec.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    NewsMapper mapper;

    public List<News> getNewsList() {
        return mapper.getNewsList();
    }
}
