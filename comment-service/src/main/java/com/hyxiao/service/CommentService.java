package com.hyxiao.service;

import com.hyxiao.comment.dto.CommentDTO;
import com.hyxiao.comment.entity.CommentEntity;
import com.hyxiao.comment.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hyxiao
 * @date 12/08/2023 20:11
 * @description
 */
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<CommentDTO> getCommentsByBlogId(Long blogId) {
        List<CommentEntity> commentEntities = commentRepository.findByBlogId(blogId);
        return CommentDTO.convertFrom(commentEntities);
    }

}

