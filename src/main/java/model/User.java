package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "User")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "money")
    private double money;

    @OneToMany(mappedBy = "number_bet_id")
    List<NumberBet> numberBets;

    @OneToMany(mappedBy = "color_bet_id")
    List<ColorBet> colorBets;

    public User() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
