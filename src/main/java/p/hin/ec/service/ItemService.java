package p.hin.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import p.hin.ec.common.Constant;
import p.hin.ec.dao.Favorite;
import p.hin.ec.dao.Item;
import p.hin.ec.mapper.FavoriteMapper;
import p.hin.ec.mapper.ItemMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ItemService {
    private static final int LATEST_LIMIT_COUNT = 8;

    @Autowired
    ItemMapper mapper;

    @Autowired
    FavoriteMapper favoriteMapper;

    public List<Item> searchItems(int categoryId, String keyword) {
        List<Item> items = new ArrayList<>();
        if (categoryId == Constant.CATEGORY_ALL) {
            for (int i = 0; i < 6; i++) {
                items.addAll(mapper.getItemsByCategoryAndKeyword("%" + keyword + "%", i));
            }
        } else {
            items.addAll(mapper.getItemsByCategoryAndKeyword("%" + keyword + "%", categoryId));
        }
        return items;
    }

    public List<Item> getItemsByCategoryId(int categoryId) {
        return mapper.getItemsByCategory(categoryId);
    }

    public List<Item> getLatestItems() {
        return mapper.getLatestUploadedItems(LATEST_LIMIT_COUNT);
    }

    public List<Item> getFavoriteItems(int userId) {
        List<Favorite> favorites = favoriteMapper.getFavoriteItemsByUserId(userId);
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < favorites.size(); i++) {
            items.add(mapper.getItemByItemID(favorites.get(i).getItemId()));
        }
        return items;
    }

    public List<Item> getItemsByUploaderId(int uploaderId) {
        return mapper.getItemsByUploaderId(uploaderId);
    }

    public Item getItemByItemId(int itemId) {
        return mapper.getItemByItemID(itemId);
    }

    public void createItem(Item item, HttpServletRequest request, MultipartFile[] multipartFiles) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        item.setItemId(mapper.addItem(item));
        uploadPics(request, multipartFiles, item);
    }

    public void updateItem(Item item, HttpServletRequest request, MultipartFile[] multipartFiles) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IOException {
        mapper.updateItem(item);
        //uploadPics(request, multipartFiles, item);
    }

    public void deleteItem(int itemId) {
        mapper.deleteItemByItemId(itemId);
    }

    private void uploadPics(HttpServletRequest request, MultipartFile[] multipartFiles, Item item) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> itemPicDir = new ArrayList<>();
        String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/" + item.getItemId() + "/";
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        for (int i = 0; i < multipartFiles.length; i++) {
            String suffix = multipartFiles[i].getOriginalFilename().substring(multipartFiles[i].getOriginalFilename().lastIndexOf("."));
            String fileName = UUID.randomUUID() + suffix;
            itemPicDir.add(uploadDir + fileName);
            File storeFile = new File(itemPicDir.get(i));
            multipartFiles[i].transferTo(storeFile);
        }
        Class itemClass = item.getClass();

        int initId = 0;
        for (int i = 0; i < 10; i++) {
            Method method = itemClass.getDeclaredMethod("getItemPic" + i);
            if (method.invoke(null) == null) {
                initId = i;
                break;
            }
        }
        for (int i = 0; i < multipartFiles.length; i++) {
            Method method = itemClass.getDeclaredMethod("setItemPic" + initId + i, String.class);
            method.invoke(itemPicDir.get(i));
        }
        mapper.updateItemPic(item);
    }
}
