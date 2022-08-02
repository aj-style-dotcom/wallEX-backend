package com.codelancer.WallEX.repo;

import com.codelancer.WallEX.model.Wallpaper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WallpaperRepo extends JpaRepository<Wallpaper, String> {
}
