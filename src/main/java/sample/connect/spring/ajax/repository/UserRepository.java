package sample.connect.spring.ajax.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sample.connect.spring.ajax.data.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    @Query("SELECT a FROM UserEntity a WHERE a.clientKey=?1")
    UserEntity findByClientKey(String clientKey);

    default void deleteByClientKey(String clientKey){
        this.delete(findByClientKey(clientKey));
    };
}
