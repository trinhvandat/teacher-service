package com.example.restfullapi.repository;
import com.example.restfullapi.model.Teacher;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Repository

public class RedisCacheRepository {

    private final RedisTemplate redisTemplate;

    private final String USER_REDIS_KEY = "USER";
    private final long TIME_TO_LIVE = 500000;

    public RedisCacheRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent event) {
        List<Teacher> teachers = redisTemplate.opsForHash().values(USER_REDIS_KEY);
        System.out.println(teachers);
        for (Teacher teacher : teachers) delete(teacher.getId());
    }

    public void save(Teacher teacher){
        System.out.println("save to redis");
        redisTemplate.opsForHash().put(USER_REDIS_KEY, teacher.getId(), teacher);
        redisTemplate.expire(USER_REDIS_KEY, TIME_TO_LIVE, TimeUnit.MILLISECONDS);
    }

    public Teacher findById(int teacherId){
        System.out.println("get from redis");
        Teacher teacher = (Teacher) redisTemplate.opsForHash().get(USER_REDIS_KEY, teacherId);
        if (Objects.nonNull(teacher)){
            this.save(teacher);
        }
        return teacher;
    }

    public void delete(int userId){
        redisTemplate.opsForHash().delete(USER_REDIS_KEY, userId);
        System.out.println("delete");
    }

    public List findAll(){
        return redisTemplate.opsForHash().values(USER_REDIS_KEY);
    }
}
