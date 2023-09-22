package devopstesterövn;

public class Batteri{



    protected CarCentralAccessor carAccessor;
    private int batteriNivå;


    public Batteri(int batteriNivå) {
        this.batteriNivå = batteriNivå;
    }

    public void setCarAccessor(CarCentralAccessor carAccessor) {
        this.carAccessor = carAccessor;
    }

    public int getBatteriNivå() {
        return batteriNivå;
    }

    public void setBatteriNivå(int batteriNivå) {
        this.batteriNivå = Math.max(Math.min(batteriNivå,100),0);
        if(this.batteriNivå==0){
            carAccessor.swithOffAllLamps();
        }
    }

    public boolean ärSlut(){
        return batteriNivå==0;
    }

}
