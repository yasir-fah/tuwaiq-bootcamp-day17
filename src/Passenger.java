import java.util.ArrayList;

abstract public class Passenger {

    private String name;
    private String id;
    private Car reservedCar;
    private double tripCost;

    public Passenger() {}

    public Passenger(String name, double tripCost, Car reservedCar, String id) {
        this.name = name;
        this.tripCost = tripCost + reservedCar.getRoute().getTripPrice();
        this.reservedCar = reservedCar;
        this.id = id;
    }



    //------- getter -------
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Car getReservedCar() {
        return reservedCar;
    }

    public double getTripCost() {
        return tripCost;
    }



    //------- setter -------
    public void setReservedCar(Car reservedCar) {
        this.reservedCar = reservedCar;

        // --capacity each (set)
        if(reservedCar.getMaxCapacityPassenger() == 0 ){
            this.reservedCar.setMaxCapacityPassenger(0);
        }else{
            reservedCar.setMaxCapacityPassenger(reservedCar.getMaxCapacityPassenger() - 1);
        }
    }

    public void setTripCost(double tripCost) {
        this.tripCost = tripCost;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    abstract public void calculateTripCost(Car car);


    //display the passenger information with carCode,routePrice:
    public void displayInfo(ArrayList<Passenger> passList){}


    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", reservedCar=" + reservedCar +
                ", tripCost=" + tripCost +
                '}';
    }
}
