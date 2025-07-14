public class Route {

    private String pickUpAddress;
    private String destinationAddress;
    private double tripPrice;
    private int key;

    public Route(){}

    public Route(String pickUpAddress, String destinationAddress, double tripPrice, int key){
        this.pickUpAddress = pickUpAddress;
        this.destinationAddress = destinationAddress;
        this.tripPrice = tripPrice;
        this.key = key;
    }

    // ------- getter -------
    public String getPickUpAddress() {
        return pickUpAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public double getTripPrice() {
        return tripPrice;
    }

    public int getKey() {
        return key;
    }


    // ------- setter -------

    public void setPickUpAddress(String pickUpAddress) {
        this.pickUpAddress = pickUpAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public void setTripPrice(double tripPrice) {
        this.tripPrice = tripPrice;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
