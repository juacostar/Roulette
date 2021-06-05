package repositories;

import model.Roulette;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface RouletteRepository{
    Roulette save(Roulette roulette);
    Map<String, Roulette> findAll();
    Roulette findById(int id);
    void update(Roulette roulette);

}
