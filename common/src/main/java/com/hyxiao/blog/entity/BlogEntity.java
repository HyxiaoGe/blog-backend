package com.hyxiao.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Hyxiao
 * @date 12/08/2023 20:00
 * @description
 */
@Entity
@Data
@Table(name = "blog")
public class BlogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(columnDefinition = "TEXT")
    private String content;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String category;
    @Column(name = "created_time", nullable = false)
    private Date createdTime;
    @Column(name = "updated_time", nullable = false)
    private Date updatedTime;
    @Column(nullable = false)
    private int views;
    @Column(nullable = false)
    private int likes;
    @Column(nullable = false)
    private int comments;

}

