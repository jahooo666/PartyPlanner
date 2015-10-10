/**
 * Created by Marcin on 2015-10-10.
 */
public class CountingModule {
    private double promile;
    private double time;
    private int numberOfMen;
    private int numberOfWomen;
    private int typeOfAlcochol;
    private double ml;
    private double liters;
    private double price = 0;
    private double prifferedPrice;


    public void setTime(double time){
        this.time = time;
    }

    public double getTime(){
        return time;
    }

    public void setNumberOfWomen(int numberOfWomen){
        this.numberOfWomen = numberOfWomen;
    }

    public double getNumberOfWoman(){
        return numberOfWomen;
    }

    public void setNumberOfMan(int numberOfMan){
        this.numberOfMen = numberOfMan;
    }

    public double getNumberOfMan(){
        return numberOfMen;
    }

    public void setPrifferedPrice(double prifferedPrice){
        this.prifferedPrice = prifferedPrice;
    }

    public double getPrifferedPrice(){
        return prifferedPrice;
    }

    private void countGrams(){
        double promilFactor = -(double)time * (-0.12) + promile + 0.12;
        double cleanAlcolInMl = promilFactor * 70;
        ml =  cleanAlcolInMl * (numberOfMen + 0.5 * numberOfWomen);
    }

    private void chooseTypeOfParty(int PartyType){
        switch(PartyType){
            case 1:
                promile = 0.5;
                break;
            case 2:
                promile = 1.35;
                break;
            case 3:
                promile = 2.5;
                break;
        }
    }

    private int chooseAlco(int typeOfAlcochol) {
        switch (typeOfAlcochol){
            case 2:
                price = 30;
                this.typeOfAlcochol = 2;
                return 12;
            case 1:
                price = 5;
                this.typeOfAlcochol = 1;
                return 5;
            case 4:
                price = 30;
                this.typeOfAlcochol = 4;
                return 38;
            case 3:
                price = 5;
                this.typeOfAlcochol = 3;
                return 20;
            default:
                return 0;
        }
    }

    private void countLiters(){
        liters =  (ml / 10)/chooseAlco(typeOfAlcochol);
    }

    private double price(){
        if(price == 0){
            chooseAlco(typeOfAlcochol);
        }
        return liters * price;
    }

    private String comparePrices(){
        if(price()>10*prifferedPrice)
            return "Brakuje Ci kupe kasy";
        else if(price()>5*prifferedPrice)
            return "Nie bądź żyd dorzuć trochę";
        else if(price()>2*prifferedPrice)
            return "Mało kapusty!";
        else if(price()>prifferedPrice)
            return "Brakło trochę :/";
        else if(10*price()<prifferedPrice)
            return "Szykuje się gruba impreza, wziąłbym 10 razy tyle :P";
        else if(5*price()<prifferedPrice)
            return "Weź więcej, nie zmarnuje się :D";
        else if(2*price()<prifferedPrice)
            return "Można szaleć ;)";
        else if(price()==prifferedPrice)
            return "W sam raz :D";
        else
            return "Jeszcze pare można wziąć";
    }



    public static void main(String[] args) {
        CountingModule countingModule = new CountingModule();
        countingModule.numberOfMen = 4;
        countingModule.numberOfWomen =12;
        countingModule.time = 3;
        countingModule.chooseTypeOfParty(2);
        countingModule.chooseAlco(1);
        countingModule.countGrams();
        countingModule.countLiters();
        System.out.println(countingModule.liters);
        System.out.println(countingModule.price());
        System.out.println();

        countingModule.prifferedPrice = 1000.0;
        System.out.println(countingModule.comparePrices());
        
    }
}