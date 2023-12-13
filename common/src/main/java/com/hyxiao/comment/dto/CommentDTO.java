package com.hyxiao.comment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hyxiao.comment.entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Hyxiao
 * @date 14/08/2023 13:58
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {

    private Long id;
    @JsonProperty("blogId")
    private Long blogId;
    private String content;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("createdTime")
    private Date createdTime;

    public CommentDTO(Long blogId, String content) {
        this.blogId = blogId;
        this.content = content;
    }

    public static CommentDTO convertFrom(CommentEntity commentEntity) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(commentEntity.getId());
        commentDTO.setBlogId(commentEntity.getBlogId());
        commentDTO.setContent(commentEntity.getContent());
        commentDTO.setUserName(commentEntity.getUserName());
        commentDTO.setCreatedTime(commentEntity.getCreatedTime());
        return commentDTO;
    }

    public static List<CommentDTO> convertFrom(List<CommentEntity> commentEntities) {
        return commentEntities.stream().map(CommentDTO::convertFrom).collect(Collectors.toList());
    }

    public static CommentEntity convertTo(CommentDTO commentDTO) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setBlogId(commentDTO.getBlogId());
        commentEntity.setContent(commentDTO.getContent());
        String userName = "游客" + new Random().nextInt(999999);
        commentEntity.setUserName(userName);
        commentEntity.setCreatedTime(new Date());

        return commentEntity;
    }
}
