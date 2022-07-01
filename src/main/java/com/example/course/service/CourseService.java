package com.example.course.service;

import com.example.course.entity.Course;
import com.example.course.entity.Questions;
import com.example.course.entity.SubTopic;
import com.example.course.entity.Topics;

public interface CourseService {
	
	public Course addCourse(Course course);
	
	public Topics addTopics(Topics topics);
	
	public SubTopic addSubTopics(SubTopic subTopic);
	
	public Questions addQuestions(Questions questions);

}
