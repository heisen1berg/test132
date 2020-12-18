package sample.connect.spring.ajax.data.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="company")
@Getter
@Setter
@NoArgsConstructor
public class CompanyEntity {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name="site_url")
    private String siteUrl;

    @Column(name="description")
    private String description;

    @Column(name="country")
    private String country;

    @Column(name="city")
    private String city;

    @Column(name="agent")
    private String agent;

    @Column(name="phone")
    private String phone;

    @Column(name="email")
    private String email;

    @ManyToOne(optional = false)
    @JoinColumn(name="user_id",nullable = false)
    private UserEntity userEntity;


    public CompanyEntity(String name,UserEntity userEntity){
        this.name=name;
        this.userEntity=userEntity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,name,siteUrl,country,city,agent,phone,email,description,
                userEntity==null?null:userEntity.getId());
    }
    @Override
    public boolean equals(Object obj) {
        return obj!=null &&
                obj.getClass().equals(this.getClass()) &&
                Objects.equals(((CompanyEntity)obj).getId(),id) &&
                Objects.equals(((CompanyEntity)obj).getName(),name) &&
                Objects.equals(((CompanyEntity)obj).getSiteUrl(),siteUrl) &&
                Objects.equals(((CompanyEntity)obj).getCountry(),country) &&
                Objects.equals(((CompanyEntity)obj).getCity(),city) &&
                Objects.equals(((CompanyEntity)obj).getAgent(),agent) &&
                Objects.equals(((CompanyEntity)obj).getPhone(),phone) &&
                Objects.equals(((CompanyEntity)obj).getEmail(),email) &&
                Objects.equals(
                        ((CompanyEntity)obj).getUserEntity()==null?null:((CompanyEntity)obj).getUserEntity().getId(),
                        userEntity==null?null:userEntity.getId()
                ) &&
                Objects.equals(((CompanyEntity)obj).getDescription(),description);
    }
}