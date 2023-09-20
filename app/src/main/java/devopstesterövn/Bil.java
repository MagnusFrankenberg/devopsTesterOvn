package devopstesterövn;

public class Bil {

    private boolean isStarted;
    private Framljus framljus;
    private Bakljus bakljus;
    private VarningsBlinkers varningsBlinkers;

    private Pedaler pedaler;
    private int hastighet;

    public Bil() {
        this.isStarted = false;
        this.framljus = new Framljus();
        this.bakljus = new Bakljus();
        this.varningsBlinkers = new VarningsBlinkers();
        this.hastighet = 0;
    }

    public void setStarted(boolean started) {
        isStarted = started;
        if(started==false){
            setFramljusIsOn(false);
            setBakljusIsOn(false);
        }
    }

    public void setFramljusIsOn(boolean setOn) {
        if(this.isStarted) {
            this.framljus.setOn(setOn);
        }else {
            this.framljus.setOn(false);
        }
    }

    public void setBakljusIsOn(boolean setOn) {
        if(this.isStarted) {
            this.bakljus.setOn(setOn);
        }else {
            this.bakljus.setOn(false);
        }
    }

    public void setVarningsBlinkersIsOn(boolean setOn) {
        this.varningsBlinkers.setOn(setOn);
    }

    public boolean isStarted() {
        return isStarted;
    }

    public Framljus getFramljus() {
        return framljus;
    }

    public Bakljus getBakljus() {
        return bakljus;
    }

    public VarningsBlinkers getVarningsBlinkers() {
        return varningsBlinkers;
    }

    public void användPedal(Pedaler pedaler) {
        this.pedaler = pedaler;
        if(pedaler==Pedaler.GAS) {
            ändraHastighet(20);
        }
        if(pedaler==Pedaler.BROMS){
            ändraHastighet(-20);
        }
    }

    public Pedaler getPedaler() {
        return pedaler;
    }

    public int getHastighet() {
        return hastighet;
    }

    public void ändraHastighet(int change) {
            this.hastighet = Math.min(180, hastighet+change);
        }

}
