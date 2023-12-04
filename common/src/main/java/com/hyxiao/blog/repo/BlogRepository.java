package com.hyxiao.blog.repo;

import com.hyxiao.blog.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Hyxiao
 * @date 12/08/2023 20:10
 * @description
 */
@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long>, JpaSpecificationExecutor<BlogEntity> {

    @Query(value = "SELECT b.* FROM blog b ORDER BY b.views DESC limit 6", nativeQuery = true)
    List<BlogEntity> findTopBlogs();

    @Query("SELECT b.category as category, COUNT(b) as count FROM BlogEntity b GROUP BY b.category")
    List<Object[]> countTotalPostsByCategory();

}

