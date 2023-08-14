package com.hyxiao.comment.repo;

import com.hyxiao.comment.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Hyxiao
 * @date 14/08/2023 14:10
 * @description
 */
@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findByBlogId(Long blogId);

}

