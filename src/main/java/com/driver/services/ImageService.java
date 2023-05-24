package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Optional<Blog> blogOpt = blogRepository2.findById(blogId);
        Blog blog = blogOpt.get();

        Image image = new Image(description, dimensions);
        image.setBlog(blog);

        Blog savedBlog = blogRepository2.save(blog);

        Image savedImage = savedBlog.getImagelList().get(savedBlog.getImagelList().size()-1);
        return savedImage;   

    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Optional<Image> imageOpt = imageRepository2.findById(id);
        Image image = imageOpt.get();

        /*Image dimension --> 2*2 and screen dimension --> 4*4 */
        String imagedimension = image.getDimensions();

        String [] imageArr = imagedimension.split("X");

        String [] screenArr = screenDimensions.split("X");

        int screenArea = Integer.parseInt(screenArr[0]) * Integer.parseInt(screenArr[1]);
        int imageArea = Integer.parseInt(imageArr[0]) * Integer.parseInt(imageArr[1]);

        return screenArea/imageArea;

    }
}
