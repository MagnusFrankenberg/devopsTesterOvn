package devopstesterövn;

public class Batteri {

  //  protected CarStateListener carStateListener;
    private int batteriNivå;


    public Batteri(int batteriNivå) {
        this.batteriNivå = batteriNivå;
    }

    public int getBatteriNivå() {
        return batteriNivå;
    }

    public void setBatteriNivå(int batteriNivå) {
        this.batteriNivå = Math.min(batteriNivå,100);
    }
}
