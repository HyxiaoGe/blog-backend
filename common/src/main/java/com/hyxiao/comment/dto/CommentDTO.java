package com.hyxiao.comment.dto;

import com.hyxiao.comment.entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
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

    private Long blogId;
    private String content;
    private Date createTime;
    private String authorUsername;
    private String authorNickname;

    public static CommentDTO convertFrom(CommentEntity commentEntity) {
        CommentDTO blogDTO = new CommentDTO();
        blogDTO.setBlogId(commentEntity.getBlogId());
        blogDTO.setContent(commentEntity.getContent());
        blogDTO.setCreateTime(commentEntity.getCreateTime());
        blogDTO.setAuthorUsername(commentEntity.getAuthorUsername());
        blogDTO.setAuthorNickname(commentEntity.getAuthorNickname());

        return blogDTO;
    }

    public static List<CommentDTO> convertFrom(List<CommentEntity> commentEntities) {
        return commentEntities.stream().map(CommentDTO::convertFrom).collect(Collectors.toList());
    }
}
