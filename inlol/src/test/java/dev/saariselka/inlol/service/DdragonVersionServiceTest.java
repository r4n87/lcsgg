package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.DdragonVersionEntity;
import dev.saariselka.inlol.repository.DdragonVersionRepository;
import dev.saariselka.inlol.vo.DdragonVersionVO;
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
    @Autowired
    private VOMapper voMapper;

    @Test
    @DisplayName("Find All Entities")
    public void findAll() {
        //given
        List<DdragonVersionVO> ddragonVersionVOListA = ddragonVersionService.findAll();
        ddragonVersionRepository.save(new DdragonVersionEntity("versionA", "currentA"));

        //when
        List<DdragonVersionVO> ddragonVersionVOListB = ddragonVersionService.findAll();

        //then
        assertThat(ddragonVersionVOListB.size()).isEqualTo(ddragonVersionVOListA.size() + 1);
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
        DdragonVersionVO ddragonVersionVOFindById
                = ddragonVersionService.findById(ddragonVersionEntityForTest.getId()).get();

        //then
        assertThat(ddragonVersionVOFindById.getId()).isEqualTo(ddragonVersionEntityForTest.getId());
        assertThat(ddragonVersionVOFindById.getVersion()).isEqualTo(ddragonVersionEntityForTest.getVersion());
        assertThat(ddragonVersionVOFindById.getCurrent()).isEqualTo(ddragonVersionEntityForTest.getCurrent());
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
        DdragonVersionVO ddragonVersionVOFindByCurrent
                = ddragonVersionService.findByCurrent(ddragonVersionEntityForTest.getCurrent()).get(0);

        //then
        assertThat(ddragonVersionVOFindByCurrent.getId()).isEqualTo(ddragonVersionEntityForTest.getId());
        assertThat(ddragonVersionVOFindByCurrent.getVersion()).isEqualTo(ddragonVersionEntityForTest.getVersion());
        assertThat(ddragonVersionVOFindByCurrent.getCurrent()).isEqualTo(ddragonVersionEntityForTest.getCurrent());
    }

    @Test
    @DisplayName("Get Entity By Current Value")
    public void getCurrentDdragonVersion() {
        //given
        //when
        DdragonVersionVO currentDdragonVersion
                = ddragonVersionService.getCurrentDdragonVersion().get(0);

        //then
        assertThat(currentDdragonVersion.getCurrent()).isEqualTo("Y");
    }
}
