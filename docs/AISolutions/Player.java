package mancala;

public class Player {
    private String name;
    private Store store;

    public Player() {
        name = "Player";
        store = new Store();
    }

    public Player(String nameP) {
        this.name = nameP;
        store = new Store();
    }

    public String getName() {
        return name;
    }

    public void setName(String nameP) {
        this.name = nameP;
    }

    public Store getStore() {
        return store;
    }

    public int getStoreCount() {
        return store.getTotalStones();
    }

    public void setStore(Store storeP){
        this.store = storeP;
    }

    public String toString(){
        return name;
    }

}
