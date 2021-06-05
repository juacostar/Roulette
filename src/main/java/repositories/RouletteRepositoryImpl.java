package repositories;

import model.Roulette;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

public class RouletteRepositoryImpl implements RouletteRepository{
    private RedisTemplate<String, Roulette> redisTemplate;

    private HashOperations hashOperations;

    public RouletteRepositoryImpl(RedisTemplate<String, Roulette> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Roulette save(Roulette roulette){
        hashOperations.put("ROULETTE", roulette.getId(), roulette);
        return  roulette;
    }

    @Override
    public Map<String, Roulette> findAll() {
        return  hashOperations.entries("ROULETTE");
    }

    @Override
    public Roulette findById(int id) {
        return (Roulette)hashOperations.get("ROULETTE", id);
    }

    @Override
    public void update(Roulette roulette) {
        save(roulette);
    }
}
