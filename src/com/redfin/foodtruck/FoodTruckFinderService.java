package com.redfin.foodtruck;
import java.time.LocalDateTime;
import java.util.List;

public interface FoodTruckFinderService
{
    List<FoodTruck> getOpenFoodTrucksForGivenTimeSorted(LocalDateTime localDateTime, int offset, int limit) throws
            DataAccessException;

}
