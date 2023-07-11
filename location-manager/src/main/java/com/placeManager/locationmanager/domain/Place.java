package com.placeManager.locationmanager.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public record Place(Long id, String name, String state, String slug, @CreatedDate LocalDateTime createdAt, @LastModifiedDate LocalDateTime updatedAt) {
}
