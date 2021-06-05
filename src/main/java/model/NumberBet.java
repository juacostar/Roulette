package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "NumberBet")
public class NumberBet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number_bet_id")
    private int id;

    @Column(name = "number")
    private  int number;

    @Column(name = "money")
    private int money;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id")
    private Roulette roulette;

    public NumberBet() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Roulette getRoulette() {
        return roulette;
    }

    public void setRoulette(Roulette roulette) {
        this.roulette = roulette;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
