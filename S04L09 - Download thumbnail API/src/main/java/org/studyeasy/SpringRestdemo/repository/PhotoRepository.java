package org.studyeasy.SpringRestdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.studyeasy.SpringRestdemo.model.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
    

}
