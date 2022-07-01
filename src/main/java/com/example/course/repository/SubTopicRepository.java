package com.example.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.course.entity.SubTopic;
import com.example.course.entity.Topics;

@Repository
public interface SubTopicRepository extends JpaRepository<SubTopic, Long> {

	
	@Query("select s from SubTopic s where s.subTopicName=:subTopicName")
	public SubTopic findSubTopicBySubTopicName(@Param("subTopicName") String subTopicName);
	
	@Query(value = "select * from sub_topics  where topic_id=?1" , nativeQuery = true)
	public List<SubTopic> findSubTopicByTopicId(Long topic_id);
}
