package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testDelete()//unit for delete city name
    {
        CityList cityList=new CityList();
        City city=new City("Regina","BK");
        City city1=new City("Jashore","Khulna");
        cityList.add(city);
        cityList.add(city1);
        cityList.delete(city);
        assertTrue(!cityList.getCities().contains(city));//the method becomes true if record of
        //city objects are not found in the arraylist

    }

    @Test
    public void testDeleteExceptionThrown()//if the list does not contain any
            //city then it will return exception
    {
        CityList cityList=new CityList();
        City city1=new City("Regina","BK");
        City city2=new City("Jashore","Khulna");
        cityList.add(city1);
        cityList.add(city2);
        cityList.delete(city1);
        assertThrows(IllegalArgumentException.class, ()->
        {
            cityList.delete(city1);
        });
    }

    @Test
    public void testCount()//unit test for count
    {
        CityList cityList=new CityList();
        City city1=new City("Bandarban","Chittagong");
        City city2=new City("Dinajpur","Rangpur");
        City city3=new City("Khustia","Khulna");

        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);
        assertEquals(3,cityList.count());
        /*
        we first add three objects to the list
        and check whether the size has increased to 3 or not
        if size becomes 3 then the insertion is successful

         */
    }
    @Test
    public void TestSort()//unit test for sorting
    {
        CityList cityList=mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city1=new City("Gazipur","Dhaka");
        cityList.add(city1);
        assertEquals(0,city1.compareTo(cityList.getCitiesSort(true).get(1)));

        /*
        mockcity has Edmonton and AB and first we check with the same thing and thus
        assertEquals works
        secondly we insert a object and compare with getCitiesSort method to check whether it
        works or not by comparing city1 object goes to 2nd place and thus we use get method
        and inside get method we comparing with 1 position which is basically mean 2nd position
        so compareTo method will return  0 and assertEquals finds it equal with working value and
        expected value
         */

    }


}
