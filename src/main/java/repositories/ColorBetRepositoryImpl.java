package repositories;

import model.ColorBet;
import model.NumberBet;
import model.Roulette;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ColorBetRepositoryImpl implements ColorBetRepository{
    private RedisTemplate<String, Roulette> redisTemplate;
    private HashOperations hashOperations;

    @Override
    public void save(ColorBet colorBet) {
        hashOperations.put("COLOR_BET", colorBet.getId(), colorBet);
    }

    @Override
    public List<ColorBet> findByRouletteId(int id) {
        List<ColorBet>  colorBets= new ArrayList<ColorBet>();
        Map<String, ColorBet> hashBets = this.hashOperations.entries("COLOR_BET");
        for(ColorBet cb : hashBets.values()){
            if(cb.getRoulette().getId() == id){
                colorBets.add(cb);
            }
        }
        return colorBets;
    }

}
