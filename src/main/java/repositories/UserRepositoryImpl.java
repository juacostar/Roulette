package repositories;


import model.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

public class UserRepositoryImpl implements UserRepository {
    private RedisTemplate<String, User> redisTemplate;

    private HashOperations hashOperations;

    public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }
    @Override
    public void save(User user) {
        hashOperations.put("USER", user.getId(), user);
    }

    @Override
    public void update(User user) {
        save(user);
    }

    @Override
    public User findById(int id) {
        return (User)hashOperations.get("USER", id);
    }
}
