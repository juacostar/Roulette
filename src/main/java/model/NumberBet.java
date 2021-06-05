package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "NumberBet")
public class NumberBet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "number")
    private  int number;

    @Column(name = "money")
    private double money;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id")
    private Roulette roulette;

    public NumberBet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public boolean bet() {
        int n = (int)(Math.random() * (36));
        if(n == this.number) return true;
        return false;
    }
}
