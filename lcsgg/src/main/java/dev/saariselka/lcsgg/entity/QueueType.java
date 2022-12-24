package dev.saariselka.lcsgg.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="RIOT_QUEUE_TYPE")
public class QueueType extends BaseInfo{
    @Id
    int queueId;

    String map;
    String description;

    @Builder
    QueueType(int queueId, String map, String description) {
        this.queueId = queueId;
        this.map = map;
        this.description = description;
    }
}
