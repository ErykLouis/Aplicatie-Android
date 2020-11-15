package com.example.app_in_51;

import java.io.Serializable;

public class ArtObjectAd implements Serializable {
    private String title;
    private String imageName;
    private String description;

    public ArtObjectAd(String title, String imageName, String description){
        this.title=title;
        this.description=description;
        this.imageName = imageName;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
