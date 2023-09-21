package devopstesterövn;

public class Bil implements CarStateListener{

    private boolean isStarted;
    private Framljus framljus;
    private Bakljus bakljus;
    private VarningsBlinkers varningsBlinkers;

    private Bromsljus bromsljus;

    private Pedaler pedaler;
    private int hastighet;
    private Riktning riktning;
    private Växel växel;
    Batteri batteri;

    public Växel getVäxel() {
        return växel;
    }

    public void setVäxel(Växel växel) {
        this.växel = växel;
        setRiktning();
    }



    public Riktning getRiktning() {
        return riktning;
    }

    public void setRiktning() {
        if(växel==Växel.DRIVE){
            riktning = Riktning.FRAMÅT;
        }
        if(växel==Växel.REVERSE){
            riktning = Riktning.BAKÅT;
        }
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
       this.bromsljus = new Bromsljus();
       this.batteri = new Batteri(100);
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

    public Bromsljus getBromsljus() {
        return bromsljus;
    }

    public VarningsBlinkers getVarningsBlinkers() {
        return varningsBlinkers;
    }

    public Batteri getBatteri() {
        return batteri;
    }

    public void användPedal(Pedaler pedaler) {
        this.pedaler = pedaler;
        if(pedaler==Pedaler.GAS) {
            setHastighet(hastighet + 20);
            batteri.setBatteriNivå(batteri.getBatteriNivå()-10);
            this.bromsljus.setOn(false);
        }
        if(pedaler==Pedaler.BROMS){
            setHastighet(hastighet - 20);
            this.bromsljus.setOn(true);
        }
        if(pedaler==Pedaler.BROMS_STOPP){
            setHastighet(0);
            this.bromsljus.setOn(true);
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


    @Override
    public boolean carStarted() {
        return isStarted();
    }



}
