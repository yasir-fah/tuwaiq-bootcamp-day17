import java.util.ArrayList;

public class NonSubsPassenger extends Passenger{

    private boolean isDiscount;


    public NonSubsPassenger() {}
    //passenger attribute with discount also
    public NonSubsPassenger(String name, double tripCost, Car reservedCar, String id, boolean isDiscount) {
        super(name, tripCost, reservedCar, id);
        this.isDiscount = isDiscount;
    }


    public boolean getIsDiscount() {
        return isDiscount;
    }

    public void setDiscount(boolean isDiscount) {
        this.isDiscount = isDiscount;
    }



    @Override
    public void calculateTripCost(Car car){
            try {
                if (checkPassenger(car.getMaxCapacityPassenger()) && isDiscount)
                {
                    car.setMaxCapacityPassenger(car.getMaxCapacityPassenger() - 1); // decrease with one
                    this.setTripCost(getTripCost() * 0.90); // 10% discount
                    this.setReservedCar(car);   //reserve car
                }
                else if (checkPassenger(car.getMaxCapacityPassenger()))
                {
                    car.setMaxCapacityPassenger(car.getMaxCapacityPassenger() - 1);
                    this.setTripCost(getTripCost());
                    this.setReservedCar(car);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

    }


    public boolean checkPassenger(int passenger){

        boolean isTrue = true;
        try {
            if(passenger <= 0){
                isTrue = false;
                throw new Exception("the capacity of passengers in this caris full");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isTrue;
    }



    @Override
    public void displayInfo(ArrayList<Passenger> passList){
        if(passList.isEmpty()){
            System.out.println("the passenger List is empty");
        }else{
            for(Passenger passenger : passList){
                System.out.println
                        (
                                "Passenger{" +
                                        "name='" + this.getName() + '\'' +
                                        ", id='" + this.getId() + '\'' +
                                        ", reservedCar id=" + this.getReservedCar().getCode() +
                                        ", car capacity: " + this.getReservedCar().getMaxCapacityPassenger() +
                                        '}'
                        );
            }
        }
    }






}
