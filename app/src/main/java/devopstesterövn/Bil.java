package devopstesterövn;

public class Bil implements CarStateListener{

    private boolean isStarted;
    private Framljus framljus;
    private Bakljus bakljus;
    private VarningsBlinkers varningsBlinkers;

    private Pedaler pedaler;
    private int hastighet;
    private Riktning riktning;

    public Riktning getRiktning() {
        return riktning;
    }



    public Bil() {
        this.isStarted = false;

       this.framljus = new Framljus();
       this.framljus.setCarStateListener(this);
       this.bakljus = new Bakljus();
       this.bakljus.setCarStateListener(this);
       this.varningsBlinkers = new VarningsBlinkers();
       this.varningsBlinkers.setCarStateListener(this);
       this.hastighet = 0;
    }

    public void setStarted(boolean started) {
        isStarted = started;
        if(started==false){
            this.framljus.setOn(false);
            this.bakljus.setOn(false);
        }
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
            setHastighet(hastighet + 20);
            setRiktning();
        }
        if(pedaler==Pedaler.BROMS){
            setHastighet(hastighet - 20);
            setRiktning();
        }
        if(pedaler==Pedaler.BROMS_STOPP){
            setHastighet(0);
        }
    }

    public Pedaler getPedaler() {
        return pedaler;
    }

    public int getHastighet() {
        return hastighet;
    }

    public void setHastighet(int hastighet) {
            this.hastighet = Math.max(Math.min(180, hastighet),0);
        }

    public void setRiktning() {
        if(hastighet>=0){
            riktning = Riktning.FRAMÅT;
        }else {
            riktning = Riktning.BAKÅT;
        }
    }


    @Override
    public boolean carStarted() {
        return isStarted();
    }


}
