package sample.connect.spring.ajax.data.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="credentials")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name="user_id")
    private Long id;

    @Column(name="client_key",nullable = false, unique = true)
    private String clientKey;

    @Column(name="shared_secret", nullable = false)
    private String sharedSecret;

    @Column(name="date_installed",nullable = false)
    private Date dateInstalled = new Date();

    @OneToMany(mappedBy = "userEntity",
            cascade = CascadeType.REMOVE)
    private Set<FunnelEntity> funnelEntities;

    @OneToMany(mappedBy = "userEntity",
            cascade = CascadeType.REMOVE)
    private Set<CompanyEntity> companyEntities;


    public UserEntity(String clientKey,String sharedSecret){
        this.clientKey=clientKey;
        this.sharedSecret=sharedSecret;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,clientKey,sharedSecret);
    }

    @Override
    public boolean equals(Object obj) {
        return obj!=null &&
                obj.getClass().equals(this.getClass()) &&
                Objects.equals(((UserEntity)obj).getId(),id) &&
                Objects.equals(((UserEntity)obj).getClientKey(),clientKey) &&
                Objects.equals(((UserEntity)obj).getSharedSecret(),sharedSecret);
    }
}
