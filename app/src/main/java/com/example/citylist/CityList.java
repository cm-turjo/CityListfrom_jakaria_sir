package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city parameter city object of CITY
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return citylist with cities sorted by cities name.
     *      Return the sorted list of cities
     */
    public List<City> getCities() {
        List<City> cityList = cities;
        Collections.sort(cityList);
        return cityList;
    }


    public void delete(City city)//Method to delete city from citylist
    {
        if(!cities.contains(city))//if the list does not contain any city then statement becomes true
        {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * this method will return a list and this method
     *         takes a boolean parameter
     *         if the flag ==false then it will sort by statename
     *         if the flag ==true then it will sort by province name
     * @return a list consisting cities of cityname and province name
     */


    public int count()
    {
        return cities.size();//list.size() to return list size
    }

    public List<City> getCitiesSort(boolean flag)
    {

        List<City> cityList=cities;

        if(flag==false)
        {
            Collections.sort(cityList);
            return cityList;
        }
        else
        {
            Collections.sort(cityList,new Comparator<City>()
            {
                /*
                here collections.sort takes two parameters first one is list and second one how to perform
                sorting on that list.Comparator is overrode and compareTo method is used to
                compare two object's province name
                 */

                @Override
                public int compare(City city, City t1) {
                    return city.getProvinceName().compareTo(t1.getProvinceName());
                }
            });
        }
        return cityList;//finally returns the sorted list according to province name
    }

}
