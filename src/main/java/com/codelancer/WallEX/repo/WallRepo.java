package com.codelancer.WallEX.repo;

import com.codelancer.WallEX.model.WallModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WallRepo extends JpaRepository<WallModel, String> {}
