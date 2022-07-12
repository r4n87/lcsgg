package dev.saariselka.inlol.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="RIOT_QUEUE_TYPE")
public class QueueTypeEntity {
    @Id
    int queueId;

    String map;
    String description;
}
