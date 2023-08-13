package com.hyxiao.service;

import com.hyxiao.blog.dto.BlogDTO;
import com.hyxiao.blog.dto.BlogListDTO;
import com.hyxiao.blog.dto.BlogQueryDTO;
import com.hyxiao.blog.entity.BlogEntity;
import com.hyxiao.blog.repo.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public BlogListDTO getBlogsByQuery(BlogQueryDTO blogQueryDTO) {
        // 构建 Pageable 对象, 用于分页查询
        Pageable pageable = PageRequest.of(blogQueryDTO.getPage() - 1, blogQueryDTO.getPageSize());
        // 构建查询条件
        Specification<BlogEntity> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            // 根据分类查询
            if (blogQueryDTO.getCategory() != null && !"".equals(blogQueryDTO.getCategory())) {
                predicates.add(criteriaBuilder.equal(root.get("category"), blogQueryDTO.getCategory()));
            }
            // 根据关键字查询
            if (blogQueryDTO.getKeyword() != null && !"".equals(blogQueryDTO.getKeyword())) {
                predicates.add(criteriaBuilder.equal(root.get("title"), "%" + blogQueryDTO.getKeyword() + "%"));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };

        // 执行分页查询
        Page<BlogEntity> blogPage = blogRepository.findAll(specification, pageable);

        BlogListDTO blogListDTO = new BlogListDTO();
        blogListDTO.setPage(blogQueryDTO.getPage());
        blogListDTO.setRows(blogPage.map(BlogDTO::convertFrom).getContent());
        blogListDTO.setTotal(blogPage.getTotalPages());
        blogListDTO.setRecords(blogPage.getTotalElements());

        return blogListDTO;
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

