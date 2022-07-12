package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.entity.APIEntity;
import dev.saariselka.inlol.repository.APIRepository;
import dev.saariselka.inlol.service.APIService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional

public class APIControllerTest {
    @Autowired
    private APIController apiController;
    @Autowired
    private APIRepository apiRepository;

    @Test
    @DisplayName("Find API URl By Category, Operation")
    public void getAPIUrlByCategoryAndOperation() {
        //given
        String category = "categoryA";
        String operation = "operationA";
        String url = "urlA";

        APIEntity apiEntity = new APIEntity(category, operation, url);
        APIEntity apiEntityForTest = apiRepository.save(apiEntity);

        //when
        String urlByCategoryAndOperation = apiController.getAPIUrlByCategoryAndOperation(
                apiEntityForTest.getCategory()
                , apiEntityForTest.getOperation()
        );

        //then
        assertThat(urlByCategoryAndOperation).isEqualTo(apiEntityForTest.getUrl());
    }

}
