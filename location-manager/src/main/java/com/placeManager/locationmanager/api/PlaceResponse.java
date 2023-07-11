package com.placeManager.locationmanager.api;

import java.time.LocalDateTime;

public record PlaceResponse(String name,String state, String slug, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
