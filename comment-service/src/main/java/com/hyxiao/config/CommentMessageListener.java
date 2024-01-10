package com.hyxiao.config;

import com.hyxiao.comment.dto.CommentDTO;
import com.hyxiao.comment.repo.CommentRepository;
import com.hyxiao.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CommentMessageListener {

    @Autowired
    private CommentRepository commentRepository;

    @RabbitListener(queues = RabbitMQConfig.COMMENT_QUEUE)
    public void handleMessage(String message) {
        log.info("CommentMessageListener: " + message);
        CommentDTO commentDTO = JsonUtil.toObject(message, CommentDTO.class);

        this.commentRepository.save(CommentDTO.convertTo(commentDTO));
    }

}
