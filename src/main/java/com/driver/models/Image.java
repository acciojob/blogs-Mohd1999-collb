// package com.driver.models;

// import javax.persistence.*;

// @Entity
// @Table(name = "image")
// public class Image{
//     public Image(){}

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "id")
//     private int id;

//     @Column(name = "dimensions")
//     private String dimensions;

//     @Column(name = "description")
//     private String description;


//     public Image(String dimensions, String description) {
//         this.dimensions = dimensions;
//         this.description = description;
//     }

//     public int getId() {
//         return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public String getDimensions() {
//         return dimensions;
//     }

//     public void setDimensions(String dimensions) {
//         this.dimensions = dimensions;
//     }

//     public String getDescription() {
//         return description;
//     }

//     public void setDescription(String description) {
//         this.description = description;
//     }

//     @ManyToOne
//     @JoinColumn
//     Blog blog;

//     public Blog getBlog() {
//         return blog;
//     }

//     public void setBlog(Blog blog) {
//         this.blog = blog;
//     }
// }

package com.driver.models;



import javax.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private  String description;

    private String dimensions;


    // child for the blog
    @ManyToOne
    @JoinColumn
    Blog blog;

    public Image() {

    }

    public Image(String description, String dimensions) {
        this.description = description;
        this.dimensions = dimensions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
