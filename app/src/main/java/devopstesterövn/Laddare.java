package devopstesterövn;

public class Laddare {


    private Bil anslutenBil;
    private boolean laddar;
    private int prisPerIteration = 5;

    public int getPrisPerIteration() {
        return prisPerIteration;
    }

    public boolean isLaddar() {
        return laddar;
    }

    public void setLaddar(boolean laddar) {
        this.laddar = laddar;
    }

    public void setAnslutenBil(Bil bil){
        anslutenBil = bil;
    }

    public Bil getAnslutenBil() {
        return anslutenBil;
    }

    public String laddaBilensBatteri() {
        int kostnad=0;
        if(getAnslutenBil().getBatteri().getBatteriNivå()<100){
            kostnad = kalkyleraKostnad();
            setLaddar(true);
            getAnslutenBil().getBatteri().laddaEttBatteri();
        }
        if(bilenÄrFullLaddad()){
            setLaddar(false);
        }
        return printKostnad(kostnad);
    }


    public boolean bilenÄrFullLaddad(){
        if(getAnslutenBil().getBatteri().getBatteriNivå()==100){
            return true;
        }
        return false;
    }

    public int iterationsNeeded(){
        int i;
        i = 10 - (getAnslutenBil().getBatteri().getBatteriNivå() / 10);
        System.out.println("Det krävs "+ i +" iterationer för att ladda Batteriet");
        return i;
    }

    public int kalkyleraKostnad(){
        return getPrisPerIteration() * iterationsNeeded();
    }

    public String printKostnad(int kostnad){
        return "Pris: "+ kostnad;
    }




}
