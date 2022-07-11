package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.entity.DdragonVersionEntity;
import dev.saariselka.inlol.repository.DdragonVersionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class DdragonVersionControllerTest {
    @Autowired
    private DdragonVersionController ddragonVersionController;
    @Autowired
    private DdragonVersionRepository ddragonVersionRepository;

    @Test
    @DisplayName("Find Current Ddragon Version By Current")
    public void getCurrentDdrgaonVersion() {
        //given
        DdragonVersionEntity currentDdragonVersionEntity = ddragonVersionRepository.findByCurrent("Y").get(0);
        currentDdragonVersionEntity.setCurrent("N");
        ddragonVersionRepository.save(currentDdragonVersionEntity);

        String version = "versionNow";
        String current = "Y";

        DdragonVersionEntity ddragonVersionEntity = new DdragonVersionEntity(version, current);
        DdragonVersionEntity ddragonVersionEntityForTest = ddragonVersionRepository.save(ddragonVersionEntity);

        //when
        String currentDdragonVersionByCurrent = ddragonVersionController.getCurrentDdragonVersion();

        //then
        assertThat(currentDdragonVersionByCurrent).isEqualTo(ddragonVersionEntityForTest.getVersion());
    }
}
