package com.example.course.service;

import com.example.course.dto.CourseDTO;
import com.example.course.dto.QuestionDTO;
import com.example.course.dto.SubTopicDTO;
import com.example.course.dto.TopicDTO;
import com.example.course.entity.Course;
import com.example.course.entity.Questions;
import com.example.course.entity.SubTopic;
import com.example.course.entity.Topics;

public interface CourseService {
	
	public Course addCourse(CourseDTO course);
	
	public Topics addTopics(TopicDTO topics);
	
	public SubTopic addSubTopics(SubTopicDTO subTopic);
	
	public Questions addQuestions(QuestionDTO questions);

}
