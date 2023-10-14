package com.hyxiao.controller;

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
     * 获取所有博客
     * @return 博客列表
     */
    @GetMapping("/blog/{blogId}")
    public BaseResponse getCommentByBlogId(@PathVariable Long blogId) {
        log.info("blogId: {}", blogId);
        return BaseResponse.success(commentService.getCommentsByBlogId(blogId));
    }

}
