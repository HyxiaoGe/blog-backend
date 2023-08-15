package com.hyxiao.blog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String description;
    private String content;
    private String author;
    private String category;
    @JsonProperty("createdTime")
    private Date createdTime;
    @JsonProperty("updatedTime")
    private Date updatedTime;
    private int views;
    private int likes;
    @JsonProperty("isLiked")
    private Boolean isLiked;
    private int comments;

    public static BlogDTO convertFrom(BlogEntity blogEntity) {
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setId(blogEntity.getId());
        blogDTO.setTitle(blogEntity.getTitle());
        blogDTO.setContent(blogEntity.getContent());
        blogDTO.setDescription(blogEntity.getDescription());
        blogDTO.setAuthor(blogEntity.getAuthor());
        blogDTO.setCategory(blogEntity.getCategory());
        blogDTO.setCreatedTime(blogEntity.getCreatedTime());
        blogDTO.setUpdatedTime(blogEntity.getUpdatedTime());
        blogDTO.setViews(blogEntity.getViews());
        blogDTO.setLikes(blogEntity.getLikes());
        blogDTO.setComments(blogEntity.getComments());
        return blogDTO;
    }

    public static List<BlogDTO> convertFrom(List<BlogEntity> blogEntities) {
        return blogEntities.stream().map(BlogDTO::convertFrom).collect(Collectors.toList());
    }

}
