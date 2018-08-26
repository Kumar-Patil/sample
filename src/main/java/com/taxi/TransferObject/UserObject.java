package com.taxi.TransferObject;

import com.taxi.RequestMapper.UserRequestMapper;
import com.taxi.domain.Cities;
import com.taxi.domain.Countries;
import com.taxi.domain.Locations;
import com.taxi.domain.States;

/**
 *
 * @author
 */
public class UserObject {

    public static Locations userObject(boolean isAddOrUpdate, UserRequestMapper userRequestMapper) {
        Locations locations = new Locations();
        locations.setAddress(userRequestMapper.getAddress());
        locations.setStreet(userRequestMapper.getStreet());
        locations.setZip(userRequestMapper.getZip());
        Cities cities = new Cities();
        States states = new States();
        Countries countries = new Countries();
        if (userRequestMapper.getCityId() != 0) {
            cities.setCityId(userRequestMapper.getCityId());
            locations.setCities(cities);
        } 
        if (userRequestMapper.getStateId() != 0) {
            states.setStateId(userRequestMapper.getStateId());
            locations.setStates(states);
        } 
        if (userRequestMapper.getCountryId() != 0) {
            countries.setCountriId(userRequestMapper.getCountryId());
            locations.setCountries(countries);
        }

        locations.setLng(0);
        locations.setLat(0);
        return locations;
    }
}
