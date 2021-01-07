package com.redfin.foodtruck;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FoodTruckFinderServiceImpl implements FoodTruckFinderService
{

    private FoodTruckFinderDao foodTruckFinderDao;
    public FoodTruckFinderServiceImpl(FoodTruckFinderDao foodTruckFinderDao)
    {
        this.foodTruckFinderDao = foodTruckFinderDao;
    }
    // cache to store food trucks
    // TODO should be a key value store based on the time and day of week
    private volatile List<FoodTruck> openSortedFoodTruckList;

    @Override public List<FoodTruck> getOpenFoodTrucksForGivenTimeSorted(LocalDateTime time, int offset, int limit) throws DataAccessException
    {
        List<FoodTruck> foodTrucks = fetchAndCacheOpenFoodTruckList(time);
        if(offset>=foodTrucks.size())
            return null;
        if(offset+limit>foodTrucks.size())
            limit =foodTrucks.size();
        else
            limit = offset+limit;
        List<FoodTruck> subList =  fetchAndCacheOpenFoodTruckList(time).subList(offset,limit);
        return subList;

    }

    // caching the opened food trucks
    private List<FoodTruck> fetchAndCacheOpenFoodTruckList(LocalDateTime time) throws DataAccessException
    {
        List<FoodTruck> result = this.openSortedFoodTruckList;
        // check if result is available
        if (result == null)
        {
            synchronized (this)
            {
                result = this.openSortedFoodTruckList;
                if(result==null)
                {
                    int dayOrder = time.getDayOfWeek().getValue();
                    String end24 = (time.getHour() + 1) + ":00";
                    String start24 = (time.getHour()) + ":00";
                    List<FoodTruck> foodTruckList = this.foodTruckFinderDao.getOpenFoodTrucks(dayOrder, start24, end24);
                    // sort by the name by supplying  the appropriate comparator
                    openSortedFoodTruckList = foodTruckList.stream()
                            .sorted(((foodTruckA, foodTruckB) -> foodTruckA.getApplicant().compareToIgnoreCase(foodTruckB.getApplicant())))
                            .collect(Collectors.toList());
                }
            }
        }

        return openSortedFoodTruckList;
    }
}
