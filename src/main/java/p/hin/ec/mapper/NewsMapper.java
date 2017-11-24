package p.hin.ec.mapper;

import p.hin.ec.dao.News;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewsMapper {
    @Select("select * from t_news")
    List<News> getNewsList();

    @Select("select * from t_news where newsId=#{0}")
    News getNewsById(int newsId);

    @Insert("insert into t_news(title,content,date) values(#{title},#{content},#{date})")
    void addNews(News news);
}
