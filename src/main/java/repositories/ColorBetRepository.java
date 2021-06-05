package repositories;

import model.ColorBet;

import java.util.List;

public interface ColorBetRepository {
    void save(ColorBet colorBet);
    List<ColorBet> findByRouletteId(int id);
}
