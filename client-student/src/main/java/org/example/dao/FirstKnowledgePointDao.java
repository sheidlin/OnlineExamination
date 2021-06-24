package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.FirstKnowledgePoint;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstKnowledgePointDao {
    int insertKnowledgePoint(FirstKnowledgePoint firstKnowledgePoint);
    int deleteKnowledgePointByKnowledgePoint(@Param("knowledgePoint") String knowledgePoint);
    FirstKnowledgePoint findKnowledgePointById(@Param("id") Integer id);
    FirstKnowledgePoint findKnowledgePointByKnowledgePoint(@Param("knowledgePoint") String knowledgePoint);
}
