package com.placeManager.locationmanager.domain;

import com.github.slugify.Slugify;
import com.placeManager.locationmanager.api.PlaceRequest;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PlaceService {

    private PlaceRepository placeRepository;
    private Slugify slg;
    public PlaceService(PlaceRepository placeRepository){
        this.placeRepository = placeRepository;
        this.slg = Slugify.builder().build();
    }

    public Mono<Place> createPlace(PlaceRequest request){
        var place = new Place(null, request.name(), request.state(), slg.slugify(request.name()), null, null);
        return placeRepository.save(place);
    }

    public Flux<Place> placeList() {
        return placeRepository.findAll();
    }

    public Mono<Place> getPlaceById(Long id) {
        return placeRepository.findById(id);
    }

}