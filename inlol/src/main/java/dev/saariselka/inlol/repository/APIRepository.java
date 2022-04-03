package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.APIEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface APIRepository extends JpaRepository<APIEntity, Long> {

    public List<APIEntity> findById(String id);

//    @Query(value = "SELECT * FROM mst_api WHERE CATEGORY = :categroy AND OPERATION = :operation", nativeQuery = true)
//    public List<APIEntity> searchAPI(@Param("categroy") String category, @Param("operation") String operation);

    public List<APIEntity> findByCategoryAndOperation(String category,String operation);
}