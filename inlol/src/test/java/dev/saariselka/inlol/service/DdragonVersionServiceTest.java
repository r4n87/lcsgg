package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.APIKeyEntity;
import dev.saariselka.inlol.entity.DdragonVersionEntity;
import dev.saariselka.inlol.repository.DdragonVersionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class DdragonVersionServiceTest {

    @Autowired
    private DdragonVersionService ddragonVersionService;
    @Autowired
    private DdragonVersionRepository ddragonVersionRepository;

    @Test
    @DisplayName("Find All Entities")
    public void findAll() {
        //given
        List<DdragonVersionEntity> ddragonVersionEntityListA = ddragonVersionService.findAll();
        ddragonVersionRepository.save(new DdragonVersionEntity("versionA", "currentA"));

        //when
        List<DdragonVersionEntity> ddragonVersionEntityListB = ddragonVersionService.findAll();

        //then
        assertThat(ddragonVersionEntityListB.size()).isEqualTo(ddragonVersionEntityListA.size() + 1);
    }

    @Test
    @DisplayName("Find Entity By Id")
    public void findById() {
        //given
        String version = "versionA";
        String current = "currentA";

        DdragonVersionEntity ddragonVersionEntity = new DdragonVersionEntity(version, current);
        DdragonVersionEntity ddragonVersionEntityForTest = ddragonVersionRepository.save(ddragonVersionEntity);

        //when
        DdragonVersionEntity ddragonVersionEntityFindById
                = ddragonVersionService.findById(ddragonVersionEntityForTest.getId()).get();

        //then
        assertThat(ddragonVersionEntityFindById.getId()).isEqualTo(ddragonVersionEntityForTest.getId());
        assertThat(ddragonVersionEntityFindById.getVersion()).isEqualTo(ddragonVersionEntityForTest.getVersion());
        assertThat(ddragonVersionEntityFindById.getCurrent()).isEqualTo(ddragonVersionEntityForTest.getCurrent());
    }

    @Test
    @DisplayName("Find Entity By Current")
    public void findByCurrent() {
        //given
        String version = "versionA";
        String current = "currentA";

        DdragonVersionEntity ddragonVersionEntity = new DdragonVersionEntity(version, current);
        DdragonVersionEntity ddragonVersionEntityForTest = ddragonVersionRepository.save(ddragonVersionEntity);

        //when
        DdragonVersionEntity ddragonVersionEntityFindByCurrent
                = ddragonVersionService.findByCurrent(ddragonVersionEntityForTest.getCurrent()).get(0);

        //then
        assertThat(ddragonVersionEntityFindByCurrent.getId()).isEqualTo(ddragonVersionEntityForTest.getId());
        assertThat(ddragonVersionEntityFindByCurrent.getVersion()).isEqualTo(ddragonVersionEntityForTest.getVersion());
        assertThat(ddragonVersionEntityFindByCurrent.getCurrent()).isEqualTo(ddragonVersionEntityForTest.getCurrent());
    }

    @Test
    @DisplayName("Get Entity By Current Value")
    public void getCurrentDdragonVersion() {
        //given
        //when
        DdragonVersionEntity currentDdragonVersion
                = ddragonVersionService.getCurrentDdragonVersion().get(0);

        //then
        assertThat(currentDdragonVersion.getCurrent()).isEqualTo("Y");
    }
}
