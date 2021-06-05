package repositories;

import model.NumberBet;

import java.util.List;

public interface NumberBetRepository {
    void save(NumberBet bet);
    List<NumberBet> findByRouletteId(int id);
}
