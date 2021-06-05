package repositories;

import model.Roulette;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface RouletteRepository{
    void save(Roulette roulette);
    Map<String, Roulette> findAll();
    Roulette getById(int id);
    void update(Roulette roulette);

}
