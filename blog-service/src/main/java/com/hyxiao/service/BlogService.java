package com.hyxiao.service;

import com.hyxiao.blog.dto.BlogDTO;
import com.hyxiao.blog.dto.BlogQueryDTO;
import com.hyxiao.blog.entity.BlogEntity;
import com.hyxiao.blog.repo.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Hyxiao
 * @date 12/08/2023 20:11
 * @description
 */
@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    /**
     * 获取所有博客
     * @return 博客列表
     */
    public Page<BlogDTO> getBlogsByQuery(BlogQueryDTO blogQueryDTO) {
//        Pageable pageable = PageRequest.of(blogQueryDTO.getPage() - 1, blogQueryDTO.getPageSize());

        return null;

//        return BlogDTO.convertFrom(blogs);
    }

    /**
     * 根据id获取博客
     * @param id
     * @return 博客
     */
    public BlogDTO getBlogById(Long id) {
        BlogEntity blog = blogRepository.findById(id).orElse(null);
        assert blog != null;
        return BlogDTO.convertFrom(blog);
    }

    /**
     * 创建博客
     * @param blog
     */
    public void createBlog(BlogDTO blog) {
        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setTitle(blog.getTitle());
        blogEntity.setAuthor(blog.getAuthor());
        blogEntity.setCategory(blog.getCategory());
        blogEntity.setCreatedTime(new Date());
        blogEntity.setUpdatedTime(new Date());
        blogEntity.setLikes(blog.getLikes());
        blogEntity.setFavorites(blog.getFavorites());
        blogEntity.setComments(blog.getComments());
        this.blogRepository.save(blogEntity);
    }

    /**
     * 更新博客
     * @param blog
     */
    public void updateBlog(BlogDTO blog) {
        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setId(blog.getId());
        blogEntity.setTitle(blog.getTitle());
        blogEntity.setAuthor(blog.getAuthor());
        blogEntity.setCategory(blog.getCategory());
        blogEntity.setCreatedTime(blog.getCreatedTime());
        blogEntity.setUpdatedTime(blog.getUpdatedTime());
        blogEntity.setLikes(blog.getLikes());
        blogEntity.setFavorites(blog.getFavorites());
        blogEntity.setComments(blog.getComments());
        this.blogRepository.save(blogEntity);
    }

    /**
     * 删除博客
     * @param id
     */
    public void deleteBlog(Long id) {
        this.blogRepository.deleteById(id);
    }

}

