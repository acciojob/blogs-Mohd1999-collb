package com.driver.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import  java.util.*;

@Entity
@Table(name = "blog")

public class Blog{
    public Blog(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    @CreationTimestamp
    private Date pubDate;

    // public Blog(String title, String content) {
    //     this.title = title;
    //     this.content = content;
    // }

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

   public void setPubDate(Date pubDate) {
       this.pubDate = pubDate;
   }

   public Date getPubDate() {
       return pubDate;
   }

    @ManyToOne
    @JoinColumn
    User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @OneToMany(mappedBy="blog", cascade = CascadeType.ALL)
    List<Image> imageList = new ArrayList<>();

   public void setImageList(List<Image> imageList) {
       this.imageList = imageList;
   }

   public List<Image> getImageList() {
       return imageList;
   }
}