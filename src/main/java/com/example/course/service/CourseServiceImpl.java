package com.example.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.dto.CourseDTO;
import com.example.course.dto.QuestionDTO;
import com.example.course.dto.SubTopicDTO;
import com.example.course.dto.TopicDTO;
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
	public Topics addTopics(TopicDTO topics) {
		Topics topic = new Topics();
		Course course = this.courseRepo.findCourseByCourseName(topics.getCourse().getCourseName());
		topic.setTopicName(topics.getTopicName());
		topic.setCourse(course);
		return this.topicRepo.save(topic);
	}

	@Override
	public SubTopic addSubTopics(SubTopicDTO subTopic) {
		SubTopic subTopicData = new SubTopic();
		Topics topics = this.topicRepo.findTopicByTopicName(subTopic.getTopic().getTopicName());
		subTopicData.setSubTopicName(subTopic.getSubTopicName());
		subTopicData.setTopic(topics);
		return this.subTopicRepo.save(subTopicData);
	}

	@Override
	public Questions addQuestions(QuestionDTO questions) {
		Questions questionData = new Questions();
		SubTopic subTopic = this.subTopicRepo.findSubTopicBySubTopicName(questions.getSubTopic().getSubTopicName());
		questionData.setQuestion(questions.getQuestion());
		questionData.setSubTopic(subTopic);
		return this.questionRepo.save(questionData);
	}

	@Override
	public List<Course> getCourse() {
		return this.courseRepo.findAll();
	}

	@Override
	public List<Topics> getTopics() {
		return this.topicRepo.findAll();
	}

	@Override
	public List<SubTopic> getSubTopics() {
		return this.subTopicRepo.findAll();
	}

	@Override
	public List<Questions> getQuestions() {
		return this.questionRepo.findAll();
	}

	@Override
	public List<Topics> getTopicByCourseId(Long courseId) {
		return this.topicRepo.findTopicByCourseId(courseId);
	}

	@Override
	public List<SubTopic> getSubTopicByTopicId(Long topicId) {
		return this.subTopicRepo.findSubTopicByTopicId(topicId);
	}

	@Override
	public List<Questions> getQuestionsBySubTopicId(Long subTopicId) {
		return this.questionRepo.findQuestionsBySubTopicId(subTopicId);
	}
}
