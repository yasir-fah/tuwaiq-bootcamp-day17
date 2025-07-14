import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        String firstMenu =  "1. join as administrator \n" +
                            "2. join as user          \n"+
                            "3. end program"  ;

        String adminMenu = "1. add route\n" +
                            "2. add car\n" ;


        boolean isRun = true;

        ArrayList<Route> listOfRoute = new ArrayList<>();
        ArrayList<Car> listOfCar = new ArrayList<>();
        ArrayList<Passenger> listOfPassenger = new ArrayList<>();


        do {
            System.out.println(firstMenu);

            int choice;
            try {
                choice = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException ime) {
                System.out.println("Please enter a valid menu number.");
                input.nextLine(); // consume the bad token
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println(adminMenu);

                    int adminChoice;
                    try {
                        adminChoice = input.nextInt();
                        input.nextLine();
                    } catch (InputMismatchException ime) {
                        System.out.println("Please enter 1 or 2 for the admin menu.");
                        input.nextLine();
                        break;
                    }

                    if (adminChoice == 1) {
                        adminRoute(listOfRoute);
                    } else {
                        adminCar(listOfCar, listOfRoute);
                    }
                    break;

                case 2:
                    System.out.println("going to user method");
                    userPassenger(listOfPassenger, listOfCar);
                    break;

                case 3:
                    isRun = false;
                    break;

                default:
                    System.out.println("wrong choice please enter valid choice");
            }

        } while (isRun);




        ///  minimum requirement in main:
        //1- create 2 routes
//        Route route1 = new Route("Riyadh","dammam",400);
        ////Route route2 = new Route("jeddah","taif",200);
        //2- assign the previous routes to these cars
//        Car car1 = new Car("1212",route1,4);
        ////Car car2 = new Car("0001",route2,0);
        //3- create array of passengers, 1 subscribes & 1 non-subscribed
//        SubsPassenger subscribed = new SubsPassenger("yasir",100,car1,"178");
        ////NonSubsPassenger notSubscribed = new NonSubsPassenger("ahmed",200,car2,"111",true);
//        ArrayList<Passenger> passengersList = new ArrayList<>();
//        passengersList.add(subscribed);
        //passengersList.add(notSubscribed);

//        System.out.println("======== subscribed ========");
//        System.out.println(subscribed.getTripCost());
//        subscribed.calculateTripCost(car1);
//        System.out.println(subscribed.getTripCost());
//
        //displayInfo();
//        subscribed.displayInfo(passengersList);
        ////System.out.println("======== non-subscribed ========");
        ////System.out.println(notSubscribed.getTripCost());
        ////notSubscribed.calculateTripCost(car2);
        ////System.out.println(notSubscribed.getTripCost());

    }

    public static ArrayList<Route> adminRoute(ArrayList<Route> listOfRoute) {
        Scanner input = new Scanner(System.in);

        String menu = "1. add route \n" +
                "2. exit \n";

        boolean isTrue = true;

        while (isTrue) {
            System.out.println(menu);

            int choice;
            try {
                choice = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException ime) {
                System.out.println("Please enter 1 or 2.");
                input.nextLine(); // consume bad token
                continue;
            }

            switch (choice) {

                case 1:
                    Route route = new Route();

                    System.out.println("Enter Pick Up Address:");
                    route.setPickUpAddress(input.nextLine());

                    System.out.println("Enter Destination Address:");
                    route.setDestinationAddress(input.nextLine());

                    System.out.println("Enter Trip Price: ");
                    try {
                        route.setTripPrice(input.nextDouble());
                        input.nextLine();
                    } catch (InputMismatchException ime) {
                        System.out.println("Invalid price. Please enter a number.");
                        input.nextLine();
                        break;
                    }

                    System.out.println("Enter a unique Key Of Route (1 or 2 digits): ");
                    try {
                        route.setKey(input.nextInt());
                        input.nextLine();
                    } catch (InputMismatchException ime) {
                        System.out.println("Invalid key. Please enter an integer.");
                        input.nextLine();
                        break;
                    }

                    listOfRoute.add(route); // route has been added

                    for (Route r : listOfRoute) {
                        System.out.println("destination address: " + r.getDestinationAddress());
                        System.out.println("pick up address: " + r.getPickUpAddress());
                        System.out.println("route price: " + r.getTripPrice());
                        System.out.println("===============");
                    }
                    break;

                case 2:
                    isTrue = false;
                    break;

                default:
                    System.out.println("out Route field...");
                    break;
            }
        }
        return listOfRoute;
    }






    public static ArrayList<Car> adminCar(ArrayList<Car> listOfCar, ArrayList<Route> listOfRoute) {
        Scanner input = new Scanner(System.in);

        String menu = "1. add car \n" +
                      "2. exit \n";

        boolean isTrue = true;

        while (isTrue) {
            System.out.println(menu);
            int choice = input.nextInt(); input.nextLine();

            switch (choice) {
                case 1:
                    Car car = new Car();

                    System.out.println("Enter Car Code:");
                    car.setCode(input.nextLine());

                    System.out.println("Chose Route You Want (by it's key) :");
                    int insertedKey = input.nextInt();

                    for(Route route : listOfRoute){
                        if(route.getKey() == insertedKey){ //check if  there is a route matches this key or not.
                            car.setRoute(route);
                            break;
                        }
                    }


                    System.out.println("Enter Max Capacity For Passengers: ");
                    car.setMaxCapacityPassenger(input.nextInt());
                    input.nextLine();

                    if(car.getRoute() == null){ // in case that a car object did not contain route object.
                        listOfCar.remove(car);
                        System.out.println("car did not match any trip, previous car was deleted");
                    }else{
                        listOfCar.add(car); // car has been added
                    }



                    for (Car c : listOfCar) {
                        System.out.println("car code: "+c.getCode());
                        System.out.println("car max capacity: "+c.getMaxCapacityPassenger());
                        System.out.println("pick up address (route info): "+c.getRoute().getPickUpAddress());
                        System.out.println("trip price: (route info): "+c.getRoute().getTripPrice());
                        System.out.println("===============");
                    }
                    break;

                case 2:
                    isTrue = false;
                    break;

                default:
                    System.out.println("Out Of Car field...");
                    break;
            }
        }

        return listOfCar;
    }





    public static ArrayList<Passenger> userPassenger(ArrayList<Passenger> listOfPassenger, ArrayList<Car> cars) {
        Scanner input = new Scanner(System.in);

        String menu = "1. Join As Subscriber \n" +
                      "2. join as Non-Subscriber \n" +
                      "3. Exit"                     ;

        boolean isTrue = true;

        while (isTrue) {

            System.out.println(menu);
            int choice = input.nextInt();   input.nextLine();


            switch (choice) {



                case 1:
                    SubsPassenger subscribed = new SubsPassenger();

                    boolean isAvailable = checkIfEmpty(cars);   // empty => false

                    System.out.println("Enter Passenger Name:");
                    subscribed.setName(input.nextLine());

                    System.out.println("Enter Trip Cost");
                    subscribed.setTripCost(input.nextInt());  input.nextLine();

                    System.out.println("Chose a Car By It's String Code");
                    String carCode = input.nextLine();
                    for(Car c : cars){
                        if(c.getCode().toLowerCase().contains(carCode)){
                            subscribed.setReservedCar(c);
                        }
                    }

                    System.out.println("Enter Passenger's Id");
                    subscribed.setId(input.nextLine());

                    if(subscribed.getReservedCar() == null) {
                        listOfPassenger.remove(subscribed);
                        System.out.println("previous passenger was deleted,no car has been chosen");
                    }else if(!isAvailable){
                        listOfPassenger.remove(subscribed);
                        System.out.println("previous passenger was deleted, capacity was Zero");
                    }else
                    {
                        listOfPassenger.add(subscribed);
                    }

                    // display all passengers
                    try {
                        subscribed.displayInfo(listOfPassenger);
                    } catch (NullPointerException npe) {
                        System.out.println("Error displaying passenger info: incomplete reservation data.");
                    }


                    break;



                case 2:

                     isAvailable = checkIfEmpty(cars);   // empty => false

                    NonSubsPassenger nonSub = new NonSubsPassenger();

                    System.out.println("Enter Passenger Name:");
                    nonSub.setName(input.nextLine());

                    System.out.println("Enter Trip Cost");
                    nonSub.setTripCost(input.nextInt());    input.nextLine();

                    System.out.println("Chose a Car By It's String Code");
                    String carCode2 = input.nextLine();

                    for (Car c : cars) {
                        if (c.getCode().toLowerCase().contains(carCode2)) {
                            nonSub.setReservedCar(c);
                        } else {
                            System.out.println("not matched");
                        }
                    }

                    System.out.println("Enter Passenger's Id");
                    nonSub.setId(input.nextLine());

                    System.out.println("Apply Discount? (true/false)");
                    nonSub.setDiscount(input.nextBoolean());


                    if(nonSub.getReservedCar() == null) {
                        listOfPassenger.remove(nonSub);
                        System.out.println("previous passenger was deleted,no car has been chosen");
                    }else if(!isAvailable){
                        listOfPassenger.remove(nonSub);
                        System.out.println("previous passenger was deleted, capacity was Zero");
                    }else
                    {
                        listOfPassenger.add(nonSub);
                    }

                    // display all passengers
                    try {
                        nonSub.displayInfo(listOfPassenger);
                    } catch (NullPointerException npe) {
                        System.out.println("Error displaying passenger info: incomplete reservation data.");
                    }

                    break;

                case 3:
                    isTrue = false;

            }
        }
        return listOfPassenger;
    }




    public static boolean checkIfEmpty(ArrayList<Car> car) {
        boolean checkEmpty = false;

        for (Car c : car){
            if(c.getMaxCapacityPassenger() == 0){
                System.out.println("previous car is full, code:"+c.getCode());
                checkEmpty = false;
            }else{
                checkEmpty = true;
            }
        }

        return checkEmpty;
    }


}
