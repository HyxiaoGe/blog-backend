package com.hyxiao.service;

import com.hyxiao.comment.dto.CommentDTO;
import com.hyxiao.comment.entity.CommentEntity;
import com.hyxiao.comment.repo.CommentRepository;
import com.hyxiao.config.RabbitMQConfig;
import com.hyxiao.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hyxiao
 * @date 12/08/2023 20:11
 * @description
 */
@Service
@Slf4j
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public List<CommentDTO> getCommentsByBlogId(Long blogId) {
        List<CommentEntity> commentEntities = commentRepository.findByBlogId(blogId);
        return CommentDTO.convertFrom(commentEntities);
    }

    public void addComment(Long blogId, String content) {
        CommentDTO commentDTO = new CommentDTO(blogId, content);
        String message = JsonUtil.toJson(commentDTO);

        rabbitTemplate.convertAndSend(RabbitMQConfig.COMMENT_EXCHANGE, RabbitMQConfig.COMMENT_KEY, message);
    }
}

