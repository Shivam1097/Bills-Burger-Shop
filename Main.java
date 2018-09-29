/**
 *  Created by shivam on 17/08/18.
 */

class Hamburger {

    private String name;
    private String bread_roll_type;
    private String meat;
    private String customerName;
    private float basePrice;
    private float addonPrice;
    private int count=0;
    private float carrotPrice=1.1f;
    private float tomatoPrice=1.0f;
    private float lettucePrice=1.0f;
    private float cheesePrice=2.0f;
    private static int orderCount=0;


    public Hamburger(String customerName,String name,String bread_roll_type, String meat,float basePrice) {
        orderCount++;
        this.customerName=customerName;
        this.name=name;
        this.bread_roll_type = bread_roll_type;
        this.meat = meat;
        this.basePrice= basePrice;
        System.out.println("\n=====================================================================================================\n");
        System.out.println("\n"+"This is the order for customer : "+this.customerName+" ->"+"\n");
    }


    public void addCarrot(){
        this.count++;
        System.out.println("Carrot has been added for an extra of : "+carrotPrice);
        this.addonPrice+=carrotPrice;
    }

    public void addTomato(){
        this.count++;
        System.out.println("Tomato has been added for an extra of : "+tomatoPrice);
        this.addonPrice+=tomatoPrice;
    }

    public void addLettuce(){
        this.count++;
        System.out.println("Lettuce has been added for an extra of : "+lettucePrice);
        this.addonPrice+=lettucePrice;
    }

    public void addCheese(){
        this.count++;
        System.out.println("Cheese has been added for an extra of : "+cheesePrice);
        this.addonPrice+=cheesePrice;
    }


    public float getFinalPrice(){
        return basePrice+getAddonPrice();
    }

    public int getCount(){
        return count;
    }

    public void getOrderDetails(){

        System.out.println("\n"+"Burger ordered : "+name+"\n"+"\n"+
                "Base price : "+basePrice+"\n"+"\n"+
                "Price for "+getCount()+" addons : "+getAddonPrice()+"\n"+"\n"+
                "Final price for yor order : "+getFinalPrice()+"\n");
        System.out.println("\n=====================================================================================================\n");
    }


    public static int getOrderCount(){
        return orderCount;
    }

    public float getBasePrice() {
        return basePrice;
    }


    public float getAddonPrice() {
        return addonPrice;
    }
}


class Deluxe_Burger extends Hamburger{

    private float chipsPrice;
    private float coldDrinkPrice;
    private float deluxeAddonPrice;
    private int deluxeAddonCount;


    public Deluxe_Burger(String customerName, String name, String bread_roll_type, String meat, float basePrice) {
        super(customerName, name, bread_roll_type, meat, basePrice);
        this.deluxeAddonCount=2;
        this.chipsPrice = 3.5f;
        this.coldDrinkPrice = 4.0f;
        this.deluxeAddonPrice=chipsPrice+coldDrinkPrice;
        System.out.println("ColdDrink is added for an extra of : "+coldDrinkPrice);
        System.out.println("Chip is added for an extra of : "+chipsPrice);
    }

    @Override
    public void addCarrot() {
        System.out.println("Deluxe Ham has it's default ADDITIONALS , so Carrot can't be added.");
    }

    @Override
    public void addTomato() {
        System.out.println("Deluxe Ham has it's default ADDITIONALS , so Tomato can't be added.");
    }

    @Override
    public void addLettuce() {
        System.out.println("Deluxe Ham has it's default ADDITIONALS , so Lettuce can't be added.");
    }

    @Override
    public void addCheese() {
        System.out.println("Deluxe Ham has it's default ADDITIONALS , so Cheese can't be added.");
    }


    @Override
    public float getAddonPrice() {
        return deluxeAddonPrice;
    }

    @Override
    public int getCount() {
        return deluxeAddonCount;
    }


}

class Healthy_Burger extends Hamburger{


    private  float saladPrice=2.0f;
    private float beansPrice=2.0f;
    private float HealthyAddonPrice;
    private int healthyAddonCount;


    public Healthy_Burger(String customerName, String name,String bread_roll_type, String meat, float basePrice) {
        super(customerName, name, bread_roll_type, meat, basePrice);
        this.saladPrice = 2.0f;
        this.beansPrice = 2.0f;

    }

    public void addSalad(){
        this.healthyAddonCount ++;
        System.out.println("Salad has been added for an extra of : "+saladPrice);
        this.HealthyAddonPrice+=saladPrice;

    }

    public void addBeans(){
        this.healthyAddonCount++;
        System.out.println("Beans has been added for an extra of : "+beansPrice);
        this.HealthyAddonPrice+=beansPrice;

    }


    @Override
    public float getAddonPrice() {
        return HealthyAddonPrice+super.getAddonPrice();
    }


    @Override
    public int getCount() {
        return healthyAddonCount+super.getCount();
    }

}



public class Main {

    public static void main(String...s) {

        // Make order for SHIVAM

        Hamburger hamburger = new Hamburger("SHIVAM SHUKLA","Hamburger","Sliced","Brisket",20.0f);
        hamburger.addCheese();
        hamburger.addTomato();
        hamburger.addLettuce();
        hamburger.getOrderDetails();

        // Make oreder for Tim

        Deluxe_Burger deluxe_burger=new Deluxe_Burger("TIM BUCHALKA","Deluxe Ham","Sliced","Brisket",50.0f);
        deluxe_burger.addCheese();
        deluxe_burger.getOrderDetails();


        // Make order for Robert

        Healthy_Burger healthy_burger=new Healthy_Burger("ROBERT","Healthy Ham","Sliced","Chucked",40.0f);
        healthy_burger.addCarrot();
        healthy_burger.addLettuce();
        healthy_burger.addSalad();
        healthy_burger.getOrderDetails();

        // Make order for STEVE
        Healthy_Burger healthy_burger1=new Healthy_Burger("STEVE","Healthy Ham","Sliced","Brisket",40.0f);
        healthy_burger1.addBeans();
        healthy_burger1.addCarrot();
        healthy_burger1.getOrderDetails();


        /////// Total order made from Bills Burger ///////

        System.out.println("\n"+"Total orders made from Bills Burger is : "+Hamburger.getOrderCount());

    }
}
