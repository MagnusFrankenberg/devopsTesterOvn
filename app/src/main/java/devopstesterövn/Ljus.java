package devopstesterövn;

public class Ljus{

    protected CarStateListener carStateListener;
    protected boolean isOn;

    public Ljus(){
        this.isOn = false;
    }

    public void setCarStateListener(CarStateListener listener) {
        this.carStateListener = listener;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean bool) {
        isOn = bool;
    }
}

class Framljus extends Ljus{

    private Ljustyp ljusTyp;

    @Override
    public void setOn(boolean bool){
        if(carStateListener.carStarted()) {
            isOn=bool;
        }else {
            isOn=false;
        }
    }

    public Ljustyp getLjusTyp() {
        return ljusTyp;
    }

    public void setLjusTyp(Ljustyp ljusTyp){
        this.ljusTyp = ljusTyp;
    }
}

class Bakljus extends Ljus{
    @Override
    public void setOn(boolean bool){
        if(carStateListener.carStarted()) {
            isOn=bool;
        }else {
            isOn=false;
        }
    }
}

class VarningsBlinkers extends Ljus{
    @Override
    public void setOn(boolean bool){
            isOn=bool;
    }
}