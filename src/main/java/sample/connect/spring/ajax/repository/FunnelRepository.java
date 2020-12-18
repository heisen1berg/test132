package sample.connect.spring.ajax.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sample.connect.spring.ajax.data.entity.FunnelEntity;

@Repository
public interface FunnelRepository extends CrudRepository<FunnelEntity, Long> {
    default FunnelEntity updateName(Long id, String newName){
        final FunnelEntity funnelEntity = findById(id).get();
        funnelEntity.setName(newName);
        save(funnelEntity);
        return findById(id).get();
    }
}
