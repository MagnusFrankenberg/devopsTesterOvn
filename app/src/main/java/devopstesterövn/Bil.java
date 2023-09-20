package devopstesterövn;

public class Bil {

    private boolean isStarted;
    private Framljus framljus;
    private Bakljus bakljus;
    private VarningsBlinkers varningsBlinkers;

    public Bil() {
        this.isStarted = false;
        this.framljus = new Framljus();
        this.bakljus = new Bakljus();
        this.varningsBlinkers = new VarningsBlinkers();
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public void setFramljus(Framljus framljus) {
        this.framljus = framljus;
    }

    public void setBakljus(Bakljus bakljus) {
        this.bakljus = bakljus;
    }

    public void setVarningsBlinkers(VarningsBlinkers varningsBlinkers) {
        this.varningsBlinkers = varningsBlinkers;
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
}
