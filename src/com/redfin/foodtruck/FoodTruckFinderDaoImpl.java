package com.redfin.foodtruck;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FoodTruckFinderDaoImpl implements FoodTruckFinderDao
{
    @Override public List<FoodTruck> getOpenFoodTrucks(int dayOrder, String start24, String end24)
    {
        try {
            StringBuilder result = new StringBuilder();
            String host = "https://data.sfgov.org/resource/jjew-r69b.json?$query=";
            String query = "SELECT * where dayorder="+dayOrder +" and start24 between '00:00' and '"+start24+"' and end24 between '"+end24+"' and '24:00'";
            URL url = new URL(host+URLEncoder.encode(query,StandardCharsets.UTF_8.toString()));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            Gson gson = new Gson();
            List<FoodTruck> foodTruckDetails = gson.fromJson(result.toString(), new TypeToken<List<FoodTruck>>(){}.getType());
            return foodTruckDetails;
        } catch (Exception ex) {
            // TODO should throw
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
