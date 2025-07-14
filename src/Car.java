public class Car {
    private String code;
    private Route route;
    private int maxCapacityPassenger; //e.g maximum 5 passenger can reserve

    public Car() {}

    public Car(String code, Route route, int maxCapacityPassenger) {
        this.code = code;
        this.route = route;
        this.maxCapacityPassenger = maxCapacityPassenger;
    }


    // ------- getter -------
    public String getCode() {
        return code;
    }

    public int getMaxCapacityPassenger() {
        return maxCapacityPassenger;
    }

    public Route getRoute() {
        return route;
    }



    // ------- setter -------
    public void setCode(String code) {
        this.code = code;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public void setMaxCapacityPassenger(int maxCapacityPassenger) {
        this.maxCapacityPassenger = maxCapacityPassenger;
    }


}
