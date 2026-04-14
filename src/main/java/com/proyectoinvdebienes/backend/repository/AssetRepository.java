package com.proyectoinvdebienes.backend.repository;

import com.proyectoinvdebienes.backend.domain.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {}
