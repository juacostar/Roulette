package request;

import model.NumberBet;

import java.io.Serializable;

public class NumberBetRequest extends NumberBet implements Serializable {
    private int number;
    private double money;
    private int rouletteId;

    public NumberBetRequest(int number, double money, int rouletteId) {
        this.number = number;
        this.money = money;
        this.rouletteId = rouletteId;
    }

    public NumberBetRequest() {
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
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
        this.rouletteId = NumberBetRequest.this.rouletteId;
    }
}
