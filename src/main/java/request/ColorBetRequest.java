package request;

import model.ColorBet;

import java.io.Serializable;

public class ColorBetRequest extends ColorBet implements Serializable {
    private String color;
    private double money;
    private int rouletteId;

    public ColorBetRequest(String color, double money, int rouletteId) {
        this.color = color;
        this.money = money;
        this.rouletteId = rouletteId;
    }

    public ColorBetRequest() {
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public double getMoney() {
        return money;
    }

    @Override
    public void setMoney(double money) {
        this.money = money;
    }

    public int getRouletteId() {
        return rouletteId;
    }

    public void setRouletteId(int rouletteId) {
        this.rouletteId = rouletteId;
    }
}
