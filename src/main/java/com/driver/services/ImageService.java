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

        Optional<Blog> optionalBlog = blogRepository2.findById(blogId);

        Blog blog = optionalBlog.get();

        Image image = new Image(description,dimensions);
        image.setBlog(blog);

        List<Image> imageList = blog.getImageList();
        imageList.add(image); // Update the image list
        blogRepository2.save(blog);

        return image;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }


    public int countImagesInScreen(Integer imageId, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`

        // Optional<Image> optionalImage = imageRepository2.findById(imageId);

        // Image image = optionalImage.get();

        // String dimension = image.getDimensions();

        // // change the screen dimension to the Integers value
        // String str[] = screenDimensions.split("X");

        // int heightScreen = Integer.valueOf(str[0]);
        // int widthScreen = Integer.valueOf(str[1]);

        // // change the current Image dimension to the Integers value
        // String strImage[] = dimension.split("X");

        // int heightImage = Integer.valueOf(strImage[0]);
        // int widthImage = Integer.valueOf(strImage[1]);


        // int heightRatio = heightScreen/heightImage;
        // int widthRatio = widthScreen/widthImage;


        // int count = heightRatio * widthRatio;

        // return count;

        Optional<Image> imageOpt = imageRepository2.findById(imageId);
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
