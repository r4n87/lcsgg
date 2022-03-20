package dev.saariselka.inlol.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="MST_API")
public class APIEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String category;
    private String operation;

    @Column(nullable = true)
    private String url;

    public APIEntity(String category, String operation, String url) {
        this.category = category;
        this.operation = operation;
        this.url = url;
    }
}
