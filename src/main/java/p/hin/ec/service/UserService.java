package p.hin.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p.hin.ec.common.Constant;
import p.hin.ec.dao.User;
import p.hin.ec.mapper.UserMapper;

@Service
public class UserService {

    @Autowired
    UserMapper mapper;

    public int verifyRegisterUser(String username, String email) {
        if (mapper.getUserByUsername(username) == null && mapper.getUserByEmail(email) == null) {
            return Constant.USER_REGISTER_SUCCESS;
        } else {
            if (mapper.getUserByEmail(email) != null) {
                return Constant.USER_REGISTER_EMAIL_DUPLICATE;
            } else {
                return Constant.USER_REGISTER_USERNAME_DUPLICATE;
            }
        }
    }

    public int verifyLoginUser(String account, String password) {
        if (mapper.verifyUserByEmail(account, password) != null || mapper.verifyUserByUsername(account, password) != null) {
            return Constant.USER_LOGIN_SUCCESS;
        } else {
            return Constant.USER_LOGIN_NOT_MATCH;
        }
    }

    public void addNewUser(User user) {
        mapper.addUser(user);
    }

    public User getUser(String account) {
        User user = mapper.getUserByUsername(account);
        if (user == null) {
            user = mapper.getUserByEmail(account);
        }
        return user;
    }

    public User getUser(int userId) {
        return mapper.getUserByUserId(userId);
    }

    public void updateUser(User user) {
        mapper.updateUser(user);
    }

    public int getUserType(int userId) {
        return mapper.getUserTypeByUserId(userId);
    }
}
