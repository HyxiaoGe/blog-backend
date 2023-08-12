package com.hyxiao.blog.dto;

import com.hyxiao.blog.entity.BlogEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hyxiao
 * @date 12/08/2023 20:13
 * @description
 */
@Data
public class BlogDTO {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String category;
    private Date createdTime;
    private Date updatedTime;
    private int likes;
    private int favorites;
    private int comments;

    public static BlogDTO convertFrom(BlogEntity blogEntity) {
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setId(blogEntity.getId());
        blogDTO.setTitle(blogEntity.getTitle());
        blogDTO.setContent(blogEntity.getContent());
        blogDTO.setAuthor(blogEntity.getAuthor());
        blogDTO.setCategory(blogEntity.getCategory());
        blogDTO.setCreatedTime(blogEntity.getCreatedTime());
        blogDTO.setUpdatedTime(blogEntity.getUpdatedTime());
        blogDTO.setLikes(blogEntity.getLikes());
        blogDTO.setFavorites(blogEntity.getFavorites());
        blogDTO.setComments(blogEntity.getComments());
        return blogDTO;
    }

    public static List<BlogDTO> convertFrom(List<BlogEntity> blogEntities) {
        return blogEntities.stream().map(BlogDTO::convertFrom).collect(Collectors.toList());
    }

}
