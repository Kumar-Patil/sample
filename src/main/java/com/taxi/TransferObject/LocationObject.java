package com.taxi.TransferObject;

import com.taxi.RequestMapper.VendorRequestMapper;
import com.taxi.domain.Cities;
import com.taxi.domain.Countries;
import com.taxi.domain.Locations;
import com.taxi.domain.States;

/**
 *
 * @author
 */
public class LocationObject {

    public static Locations locationObject(boolean isAddOrUpdate, VendorRequestMapper vendorRequestMapper) {
        Locations locations = new Locations();
        locations.setAddress(vendorRequestMapper.getAddress());
        locations.setStreet(vendorRequestMapper.getStreet());
        locations.setZip(vendorRequestMapper.getZip());

        Cities cities = new Cities();
        States states = new States();
        Countries countries = new Countries();

        cities.setCityId(vendorRequestMapper.getCityId());
        states.setStateId(vendorRequestMapper.getStateId());
        countries.setCountriId(vendorRequestMapper.getCountryId());

        locations.setCities(cities);
        locations.setStates(states);
        locations.setCountries(countries);
        locations.setLng(0);
        locations.setLat(0);
        return locations;
    }
}
