package com.hyxiao.Task;

import com.hyxiao.blog.entity.BlogEntity;
import com.hyxiao.blog.repo.BlogRepository;
import com.hyxiao.utils.RedisOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Slf4j
@EnableScheduling
public class ScheduledTasks {

    @Autowired
    private RedisOperator redisOperator;

    @Autowired
    private BlogRepository blogRepository;

    @Scheduled(cron = "0 0 * * * ?")
    public void syncBlogInfos() {
        log.info("syncBlogInfos...");
        Set<String> keys = redisOperator.keys("blog:viewcount:*");
        if (keys != null && !keys.isEmpty()) {
            for (String key : keys) {
                int viewCount = Integer.parseInt(redisOperator.get(key));
                Long blogId = Long.valueOf(key.split(":")[2]);
                BlogEntity blogEntity = blogRepository.findById(blogId).orElse(null);
                if (blogEntity != null){
                    int difference = viewCount - blogEntity.getViews();
                    if (difference > 0) {
                        blogEntity.setViews(viewCount);
                        blogRepository.save(blogEntity);
                    }
                }
            }
        }
    }

}
