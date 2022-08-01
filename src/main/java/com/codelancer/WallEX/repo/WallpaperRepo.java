package com.codelancer.WallEX.repo;

import com.codelancer.WallEX.model.WallpaperModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WallpaperRepo extends JpaRepository<WallpaperModel, String> {
}
