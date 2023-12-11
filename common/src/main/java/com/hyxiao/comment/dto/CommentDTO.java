package com.hyxiao.comment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hyxiao.comment.entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
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

    @JsonProperty("blogId")
    private Long blogId;
    private String content;

    public static CommentDTO convertFrom(CommentEntity commentEntity) {
        CommentDTO blogDTO = new CommentDTO();
        blogDTO.setBlogId(commentEntity.getBlogId());
        blogDTO.setContent(commentEntity.getContent());

        return blogDTO;
    }

    public static List<CommentDTO> convertFrom(List<CommentEntity> commentEntities) {
        return commentEntities.stream().map(CommentDTO::convertFrom).collect(Collectors.toList());
    }
}
