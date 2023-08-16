package com.hyxiao.blog.repo;

import com.hyxiao.blog.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Hyxiao
 * @date 12/08/2023 20:10
 * @description
 */
@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long>, JpaSpecificationExecutor<BlogEntity> { }

