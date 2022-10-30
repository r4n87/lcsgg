package dev.saariselka.lcsgg.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
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
