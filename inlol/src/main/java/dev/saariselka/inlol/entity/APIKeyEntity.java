package dev.saariselka.inlol.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
//@RequiredArgsConstructor 빌드에러로 주석처리
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="MST_KEY")
public class APIKeyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
    private String apiKey;

    public APIKeyEntity(String category, String apiKey) {
        this.category = category;
        this.apiKey = apiKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        APIKeyEntity that = (APIKeyEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
