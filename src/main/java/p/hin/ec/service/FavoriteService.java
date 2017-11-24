package p.hin.ec.service;

import p.hin.ec.mapper.FavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {
    @Autowired
    FavoriteMapper favoriteMapper;

    public void deleteFavoriteItem(int favoriteId) {
        favoriteMapper.deleteFavoriteItemByFavoriteId(favoriteId);
    }

    public void addFavoriteItem(int userId, int itemId) {
        favoriteMapper.createNewFavoriteItem(userId, itemId);
    }
}
