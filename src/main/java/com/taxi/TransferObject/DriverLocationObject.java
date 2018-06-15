package com.taxi.TransferObject;

import com.taxi.RequestMapper.DriverRequestMapper;
import com.taxi.domain.Cities;
import com.taxi.domain.Countries;
import com.taxi.domain.Locations;
import com.taxi.domain.States;

/**
 *
 * @author
 */
public class DriverLocationObject {

    public static Locations locationObject(boolean isAddOrUpdate, DriverRequestMapper driverRequestMapper) {
        Locations locations = new Locations();
        locations.setAddress(driverRequestMapper.getAddress());
        locations.setStreet(driverRequestMapper.getStreet());
        locations.setZip(driverRequestMapper.getZip());

        Cities cities = new Cities();
        States states = new States();
        Countries countries = new Countries();

        cities.setCityId(driverRequestMapper.getCityId());
        states.setStateId(driverRequestMapper.getStateId());
        countries.setCountriId(driverRequestMapper.getCountryId());

        locations.setCities(cities);
        locations.setStates(states);
        locations.setCountries(countries);
        locations.setLng(0);
        locations.setLat(0);
        return locations;
    }
}
