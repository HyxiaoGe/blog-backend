package com.hyxiao.blog.repo;

import com.hyxiao.blog.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Hyxiao
 * @date 12/08/2023 20:10
 * @description
 */
@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long> {
    // 自定义查询方法，比如按分类查询、按标题模糊查询等
}

