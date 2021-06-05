package model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Roulette")
public class Roulette implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "on")
    private boolean on;

    @OneToMany(mappedBy = "number_bet_id")
    List<NumberBet> numberBets;

    @OneToMany(mappedBy = "color_bet_id")
    List<ColorBet> colorBets;

    public Roulette(){
    }

    public List<NumberBet> getNumberBets() {
        return numberBets;
    }

    public void setNumberBets(List<NumberBet> numberBets) {
        this.numberBets = numberBets;
    }

    public List<ColorBet> getColorBets() {
        return colorBets;
    }

    public void setColorBets(List<ColorBet> colorBets) {
        this.colorBets = colorBets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }
}
