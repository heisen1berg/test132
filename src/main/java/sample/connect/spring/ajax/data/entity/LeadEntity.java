package sample.connect.spring.ajax.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="lead")
@Getter
@Setter
@NoArgsConstructor
public class LeadEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;


    @Column(name="title",nullable = false)
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="date_created",nullable = false)
    private Date dateCreated = new Date();

    @ManyToOne(optional = false)
    @JoinColumn(name = "funnel_id",nullable = false )
    private FunnelEntity funnelEntity;


    public LeadEntity(String title,FunnelEntity funnelEntity){
        this.funnelEntity = funnelEntity;
        this.title=title;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,title,description,
                funnelEntity == null ? null : funnelEntity.getId());
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null &&
                obj.getClass().equals(this.getClass()) &&
                Objects.equals(((LeadEntity)obj).getId(),id) &&
                Objects.equals(((LeadEntity)obj).getTitle(),title) &&
                Objects.equals(((LeadEntity)obj).getDescription(),description)&&
                Objects.equals(
                        ((LeadEntity)obj).getFunnelEntity()==null ? null : ((LeadEntity)obj).getFunnelEntity().getId(),
                        funnelEntity == null? null: funnelEntity.getId()
                );
    }
}
