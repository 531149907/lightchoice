package p.hin.ec.mapper;

import p.hin.ec.dao.Favorite;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FavoriteMapper {
    @Insert("insert into t_favorite(itemId,userId) values(#{itemId},#{userId})")
    void createNewFavoriteItem(int userId, int itemId);

    @Delete("delete t_favorite where favoriteId = #{favoriteId}")
    void deleteFavoriteItemByFavoriteId(int favoriteId);

    @Delete("delete t_favorite where itemId = #{itemId}")
    void deleteFavoriteItemByItemId(int itemId);

    @Select("select * from t_favorite where favoriteId=#{favoriteId}")
    Favorite getFavoriteItemByFavoriteId(int favoriteId);

    @Select("select * from t_favorite where userId=#{userId}")
    List<Favorite> getFavoriteItemsByUserId(int userId);
}
