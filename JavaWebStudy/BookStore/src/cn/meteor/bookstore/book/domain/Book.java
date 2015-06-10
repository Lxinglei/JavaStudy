package cn.meteor.bookstore.book.domain;

import cn.meteor.bookstore.category.domain.Category;

/**
 * Created by meteor on 15/6/6.
 */
public class Book {
    private String bid;
    private String bname;
    private double price;
    private String author;
    private String image;
    private Category category;

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
/*
bid    | char(32)     | NO   | PRI | NULL    |       |
| bname  | varchar(100) | YES  |     | NULL    |       |
| price  | decimal(5,1) | YES  |     | NULL    |       |
| author | varchar(20)  | YES  |     | NULL    |       |
| image  | varchar(200) | YES  |     | NULL    |       |
| cid
 */