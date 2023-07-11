package com.placeManager.locationmanager.web;

import com.placeManager.locationmanager.api.PlaceResponse;
import com.placeManager.locationmanager.domain.Place;

public class PlaceMapper {

    public static PlaceResponse toResponse(Place place){
        return new PlaceResponse(place.name(), place.state(), place.slug(), place.createdAt(), place.updatedAt());
    }
}
