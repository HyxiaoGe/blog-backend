package com.hyxiao.controller;

import com.hyxiao.comment.dto.CommentDTO;
import com.hyxiao.response.BaseResponse;
import com.hyxiao.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Hyxiao
 * @date 12/08/2023 20:21
 * @description
 */
@RestController
@RequestMapping("/comment")
@Slf4j
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 获取博客下的所有评论
     * @return 评论列表
     */
    @GetMapping("/blog_comment/{blogId}")
    public BaseResponse getBlogComment(@PathVariable Long blogId) {
        log.info("blogId: {}", blogId);
        return BaseResponse.success(commentService.getCommentsByBlogId(blogId));
    }

    @PostMapping("")
    public BaseResponse addComment(@RequestBody CommentDTO commentDTO) {
        Long blogId = commentDTO.getBlogId();
        String content = commentDTO.getContent();
        log.info("blogId: {}, content: {}", blogId, content);
        commentService.addComment(blogId, content);

        return BaseResponse.success();
    }

}
