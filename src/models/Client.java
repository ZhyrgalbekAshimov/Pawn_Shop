package models;

public class Client {

    private int id;
    private String name;
    private String idCard;
    private boolean isBlocked;

    public Client(String name, String idCard) {
        this.id = (int) (Math.random()*10000);
        this.name = name;
        this.idCard = idCard;
        this.isBlocked = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
