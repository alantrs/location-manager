package com.placeManager.locationmanager.web;

import com.placeManager.locationmanager.api.PlaceRequest;
import com.placeManager.locationmanager.api.PlaceResponse;
import com.placeManager.locationmanager.domain.Place;
import com.placeManager.locationmanager.domain.PlaceMapper;
import com.placeManager.locationmanager.domain.PlaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
@RequestMapping("/places")
@Tag(name = "Places")
public class PlaceController {

    private PlaceService placeService;

    public PlaceController(PlaceService placeService){
        this.placeService = placeService;
    }

    @Operation(summary = "Cria places")
    @PostMapping
    public ResponseEntity<Mono<PlaceResponse>> create(@Valid @RequestBody PlaceRequest request){
        var placeResponse = placeService.createPlace(request).map(PlaceMapper::toResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(placeResponse);
    }

    @GetMapping
    public Flux<Place> list() {
        return placeService.placeList();
    }

    @GetMapping("/{id}")
    public Mono<Place> getPlaceById(@PathVariable Long id) {
        return placeService.getPlaceById(id);
    }
}