package sample.connect.spring.ajax.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sample.connect.spring.ajax.data.entity.LeadEntity;

import java.util.List;

@Repository
public interface LeadRepository extends CrudRepository<LeadEntity, Long> {

    @Query("SELECT a FROM LeadEntity a WHERE a.funnelEntity = ?1 ORDER BY a.dateCreated DESC")
    List<LeadEntity> findByFunnelAndSort(Long funnelId);

    default LeadEntity updateTitle(Long id, String newTitle){
        final LeadEntity leadEntity = findById(id).get();
        leadEntity.setTitle(newTitle);
        save(leadEntity);
        return findById(id).get();
    }

}
