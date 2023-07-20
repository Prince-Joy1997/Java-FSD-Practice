import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundToMillionMain {

    public static void main(String[] args) {

        List<City> stringList = new ArrayList<City>();
        stringList.add(new City("Nice", "942208"));
        stringList.add(new City("Abu Dhabi", "1482816"));
        stringList.add(new City("Naples", "2186853"));
        stringList.add(new City("Vatican City", "572"));
        System.out.println(roundToMillion(stringList));
//        roundToMillion(stringList);
    }

    public static List<City> roundToMillion(List<City> cityList) {
        int pop = 0;
        List<City> result = new ArrayList<>();
        for (City city : cityList) {
            pop = Integer.valueOf(city.population());

            if (pop < 500000) {
                result.add(new City(city.cityName(), "0"));
            } else {

                int round = (int) (Math.round(pop / 1000000.00) * 1000000);
                String str = String.valueOf(round);
                result.add(new City(city.cityName(), str));
            }

        }
        return result;
    }
}
