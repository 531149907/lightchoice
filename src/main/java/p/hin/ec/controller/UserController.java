package p.hin.ec.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import p.hin.ec.common.Constant;
import p.hin.ec.dao.User;
import p.hin.ec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.servlet.http.HttpSession;

@RestController
@EnableAutoConfiguration
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public int registerUser(User user) {
        int verifyResult = userService.verifyRegisterUser(user.getUsername(), user.getEmail());
        if (verifyResult == Constant.USER_REGISTER_SUCCESS) {
            userService.addNewUser(user);
        }
        return verifyResult;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public int loginUser(String account, String password, HttpSession session) {
        System.out.println(account+" || "+password);
        int verifyResult = userService.verifyLoginUser(account, password);
        if (verifyResult == Constant.USER_LOGIN_SUCCESS) {
            session.setAttribute("userEntity", userService.getUser(account));
        }
        return verifyResult;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public int logoutUser(HttpSession session) {
        session.removeAttribute("userEntity");
        return Constant.USER_LOGOUT_SUCCESS;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.PUT)
    public void updateProfile(User user) {
        userService.updateUser(user);
    }

    @RequestMapping(value = "/profile/{userId}", method = RequestMethod.GET)
    public User getProfile(@PathVariable("userId") int userId) {
        return userService.getUser(userId);
    }

}
