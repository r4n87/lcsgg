package dev.saariselka.inlol.dto;

import dev.saariselka.inlol.vo.ChampionVO;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Component
public class DtoMapper {

    public List<ChampionVO> ToChampionVO(List<ChampionDto> dtoList) {
        List<ChampionVO> voList = new ArrayList<>();
        for(ChampionDto dto : dtoList) {
            ChampionVO vo = new ChampionVO();
            vo.setId(dto.getId());
            vo.setImagePath(dto.getImagePath());
            vo.setNameEng(dto.getNameEng());
            vo.setNameKo(dto.getNameKo());
            voList.add(vo);
        }
        return voList;
    }
}
