package p.hin.ec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    /*@RequestMapping("/")
    public String toIndex() {
        return "index";
    }*/


}
