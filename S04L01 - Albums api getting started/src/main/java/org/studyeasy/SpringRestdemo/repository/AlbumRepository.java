package org.studyeasy.SpringRestdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.studyeasy.SpringRestdemo.model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    
}
