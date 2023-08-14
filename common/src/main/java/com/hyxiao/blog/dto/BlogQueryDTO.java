package com.hyxiao.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Hyxiao
 * @date 12/08/2023 21:03
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogQueryDTO {
    private Integer page;
    private Integer pageSize;
    private String category;
    private String keyword;
}
