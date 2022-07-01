package com.example.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.course.entity.Questions;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Long> {

	@Query(value = "select * from question  where sub_topic_id=?1" , nativeQuery = true)
	public List<Questions> findQuestionsBySubTopicId(Long sub_topic_id);
}
