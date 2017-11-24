package p.hin.ec.controller;

import p.hin.ec.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class FavoriteController {

    @Autowired
    FavoriteService service;

    @RequestMapping(value = "/favorite", method = RequestMethod.POST)
    public void addFavorite(int userId, int itemId) {
        service.addFavoriteItem(userId, itemId);
    }

    @RequestMapping(value = "/favorite/{favoriteId}", method = RequestMethod.DELETE)
    public void removeFavorite(@PathVariable("favoriteId") int favoriteId) {
        service.deleteFavoriteItem(favoriteId);
    }

}
