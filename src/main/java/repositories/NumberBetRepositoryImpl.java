package repositories;

import model.NumberBet;
import model.Roulette;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NumberBetRepositoryImpl implements NumberBetRepository{
    private RedisTemplate<String, Roulette> redisTemplate;
    private HashOperations hashOperations;

    public NumberBetRepositoryImpl(RedisTemplate<String, Roulette> redisTemplate, HashOperations hashOperations) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = hashOperations;
    }

    @Override
    public void save(NumberBet bet) {
        hashOperations.put("NUMBER_BET", bet.getId(), bet);
    }

    @Override
    public List<NumberBet> findByRouletteId(int id) {
        List<NumberBet>  numberBets= new ArrayList<NumberBet>();
        Map<String, NumberBet> hashBets = this.hashOperations.entries("NUMBER_BET");
        for(NumberBet nb : hashBets.values()){
            if(nb.getRoulette().getId() == id){
                numberBets.add(nb);
            }
        }
        return numberBets;
    }

}
