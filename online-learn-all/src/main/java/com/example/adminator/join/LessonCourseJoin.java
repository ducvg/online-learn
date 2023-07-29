package com.example.adminator.join;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LessonCourseJoin {

    private int LessonID;
    private int CourseID;
    private String Title;
    private String Content;
    private String Video;
    private String Resource;

    public LessonCourseJoin(int lessonID,int courseID, String title, String content, String video, String resource) {
        LessonID = lessonID;
        Title = title;
        Content = content;
        Video = video;
        CourseID = courseID;
        Resource = resource;
    }
//    public String toString(){
//        String result = "";
//        for(int i=0; i<Courses.length;i++){
//            result += Courses[i];
//            if(i != Courses.length-1) result += ", ";
//        }
//        return result;
//    }
}
