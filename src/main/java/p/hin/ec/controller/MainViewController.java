package p.hin.ec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import p.hin.ec.service.*;

@Controller
public class MainViewController {
    @Autowired
    ItemService itemService;

    @Autowired
    NewsService newsService;

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    FavoriteService favoriteService;

    @RequestMapping(value = "/login_test",method = RequestMethod.GET)
    public String getPage(){
        return "index2";
    }

}
