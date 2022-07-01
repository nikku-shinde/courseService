package com.example.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.dto.CourseDTO;
import com.example.course.entity.Course;
import com.example.course.entity.Questions;
import com.example.course.entity.SubTopic;
import com.example.course.entity.Topics;
import com.example.course.repository.CourseRepository;
import com.example.course.repository.QuestionRepository;
import com.example.course.repository.SubTopicRepository;
import com.example.course.repository.TopicRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private TopicRepository topicRepo;
	
	@Autowired
	private SubTopicRepository subTopicRepo;
	
	@Autowired
	private QuestionRepository questionRepo;

	@Override
	public Course addCourse(CourseDTO course) {
		Course courseData = new Course();
		courseData.setCourseName(course.getCourseName());
		courseData.setAuthorId(course.getAuthorId());
		courseData.setMentorId(course.getMentorId());
		return this.courseRepo.save(courseData);
	}

	@Override
	public Topics addTopics(Topics topics) {
		Course course = this.courseRepo.findCourseByCourseName(topics.getCourse().getCourseName());
		topics.setCourse(course);
		return this.topicRepo.save(topics);
	}

	@Override
	public SubTopic addSubTopics(SubTopic subTopic) {
		Topics topics = this.topicRepo.findTopicByTopicName(subTopic.getTopic().getTopicName());
		subTopic.setTopic(topics);
		return this.subTopicRepo.save(subTopic);
	}

	@Override
	public Questions addQuestions(Questions questions) {
		SubTopic subTopic = this.subTopicRepo.findSubTopicBySubTopicName(questions.getSubTopic().getSubTopicName());
		questions.setSubTopic(subTopic);
		return this.questionRepo.save(questions);
	}
}
