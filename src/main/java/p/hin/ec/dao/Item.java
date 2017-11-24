package p.hin.ec.dao;

import java.io.Serializable;
import java.util.Date;

public class Item implements Serializable {
    private int itemId;
    private String itemPic0, itemPic1, itemPic2, itemPic3, itemPic4, itemPic5, itemPic6, itemPic7, itemPic8, itemPic9;
    private Date date;
    private String title;
    private String price;
    private String description;
    private String material;
    private String size;
    private String weight;
    private String originCountry;
    private int uploader;
    private int category;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemPic0() {
        return itemPic0;
    }

    public void setItemPic0(String itemPic0) {
        this.itemPic0 = itemPic0;
    }

    public String getItemPic1() {
        return itemPic1;
    }

    public void setItemPic1(String itemPic1) {
        this.itemPic1 = itemPic1;
    }

    public String getItemPic2() {
        return itemPic2;
    }

    public void setItemPic2(String itemPic2) {
        this.itemPic2 = itemPic2;
    }

    public String getItemPic3() {
        return itemPic3;
    }

    public void setItemPic3(String itemPic3) {
        this.itemPic3 = itemPic3;
    }

    public String getItemPic4() {
        return itemPic4;
    }

    public void setItemPic4(String itemPic4) {
        this.itemPic4 = itemPic4;
    }

    public String getItemPic5() {
        return itemPic5;
    }

    public void setItemPic5(String itemPic5) {
        this.itemPic5 = itemPic5;
    }

    public String getItemPic6() {
        return itemPic6;
    }

    public void setItemPic6(String itemPic6) {
        this.itemPic6 = itemPic6;
    }

    public String getItemPic7() {
        return itemPic7;
    }

    public void setItemPic7(String itemPic7) {
        this.itemPic7 = itemPic7;
    }

    public String getItemPic8() {
        return itemPic8;
    }

    public void setItemPic8(String itemPic8) {
        this.itemPic8 = itemPic8;
    }

    public String getItemPic9() {
        return itemPic9;
    }

    public void setItemPic9(String itemPic9) {
        this.itemPic9 = itemPic9;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public int getUploader() {
        return uploader;
    }

    public void setUploader(int uploader) {
        this.uploader = uploader;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
