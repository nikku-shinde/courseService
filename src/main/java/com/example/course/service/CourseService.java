package com.example.course.service;

import java.util.List;

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
	
	public List<Course> getCourse();
	
	public List<Topics> getTopics();
	
	public List<SubTopic> getSubTopics();
	
	public List<Questions> getQuestions();
	
	public List<Topics> getTopicByCourseId(Long courseId);
	
	public List<SubTopic> getSubTopicByTopicId(Long topicId);
	
	public List<Questions> getQuestionsBySubTopicId(Long subTopicId);

}
