package dev.saariselka.inlol.service;

import dev.saariselka.inlol.entity.APIKeyEntity;
import dev.saariselka.inlol.repository.APIKeyRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class APIKeyServiceTest {

    @Autowired
    private APIKeyService apiKeyService;
    @Autowired
    private APIKeyRepository apiKeyRepository;

    @Test
    @DisplayName("Find All Entities")
    public void findAll() {
        //given
        List<APIKeyEntity> apiKeyEntityListA = apiKeyService.findAll();
        apiKeyRepository.save(new APIKeyEntity("categoryA", "apiKeyA"));

        //when
        List<APIKeyEntity> apiKeyEntityListB = apiKeyService.findAll();

        //then
        assertThat(apiKeyEntityListB.size()).isEqualTo(apiKeyEntityListA.size() + 1);
    }

    @Test
    @DisplayName("Find Entity By Id")
    public void findById() {
        //given
        String category = "categoryA";
        String apiKey = "apiKeyA";

        APIKeyEntity apiKeyEntity = new APIKeyEntity(category, apiKey);
        APIKeyEntity apiKeyEntityForTest = apiKeyRepository.save(apiKeyEntity);

        //when
        APIKeyEntity apiKeyEntityFindById = apiKeyService.findById(apiKeyEntityForTest.getId()).get();

        //then
        assertThat(apiKeyEntityFindById.getId()).isEqualTo(apiKeyEntityForTest.getId());
        assertThat(apiKeyEntityFindById.getCategory()).isEqualTo(apiKeyEntityForTest.getCategory());
        assertThat(apiKeyEntityFindById.getApiKey()).isEqualTo(apiKeyEntityForTest.getApiKey());
    }

    @Test
    @DisplayName("Find Entity By Category")
    public void findByCategory() {
        //given
        String category = "categoryA";
        String apiKey = "apiKeyA";

        APIKeyEntity apiKeyEntity = new APIKeyEntity(category, apiKey);
        APIKeyEntity apiKeyEntityForTest = apiKeyRepository.save(apiKeyEntity);

        //when
        APIKeyEntity apiKeyEntityFindByCategory = apiKeyService.findByCategory(apiKeyEntityForTest.getCategory()).get(0);

        //then
        assertThat(apiKeyEntityFindByCategory.getId()).isEqualTo(apiKeyEntityForTest.getId());
        assertThat(apiKeyEntityFindByCategory.getCategory()).isEqualTo(apiKeyEntityForTest.getCategory());
        assertThat(apiKeyEntityFindByCategory.getApiKey()).isEqualTo(apiKeyEntityForTest.getApiKey());
    }
}
