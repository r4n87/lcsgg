package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.APIEntity;
import dev.saariselka.inlol.repository.APIRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class APIServiceTest {

    @Autowired
    private APIService apiService;
    @Autowired
    private APIRepository apiRepository;

    @Test
    @DisplayName("Find All Entities")
    public void findAll() {
        //given
        List<APIEntity> apiEntityListA = apiService.findAll();
        apiRepository.save(new APIEntity("categoryA", "operationA", "urlA"));

        //when
        List<APIEntity> apiEntityListB = apiService.findAll();

        //then
        assertThat(apiEntityListB.size()).isEqualTo(apiEntityListA.size() + 1);
    }

    @Test
    @DisplayName("Find Entity By Id")
    public void findById() {
        //given
        String category = "categoryA";
        String operation = "operationA";
        String url = "urlA";

        APIEntity apiEntity = new APIEntity(category, operation, url);
        APIEntity apiEntityForTest = apiRepository.save(apiEntity);

        //when
        APIEntity apiEntityFindById = apiService.findById(apiEntityForTest.getId()).get();

        //then
        assertThat(apiEntityFindById.getId()).isEqualTo(apiEntityForTest.getId());
        assertThat(apiEntityFindById.getCategory()).isEqualTo(apiEntityForTest.getCategory());
        assertThat(apiEntityFindById.getOperation()).isEqualTo(apiEntityForTest.getOperation());
        assertThat(apiEntityFindById.getUrl()).isEqualTo(apiEntityForTest.getUrl());
    }

    @Test
    @DisplayName("Find Entity By Category, Operation")
    public void findByCategoryAndOperation() {
        //given
        String category = "categoryA";
        String operation = "operationA";
        String url = "urlA";

        APIEntity apiEntity = new APIEntity(category, operation, url);
        APIEntity apiEntityForTest = apiRepository.save(apiEntity);

        //when
        APIEntity apiEntityFindById = apiService.findByCategoryAndOperation(
                apiEntityForTest.getCategory(), apiEntityForTest.getOperation()).get(0);

        //then
        assertThat(apiEntityFindById.getId()).isEqualTo(apiEntityForTest.getId());
        assertThat(apiEntityFindById.getCategory()).isEqualTo(apiEntityForTest.getCategory());
        assertThat(apiEntityFindById.getOperation()).isEqualTo(apiEntityForTest.getOperation());
        assertThat(apiEntityFindById.getUrl()).isEqualTo(apiEntityForTest.getUrl());
    }
}
