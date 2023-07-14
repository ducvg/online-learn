package com.example.adminator.Join;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CourseUserCategoryJoin {
    private int CourseID;
    private String Title;
    private String Thumbnail;
    private String Description;
    private String[] Experts;
    private String Category;

    public CourseUserCategoryJoin(int courseID, String title, String thumbnail, String description, String[] experts, String category) {
        CourseID = courseID;
        Title = title;
        Thumbnail = thumbnail;
        Description = description;
        Experts = experts;
        Category = category;
    }

    @Override
    public String toString(){
        String result = "";
        for(int i=0; i<Experts.length;i++){
            result += Experts[i];
            if(i != Experts.length-1) result += ", ";
        }
        return result;
    }
}
