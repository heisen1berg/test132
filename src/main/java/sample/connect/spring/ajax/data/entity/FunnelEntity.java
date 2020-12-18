package sample.connect.spring.ajax.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="funnel")
@Getter
@Setter
@NoArgsConstructor
public class FunnelEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name="user_id",nullable = false)
    private UserEntity userEntity;

    @OneToMany(mappedBy = "funnelEntity",
            cascade = CascadeType.REMOVE)
    private Set<LeadEntity> leadEntities;



    public FunnelEntity(String name, UserEntity userEntity){
        this.name=name;
        this.userEntity = userEntity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,name,
                userEntity==null?null:userEntity.getId());
    }

    @Override
    public boolean equals(Object obj) {
        return obj!=null &&
                obj.getClass().equals(this.getClass()) &&
                Objects.equals(((FunnelEntity)obj).getId(),id) &&
                Objects.equals(((FunnelEntity)obj).getName(),name) &&
                Objects.equals(
                        ((FunnelEntity)obj).getUserEntity()==null?null:((FunnelEntity)obj).getUserEntity().getId(),
                        userEntity==null?null:userEntity.getId()
                );
    }
}
