package dev.saariselka.inlol.vo;

import java.util.List;

import dev.saariselka.inlol.entity.ChampionEntity;
import dev.saariselka.inlol.entity.QueueTypeEntity;
import dev.saariselka.inlol.entity.SummonerSpellEntity;
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

    public List<SummonerSpellVO> toSummonerSpellVOList(List<SummonerSpellEntity> summonerSpellEntities) {
        List<SummonerSpellVO> summonerSpellVOList = new ArrayList<>();
        for(SummonerSpellEntity summonerSpellEntity : summonerSpellEntities) {
            SummonerSpellVO summonerSpellVO = new SummonerSpellVO(summonerSpellEntity.getName(), summonerSpellEntity.getDescription(), summonerSpellEntity.getSpellKey(), summonerSpellEntity.getImage());
            summonerSpellVOList.add(summonerSpellVO);
        }
        return  summonerSpellVOList;
    }

    public List<SummonerSpellEntity> toSummonerSpellEntityList(List<SummonerSpellVO> summonerSpellVOList) {
        List<SummonerSpellEntity> summonerSpellEntities = new ArrayList<>();
        for(SummonerSpellVO summonerSpellVO : summonerSpellVOList) {
            SummonerSpellEntity summonerSpellEntity = new SummonerSpellEntity(summonerSpellVO.getName(), summonerSpellVO.getDescription(), summonerSpellVO.getSpellKey(), summonerSpellVO.getImage());
            summonerSpellEntities.add(summonerSpellEntity);
        }
        return  summonerSpellEntities;
    }
}
