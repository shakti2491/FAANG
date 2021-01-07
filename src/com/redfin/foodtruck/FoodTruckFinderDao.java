package com.redfin.foodtruck;
import java.util.List;

public interface FoodTruckFinderDao
{
    List<FoodTruck> getOpenFoodTrucks(int dayOrder, String startTime, String endTime) throws DataAccessException;
}
