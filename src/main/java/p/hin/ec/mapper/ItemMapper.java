package p.hin.ec.mapper;

import org.apache.ibatis.annotations.*;
import p.hin.ec.dao.Item;

import java.util.List;

@Mapper
public interface ItemMapper {
    @Select("select * from t_item where category=#{0} and status=0")
    List<Item> getItemsByCategory(int category);

    @Select("select * from t_item where category=#{1} and title like #{0} and status=0")
    List<Item> getItemsByCategoryAndKeyword(String keyword,int category);

    @Select("select * from t_item where itemId=#{0} and status=0")
    Item getItemByItemID(int itemId);

    @Insert("insert into t_item(date,title,price,description,material,size,weight,originCountry,uploader,category,status) values(#{date},#{title},#{price},#{description},#{material},#{size},#{weight},#{originCountry},#{uploader},0) SELECT @@IDENTITY")
    int addItem(Item item);

    @Update("update t_item set itemPic0=#{itemPic0},itemPic1=#{itemPic1},itemPic2=#{itemPic2},itemPic3=#{itemPic3},itemPic4=#{itemPic4},itemPic5=#{itemPic5},itemPic6=#{itemPic6},itemPic7=#{itemPic7},itemPic8=#{itemPic8},itemPic9=#{itemPic9} where itemId=#{itemId}")
    void updateItemPic(Item item);

    @Update("update t_item set title = #{title},price=#{price},description=#{description},material=#{material},size=#{size},weight=#{weight},originCountry=#{originCountry},category=#{category} where itemId=#{itemId}")
    void updateItem(Item item);

    @Update("update t_item set status=1 where itemId=#{itemId}")
    void deleteItemByItemId(int itemId);

    @Select("SELECT * FROM t_item ORDER BY DATE DESC LIMIT #{0};")
    List<Item> getLatestUploadedItems(int limit);

    @Select("select * from t_item where uploader = ${0} order by date desc")
    List<Item> getItemsByUploaderId(int uploaderId);
}
