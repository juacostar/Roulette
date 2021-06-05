package request;

import model.User;

import java.io.Serializable;

public class UserRequest extends User implements Serializable {
    private String username;
    private String password;
    private double money;

    public UserRequest(String username, String password, double money) {
        this.username = username;
        this.password = password;
        this.money = money;
    }

    public UserRequest() {
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public double getMoney() {
        return money;
    }

    @Override
    public void setMoney(double money) {
        this.money = money;
    }
}
