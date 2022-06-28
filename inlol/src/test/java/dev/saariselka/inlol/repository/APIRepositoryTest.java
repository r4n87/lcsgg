package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.APIEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class APIRepositoryTest {

    @Autowired
    private APIRepository apiRepository;

    @Test
    @DisplayName("APIEntity Save Test")
    public void saveAPIEntity() {
        //given
        String category = "CATEGORY1";
        String operation = "OPERATED";
        String url = "url12345";

        //when
        APIEntity apiEntity = new APIEntity(category, operation, url);
        APIEntity apiEntityForTest = apiRepository.save(apiEntity);

        //then
        assertThat(apiEntity.getId()).isEqualTo(apiEntityForTest.getId());
        assertThat(apiEntity.getCategory()).isEqualTo(apiEntityForTest.getCategory());
        assertThat(apiEntity.getOperation()).isEqualTo(apiEntityForTest.getOperation());
        assertThat(apiEntity.getUrl()).isEqualTo(apiEntityForTest.getUrl());
    }

    @Test
    @DisplayName("APIEntity FindById Test")
    public void findAPIEntityById() {
        //given
        String categoryA = "categoryA";
        String operationA = "operationA";
        String urlA = "urlA";

        String categoryB = "categoryB";
        String operationB = "operationB";
        String urlB = "urlB";

        APIEntity apiEntityA = new APIEntity(categoryA, operationA, urlA);
        APIEntity apiEntityB = new APIEntity(categoryB, operationB, urlB);
        APIEntity apiEntityAForTest = apiRepository.save(apiEntityA);
        APIEntity apiEntityBForTest = apiRepository.save(apiEntityB);

        //when
        APIEntity apiEntityAFindById = apiRepository.findById(apiEntityAForTest.getId()).get();
        APIEntity apiEntityBFindById = apiRepository.findById(apiEntityBForTest.getId()).get();

        //then
        assertThat(apiEntityAFindById.getId()).isEqualTo(apiEntityAForTest.getId());
        assertThat(apiEntityAFindById.getCategory()).isEqualTo(apiEntityAForTest.getCategory());
        assertThat(apiEntityAFindById.getOperation()).isEqualTo(apiEntityAForTest.getOperation());
        assertThat(apiEntityAFindById.getUrl()).isEqualTo(apiEntityAForTest.getUrl());

        assertThat(apiEntityBFindById.getId()).isEqualTo(apiEntityBForTest.getId());
        assertThat(apiEntityBFindById.getCategory()).isEqualTo(apiEntityBForTest.getCategory());
        assertThat(apiEntityBFindById.getOperation()).isEqualTo(apiEntityBForTest.getOperation());
        assertThat(apiEntityBFindById.getUrl()).isEqualTo(apiEntityBForTest.getUrl());
    }

    @Test
    @DisplayName("APIEntity FindByCategoryAndOperation Test")
    public void findAPIEntityByCategoryAndOperation() {
        //given
        String categoryA = "categoryA";
        String operationA = "operationA";
        String urlA = "urlA";

        String categoryB = "categoryB";
        String operationB = "operationB";
        String urlB = "urlB";

        APIEntity apiEntityA = new APIEntity(categoryA, operationA, urlA);
        APIEntity apiEntityB = new APIEntity(categoryB, operationB, urlB);
        APIEntity apiEntityAForTest = apiRepository.save(apiEntityA);
        APIEntity apiEntityBForTest = apiRepository.save(apiEntityB);

        //when
        APIEntity apiEntityAFindByCategoryAndOperation = apiRepository.findByCategoryAndOperation(
                apiEntityAForTest.getCategory(),
                apiEntityAForTest.getOperation()).get(0);
        APIEntity apiEntityBFindByCategoryAndOperation = apiRepository.findByCategoryAndOperation(
                apiEntityBForTest.getCategory(),
                apiEntityBForTest.getOperation()).get(0);


        //then
        assertThat(apiEntityAFindByCategoryAndOperation.getId()).isEqualTo(apiEntityAForTest.getId());
        assertThat(apiEntityAFindByCategoryAndOperation.getCategory()).isEqualTo(apiEntityAForTest.getCategory());
        assertThat(apiEntityAFindByCategoryAndOperation.getOperation()).isEqualTo(apiEntityAForTest.getOperation());
        assertThat(apiEntityAFindByCategoryAndOperation.getUrl()).isEqualTo(apiEntityAForTest.getUrl());

        assertThat(apiEntityBFindByCategoryAndOperation.getId()).isEqualTo(apiEntityBForTest.getId());
        assertThat(apiEntityBFindByCategoryAndOperation.getCategory()).isEqualTo(apiEntityBForTest.getCategory());
        assertThat(apiEntityBFindByCategoryAndOperation.getOperation()).isEqualTo(apiEntityBForTest.getOperation());
        assertThat(apiEntityBFindByCategoryAndOperation.getUrl()).isEqualTo(apiEntityBForTest.getUrl());
    }
}
