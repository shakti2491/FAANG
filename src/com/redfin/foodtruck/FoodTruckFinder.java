package com.redfin.foodtruck;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class FoodTruckFinder {
    public static void main(String[] args) throws IOException
    {
        // DAO dependency to be injected in service class
        FoodTruckFinderDao foodTruckFinderDao = new FoodTruckFinderDaoImpl();
        // service object to fetch the current open food trucks
        FoodTruckFinderService foodTruckFinderService = new FoodTruckFinderServiceImpl(foodTruckFinderDao);
        LocalDateTime now = LocalDateTime.now();

        // starting with offset as zero and limit as 10 as given in requirement
        int currOffset = 0;
        int limit = 10;
        List<FoodTruck> foodTruckList = null;
        while (true){
            // fetch the  opened food trucks based on provided time
            try
            {
                foodTruckList = foodTruckFinderService.getOpenFoodTrucksForGivenTimeSorted(now, currOffset, limit);
            }catch (Exception ex){
                //log the exception using logger
                ex.printStackTrace();
            }
            if(foodTruckList == null || foodTruckList.isEmpty()){
                System.out.println("No Open Food Trucks to display");
                break;
            }
            foodTruckList.forEach((foodTruck)-> {
                        StringBuilder builder = new StringBuilder();
                        builder.append("Name-->>").append(foodTruck.getApplicant())
                                .append(" Address-->>").append(foodTruck.getLocation())
                                .append(" Start Time-->>").append(foodTruck.getStarttime())
                                .append(" End Time -->>").append(foodTruck.getEndtime());
                        System.out.println(builder.toString());
                    }
            );
            System.out.println("Press Enter key to continue...");
            System.in.read();
            currOffset +=limit;
        }
    }
}
