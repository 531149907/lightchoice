package p.hin.ec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import p.hin.ec.common.Constant;
import p.hin.ec.dao.Item;
import p.hin.ec.service.ItemService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class ItemController {
    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    @ResponseBody
    public List<Item> getItems(int type,
                               @RequestParam(required = false) Integer categoryId,
                               @RequestParam(required = false) String keyword,
                               @RequestParam(required = false) Integer userId) {
        List<Item> items = new ArrayList<>();
        switch (type) {
            case Constant.GET_ITEMS_SEARCH:
                if (keyword != null) {
                    items = itemService.searchItems(categoryId, keyword);
                }
                break;
            case Constant.GET_ITEMS_CATEGORY:
                items = itemService.getItemsByCategoryId(categoryId);
                break;
            case Constant.GET_ITEMS_FAVORITE:
                items = itemService.getFavoriteItems(userId);
                break;
            case Constant.GET_ITEMS_LATEST:
                items = itemService.getLatestItems();
                break;
            case Constant.GET_ITEMS_UPLOADER:
                items = itemService.getItemsByUploaderId(userId);
                break;
        }
        return items;
    }

    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
    public Item getItem(@PathVariable("itemId") int itemId) {
        return itemService.getItemByItemId(itemId);
    }

    @RequestMapping(value = "/item", method = RequestMethod.PUT)
    public void updateItem(Item item,
                           @RequestParam(required = false) HttpServletRequest request,
                           @RequestParam(required = false) MultipartFile[] multipartFiles) {
        try {
            itemService.updateItem(item, request, multipartFiles);
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public void createItem(Item item, HttpServletRequest request, MultipartFile[] multipartFiles) {
        try {
            itemService.createItem(item, request, multipartFiles);
        } catch (IOException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

  /*  @RequestMapping(value = "/item/{itemId}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable("itemId") int itemId) {
        itemService.deleteItem(itemId);
    }*/
}
