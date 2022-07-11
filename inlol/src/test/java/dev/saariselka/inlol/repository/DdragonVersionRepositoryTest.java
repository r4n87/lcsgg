package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.DdragonVersionEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DdragonVersionRepositoryTest {

    @Autowired
    private DdragonVersionRepository ddragonVersionRepository;

    @Test
    @DisplayName("Save Entity")
    public void saveDdragonVersionEntity() {
        //given
        String version = "2";
        String current = "3";

        //when
        DdragonVersionEntity ddragonVersionEntity = new DdragonVersionEntity(version, current);
        DdragonVersionEntity ddragonVersionEntityForTest = ddragonVersionRepository.save(ddragonVersionEntity);

        //then
        assertThat(ddragonVersionEntity.getId()).isEqualTo(ddragonVersionEntityForTest.getId());
        assertThat(ddragonVersionEntity.getVersion()).isEqualTo(ddragonVersionEntityForTest.getVersion());
        assertThat(ddragonVersionEntity.getCurrent()).isEqualTo(ddragonVersionEntityForTest.getCurrent());
    }

    @Test
    @DisplayName("Find Entity By Version, Current")
    public void findDdragonVersionEntityById() {
        //given
        String versionA = "versionA";
        String currentA = "currentA";
        String versionB = "versionB";
        String currentB = "currentB";

        DdragonVersionEntity ddragonVersionEntityA = new DdragonVersionEntity(versionA, currentA);
        DdragonVersionEntity ddragonVersionEntityB = new DdragonVersionEntity(versionB, currentB);

        DdragonVersionEntity ddragonVersionEntityAForTest = ddragonVersionRepository.save(ddragonVersionEntityA);
        DdragonVersionEntity ddragonVersionEntityBForTest = ddragonVersionRepository.save(ddragonVersionEntityB);

        //when
        DdragonVersionEntity ddragonVersionEntityAFindById
                = ddragonVersionRepository.findById(ddragonVersionEntityAForTest.getId()).get();
        DdragonVersionEntity ddragonVersionEntityBFindById
                = ddragonVersionRepository.findById(ddragonVersionEntityBForTest.getId()).get();

        //then
        assertThat(ddragonVersionEntityAFindById.getId()).isEqualTo(ddragonVersionEntityAForTest.getId());
        assertThat(ddragonVersionEntityAFindById.getVersion()).isEqualTo(ddragonVersionEntityAForTest.getVersion());
        assertThat(ddragonVersionEntityAFindById.getCurrent()).isEqualTo(ddragonVersionEntityAForTest.getCurrent());
        assertThat(ddragonVersionEntityBFindById.getId()).isEqualTo(ddragonVersionEntityBForTest.getId());
        assertThat(ddragonVersionEntityBFindById.getVersion()).isEqualTo(ddragonVersionEntityBForTest.getVersion());
        assertThat(ddragonVersionEntityBFindById.getCurrent()).isEqualTo(ddragonVersionEntityBForTest.getCurrent());
    }

    @Test
    @DisplayName("Find Entity By Current")
    public void findDdragonVersionEntityByCurrent() {
        //given
        String versionA = "versionA";
        String currentA = "currentA";
        String versionB = "versionB";
        String currentB = "currentB";

        DdragonVersionEntity ddragonVersionEntityA = new DdragonVersionEntity(versionA, currentA);
        DdragonVersionEntity ddragonVersionEntityB = new DdragonVersionEntity(versionB, currentB);

        DdragonVersionEntity ddragonVersionEntityAForTest = ddragonVersionRepository.save(ddragonVersionEntityA);
        DdragonVersionEntity ddragonVersionEntityBForTest = ddragonVersionRepository.save(ddragonVersionEntityB);

        //when
        DdragonVersionEntity ddragonVersionEntityAFindByCurrent
                = ddragonVersionRepository.findByCurrent(ddragonVersionEntityAForTest.getCurrent()).get(0);
        DdragonVersionEntity ddragonVersionEntityBFindByCurrent
                = ddragonVersionRepository.findByCurrent(ddragonVersionEntityBForTest.getCurrent()).get(0);

        //then
        assertThat(ddragonVersionEntityAFindByCurrent.getId()).isEqualTo(ddragonVersionEntityAForTest.getId());
        assertThat(ddragonVersionEntityAFindByCurrent.getVersion()).isEqualTo(ddragonVersionEntityAForTest.getVersion());
        assertThat(ddragonVersionEntityAFindByCurrent.getCurrent()).isEqualTo(ddragonVersionEntityAForTest.getCurrent());
        assertThat(ddragonVersionEntityBFindByCurrent.getId()).isEqualTo(ddragonVersionEntityBForTest.getId());
        assertThat(ddragonVersionEntityBFindByCurrent.getVersion()).isEqualTo(ddragonVersionEntityBForTest.getVersion());
        assertThat(ddragonVersionEntityBFindByCurrent.getCurrent()).isEqualTo(ddragonVersionEntityBForTest.getCurrent());
    }

    @Test
    @DisplayName("Get Entity By Current")
    public void getDdragonVersionEntityByCurrent() {
        //given
        //when
        DdragonVersionEntity currentDdragonVersion
                = ddragonVersionRepository.getCurrentDdragonVersion().get(0);

        //then
        assertThat(currentDdragonVersion.getCurrent()).isEqualTo("Y");
    }
}
