import java.util.ArrayList;
import java.util.InputMismatchException;

public class SubsPassenger extends Passenger {


    public SubsPassenger(){}


    //passenger attribute with discount also
    public SubsPassenger(String name, double tripCost, Car reservedCar, String id) {
        super(name, tripCost, reservedCar, id);
    }


    // user with subscription get 50% discount, and reserve car to a passenger
    @Override
    public void calculateTripCost(Car car) {

        try {
            if (checkPassenger(car.getMaxCapacityPassenger())) {
                car.setMaxCapacityPassenger(car.getMaxCapacityPassenger() - 1);
                this.setTripCost(getTripCost() * 0.50);
                this.setReservedCar(car);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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
                                        ", tripCost=" + this.getTripCost() +
                                        ", car capacity: " + this.getReservedCar().getMaxCapacityPassenger() +
                                        '}'
                        );
            }
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

}
