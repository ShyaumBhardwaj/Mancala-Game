package mancala;

public class Player {
    private String nameP;
    private Store storeP;

    public Player() {
        nameP = "Player";
        storeP = new Store();
    }

    public Player(String name) {
        this.nameP = name;
        storeP = new Store();
    }

    public String getName() {
        return nameP;
    }

    public void setName(String name) {
        this.nameP = name;
    }

    public Store getStore() {
        return storeP;
    }

    public int getStoreCount() {
        return storeP.getTotalStones();
    }

    public void setStore(Store store){
        this.storeP = store;
    }

    public String toString(){
        return nameP;
    }

}
