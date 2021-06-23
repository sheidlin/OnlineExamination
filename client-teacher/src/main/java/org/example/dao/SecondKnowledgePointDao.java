package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.SecondKnowledgePoint;

public interface SecondKnowledgePointDao {
    int insertKnowledgePoint(SecondKnowledgePoint secondKnowledgePoint);
    int deleteKnowledgePointByKnowledgePoint(@Param("knowledgePoint") String knowledgePoint);
    SecondKnowledgePoint findKnowledgePointById(@Param("id") Integer id);
    SecondKnowledgePoint findKnowledgePointByKnowledgePoint(@Param("knowledgePoint") String knowledgePoint);
    SecondKnowledgePoint findKnowledgePointByKnowledgePointAndFirstPointId
            (@Param("firstKnowledgePointId") Integer firstPointId, @Param("knowledgePoint") String knowledgePoint);
}
