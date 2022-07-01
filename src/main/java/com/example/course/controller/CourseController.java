package com.example.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.example.course.service.CourseService;
import com.example.course.util.Constants;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private TopicRepository topicRepo;
	
	@Autowired
	private SubTopicRepository subTopicRepo;
	
	@Autowired
	private QuestionRepository questionRepo;
	
	
	@PostMapping("/add-course")
	public ResponseEntity<Object> addCourse(@RequestBody CourseDTO course) {
		List<Course> courseList = this.courseRepo.findAll();
		try {
			for(Course courseData : courseList) {
				if(courseData.getCourseName().equalsIgnoreCase(course.getCourseName())) {
					return ResponseEntity.ok(new Exception(Constants.COURSE_ALREADY_ADDED));
				}else {
					return ResponseEntity.ok(this.courseService.addCourse(course));
				}
			}
			return ResponseEntity.ok(Constants.COURSE_ALREADY_ADDED);
		} catch (Exception e) {
			return ResponseEntity.ok(new Exception(Constants.COURSE_ALREADY_ADDED));
		}
	}
	
	@PostMapping("/add-topics")
	public ResponseEntity<Object> addTopics(@RequestBody TopicDTO topics) {
		List<Topics> topicList = this.topicRepo.findAll();
		try {
			for(Topics topic : topicList) {
				if(topic.getTopicName().equalsIgnoreCase(topics.getTopicName())) {
					return ResponseEntity.ok(new Exception(Constants.TOPIC_ALREADY_ADDED));
				}else {
					return ResponseEntity.ok(this.courseService.addTopics(topics));
				}
			}
			return ResponseEntity.ok(new Exception(Constants.TOPIC_ALREADY_ADDED));
		} catch (Exception e) {
			return ResponseEntity.ok(new Exception(Constants.TOPIC_ALREADY_ADDED));
		}
	}
	
	@PostMapping("/add-sub_topics")
	public ResponseEntity<Object> addSubTopics(@RequestBody SubTopicDTO subTopic) {
		List<SubTopic> subTopicList = this.subTopicRepo.findAll();
		try {
			for(SubTopic subTopicData : subTopicList) {
				if(subTopicData.getSubTopicName().equalsIgnoreCase(subTopic.getSubTopicName())) {
					return ResponseEntity.ok(new Exception(Constants.SUBTOPIC_ALREADY_ADDED));
				}else {
					return ResponseEntity.ok(this.courseService.addSubTopics(subTopic));
				}
			}
			return ResponseEntity.ok(new Exception(Constants.SUBTOPIC_ALREADY_ADDED));
		} catch (Exception e) {
			return ResponseEntity.ok(new Exception(Constants.SUBTOPIC_ALREADY_ADDED));
		}
	}
	
	@PostMapping("/add-questions")
	public ResponseEntity<Object> addQuestions(@RequestBody QuestionDTO questions) {
		List<Questions> questionList = this.questionRepo.findAll();
		try {
			for(Questions questionData : questionList) {
				if (questionData.getQuestion().equalsIgnoreCase(questions.getQuestion())) {
					return ResponseEntity.ok(new Exception(Constants.QUESTION_ALREADY_ADDED));
				} else {
					return ResponseEntity.ok( this.courseService.addQuestions(questions));
				}
			}
			return ResponseEntity.ok(new Exception(Constants.QUESTION_ALREADY_ADDED));
		} catch (Exception e) {
			return ResponseEntity.ok(new Exception(Constants.QUESTION_ALREADY_ADDED));
		}
	}
	
	@GetMapping("/getCourseNames")
	public List<Course> getCourseNames() {
		return this.courseRepo.findAll();
	}
	
	@GetMapping("/getTopics")
	public List<Topics> getTopics() {
		return this.topicRepo.findAll();
	}
	
	@GetMapping("/getSubTopics")
	public List<SubTopic> getSubTopics() {
		return this.subTopicRepo.findAll();
	}
	
	@GetMapping("/getQuestions")
	public List<Questions> getQuestions() {
		return this.questionRepo.findAll();
	}
	
	@GetMapping("/getTopicsById/{courseId}")
	public List<Topics> getTopicByCourseId(@PathVariable("courseId") Long courseId) {
		return this.topicRepo.findTopicByCourseId(courseId);
	}
	
	@GetMapping("/getSubTopicsById/{topicId}")
	public List<SubTopic> getSubTopicByTopicId(@PathVariable("topicId") Long topicId) {
		return this.subTopicRepo.findSubTopicByTopicId(topicId);
	}
	
	@GetMapping("/getQuestionsById/{subTopicId}")
	public List<Questions> getQuestionsBySubTopicId(@PathVariable("subTopicId") Long subTopicId) {
		return this.questionRepo.findQuestionsBySubTopicId(subTopicId);
	}

}
