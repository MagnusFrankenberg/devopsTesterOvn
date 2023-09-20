package devopstesterövn;

public class Ljus{

    private boolean isOn;

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}

class Framljus extends Ljus{

    private Ljustyp ljusTyp;

    public Ljustyp getLjusTyp() {
        return ljusTyp;
    }

    public void setLjusTyp(Ljustyp ljusTyp){
        this.ljusTyp = ljusTyp;
    }
}

class Bakljus extends Ljus{

}

class VarningsBlinkers extends Ljus{

}