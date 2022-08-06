package dev.saariselka.inlol.vo;

import java.util.List;

import dev.saariselka.inlol.entity.ChampionEntity;
import dev.saariselka.inlol.entity.QueueTypeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@Component
public class VOMapper {

    public List<QueueTypeVO> ToQueueTypeVOList(List<QueueTypeEntity> entityList)
    {
        List<QueueTypeVO> voList = new ArrayList<>();

        for(QueueTypeEntity entity : entityList)
        {
            QueueTypeVO vo = new QueueTypeVO();
            vo.setQueueId(entity.getQueueId());
            vo.setMap(entity.getMap());
            vo.setDescription(entity.getDescription());
            voList.add(vo);
        }

        return voList;
    }

    public List<ChampionEntity> ToChampionEntityList(List<ChampionVO> voList)
    {
        List<ChampionEntity> entityList = new ArrayList<>();
        for(ChampionVO vo : voList)
        {
            ChampionEntity entity = new ChampionEntity();
            entity.setId(vo.getId());
            entity.setImagePath(vo.getImagePath());
            entity.setNameEng(vo.getNameEng());
            entity.setNameKo(vo.getNameKo());
            entityList.add(entity);
        }
        return entityList;
    }
}
