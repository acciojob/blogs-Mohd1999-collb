package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time

        // Optional<User> userOpt = userRepository1.findById(userId);
        // User user = userOpt.get();

        // Blog blog = new Blog(title, content);
        // blog.setUser(user);

        // List<Blog> bloglList = user.getBlogList();

        // bloglList.add(blog);
        // user.setBlogList(bloglList);

        // User savedUser = userRepository1.save(user);

        // Blog savedBlog = savedUser.getBlogList().get(savedUser.getBlogList().size()-1);
        // return savedBlog;

        Optional<User> optionalUser = userRepository1.findById(userId);
        User user = optionalUser.get();

        Blog blog = new Blog(title, content);
        blog.setUser(user);

        List<Blog> blogList= user.getBlogList();
        blogList.add(blog);
        user.setBlogList(blogList);

        User savedUser = userRepository1.save(user);

        Blog savedBlog = savedUser.getBlogList().get(savedUser.getBlogList().size() -1);

        return savedBlog;
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        blogRepository1.deleteById(blogId);
    }
}
