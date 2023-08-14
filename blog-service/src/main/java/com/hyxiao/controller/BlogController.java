package com.hyxiao.controller;

import com.hyxiao.blog.dto.BlogDTO;
import com.hyxiao.blog.dto.BlogListDTO;
import com.hyxiao.blog.dto.BlogQueryDTO;
import com.hyxiao.response.BaseResponse;
import com.hyxiao.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Hyxiao
 * @date 12/08/2023 20:21
 * @description
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    /**
     * 获取所有博客
     * @return 博客列表
     */
    @GetMapping("/list")
    public BaseResponse list(
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String keyword
    ) {

        BlogQueryDTO blogQueryDTO = new BlogQueryDTO();
        blogQueryDTO.setPage(page);
        blogQueryDTO.setPageSize(pageSize);
        blogQueryDTO.setCategory(category);
        blogQueryDTO.setKeyword(keyword);

        BlogListDTO blogs = blogService.getBlogsByQuery(blogQueryDTO);
        return BaseResponse.success(blogs);
    }

    /**
     * 根据博客id获取博客
     * @param id
     * @return 博客
     */
    @GetMapping("/{id}")
    public BaseResponse getBlogById(@PathVariable Long id) {
        BlogDTO blog = blogService.getBlogById(id);
        return BaseResponse.success(blog);
    }

    /**
     * 创建博客
     * @param blog
     * @return
     */
    @PostMapping("/create")
    public BaseResponse createBlog(@RequestBody BlogDTO blog) {
        blogService.createBlog(blog);
        return BaseResponse.success();
    }

    /**
     * 修改博客
     * @param blog
     * @return
     */
    @PutMapping("/update")
    public BaseResponse updateBlog(@RequestBody BlogDTO blog) {
        blogService.updateBlog(blog);
        return BaseResponse.success();
    }

    /**
     * 删除博客
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public BaseResponse deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return BaseResponse.success();
    }

}
