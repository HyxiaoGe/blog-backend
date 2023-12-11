package com.hyxiao.comment.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Hyxiao
 * @date 14/08/2023 13:51
 * @description
 */
@Entity
@Data
@Table(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "blog_id", nullable = false)
    private Long blogId;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "created_time", nullable = false)
    private Date createTime;
    @Column(name = "user_name", nullable = false)
    private String username;

}
