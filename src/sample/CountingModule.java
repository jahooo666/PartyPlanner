import java.util.HashMap;
import java.util.Map;

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
            return "Nie b¹dŸ ¿yd dorzuæ trochê";
        else if(price()>2*prifferedPrice)
            return "Ma³o kapusty!";
        else if(price()>prifferedPrice)
            return "Brak³o trochê :/";
        else if(10*price()<prifferedPrice)
            return "Szykuje siê gruba impreza, wzi¹³bym 10 razy tyle :P";
        else if(5*price()<prifferedPrice)
            return "WeŸ wiêcej, nie zmarnuje siê :D";
        else if(2*price()<prifferedPrice)
            return "Mo¿na szaleæ ;)";
        else if(price()==prifferedPrice)
            return "W sam raz :D";
        else
            return "Jeszcze pare mo¿na wzi¹æ";
    }



    public static void main(String[] args) {
        CountingModule countingModule = new CountingModule();
        countingModule.numberOfMen = 2;
        countingModule.numberOfWomen = 2;
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