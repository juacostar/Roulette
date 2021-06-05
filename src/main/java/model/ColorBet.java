package model;

import javax.persistence.*;

@Entity
@Table(name = "ColorBet")
public class ColorBet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "color")
    private String color;

    @Column(name = "money")
    private double money;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id")
    private Roulette roulette;

    public ColorBet() {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public boolean bet() {
        if(this.color.equals("rojo")){
            int n = (int)(Math.random() * (36));
            if(n % 2 == 0) return true;
            return false;
        }else if(this.color.equals("negro")){
            int n = (int)(Math.random() * (36));
            if(n % 2 != 0) return true;
            return false;
        }
        return false;
    }
}
