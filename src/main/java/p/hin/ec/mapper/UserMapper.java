package p.hin.ec.mapper;

import p.hin.ec.dao.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM t_user WHERE username = #{0}")
    User getUserByUsername(String username);

    @Select("select * from t_user where email=#{0}")
    User getUserByEmail(String email);

    @Select("select * from t_user where userId = #{userId}")
    User getUserByUserId(int userId);

    @Insert("insert into t_user(username,password,email,realName,phone,address,type,status,publicKey) values(#{username},#{password},#{email},#{realName},#{phone},#{address},#{type},#{status},#{publicKey})")
    void addUser(User user);

    @Update("update t_user set password=#{password},realName=#{realName},address=#{address},phone=#{phone} where userId=#{userId}")
    void updateUser(User user);

    @Select("SELECT * FROM t_user WHERE username = #{0} AND password = #{1}")
    User verifyUserByUsername(String username, String password);

    @Select("select * from t_user where email=#{0} and password=#{1}")
    User verifyUserByEmail(String email, String password);

    @Select("select type from t_user where userId=#{0}")
    int getUserTypeByUserId(int userId);
}
