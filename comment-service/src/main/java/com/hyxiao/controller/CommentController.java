package com.hyxiao.controller;

import com.hyxiao.response.BaseResponse;
import com.hyxiao.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Hyxiao
 * @date 12/08/2023 20:21
 * @description
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 获取所有博客
     * @return 博客列表
     */
    @GetMapping("/blogId={blogId}")
    public BaseResponse getCommentByBlogId(@PathVariable Long blogId) {

        return BaseResponse.success();
    }

}
