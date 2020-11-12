/* File:    Automobile.Java
   Author:  Darryl McDaniel
   Date:    September 15th, 2020
   Purpose: This is the first three classes of a program which contain the automobile's make and model and
   purchase price. Each of the classes have three methods.
 */

public class Automobile{
    private String makeAndModel;
    private int purchasePrice;
    double salesTax;

    public Automobile(String makeAndModel, int purchasePrice){
        this.makeAndModel = makeAndModel;
        this.purchasePrice = purchasePrice;
    }

     public double salesTax(int purchasePrice){
        this.salesTax = purchasePrice * .05;
        return this.salesTax;

    }

    public String toString(){

        return "\nMake and Model: " + this.makeAndModel +"\nPurchase Price: " +  this.purchasePrice +
                "\nSales Tax: " + this.salesTax + "\n";
    }

    public static class Electric extends Automobile{
        private int vehicleWeight;

        public Electric(String makeAndModel, int purchasePrice, int weight){
           super(makeAndModel, purchasePrice);
           this.vehicleWeight = weight;
        }

        public double salesTax(int purchasePrice){
            if (this.vehicleWeight < 3000){
                this.salesTax = super.salesTax(purchasePrice) - 200; }
            if (this.vehicleWeight >= 3000){
                this.salesTax = super.salesTax(purchasePrice) - 150;}
            return this.salesTax;
        }

        public String toString(){

            return super.toString() + "Weight: " + this.vehicleWeight + "\n";

        }

    }

    public static class Hybrid extends Automobile{
        private int mpg;

        public Hybrid(String makeAndModel, int purchasePrice,  int mpg){
            super(makeAndModel, purchasePrice);
            this.mpg = mpg;
        }

        public double salesTax(int purchasePrice){
            if (this.mpg < 40){
                this.salesTax = super.salesTax(purchasePrice) - 100;
            }
                this.salesTax = super.salesTax(purchasePrice) - ((2 * (this.mpg - 40))+100);
            return this.salesTax;
        }

        public String toString(){
            return super.toString() + "MPG: " + this.mpg + "\n";
        }
    }
}
