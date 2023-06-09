// package com.driver.models;

// import org.hibernate.annotations.CreationTimestamp;

// import javax.persistence.*;
// import  java.util.*;

// @Entity
// @Table(name = "blog")

// public class Blog{
//     public Blog(){}

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "id")
//     private int id;

//     @Column(name = "title")
//     private String title;

//     @Column(name = "content")
//     private String content;

//     @Column(name = "date")
//     @CreationTimestamp
//     private Date pubDate;

//     // public Blog(String title, String content) {
//     //     this.title = title;
//     //     this.content = content;
//     // }

//     public Blog(String title, String content, Date pubDate) {
//         this.title = title;
//         this.content = content;
//         this.pubDate = pubDate;
//     }

//     public int getId() {
//         return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public String getTitle() {
//         return title;
//     }

//     public void setTitle(String title) {
//         this.title = title;
//     }

//     public String getContent() {
//         return content;
//     }

//     public void setContent(String content) {
//         this.content = content;
//     }

//    public void setPubDate(Date pubDate) {
//        this.pubDate = pubDate;
//    }

//    public Date getPubDate() {
//        return pubDate;
//    }

//     @ManyToOne
//     @JoinColumn
//     User user;

//     public void setUser(User user) {
//         this.user = user;
//     }

//     public User getUser() {
//         return user;
//     }

//     @OneToMany(mappedBy="blog", cascade = CascadeType.ALL)
//     List<Image> imageList = new ArrayList<>();

//    public void setImageList(List<Image> imageList) {
//        this.imageList = imageList;
//    }

//    public List<Image> getImageList() {
//        return imageList;
//    }
// }


package com.driver.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "blog")
public class Blog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String content;

    @CreationTimestamp
    Date pubDate;

    // child for the user
    @ManyToOne
    @JoinColumn
    User user;

    //parent for the image
    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    List<Image> imageList = new ArrayList<>();


    public Blog() {

    }

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Blog(String title, String content, Date pubDate) {
        this.title = title;
        this.content = content;
        this.pubDate = pubDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}

