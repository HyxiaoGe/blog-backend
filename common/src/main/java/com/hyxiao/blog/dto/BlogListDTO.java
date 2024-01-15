package com.hyxiao.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Hyxiao
 * @date 13/08/2023 01:21
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogListDTO {

    private int page;            // 当前页数
    private long total;            // 总记录数
    private List<?> rows;        // 每行显示的内容

}

