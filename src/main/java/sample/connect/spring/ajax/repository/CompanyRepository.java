package sample.connect.spring.ajax.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sample.connect.spring.ajax.data.entity.CompanyEntity;

@Repository
public interface CompanyRepository extends CrudRepository<CompanyEntity, Long> {
}
