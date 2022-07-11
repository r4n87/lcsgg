package dev.saariselka.inlol.controller;

import dev.saariselka.inlol.entity.APIKeyEntity;
import dev.saariselka.inlol.repository.APIKeyRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class APIKeyControllerTest {
    @Autowired
    private APIKeyController apiKeyController;
    @Autowired
    private APIKeyRepository apiKeyRepository;

    @Test
    @DisplayName("Find API Key By Category")
    public void getAPIKeyByCategory() {
        //given
        String category = "categoryA";
        String apiKey = "apiKeyA";

        APIKeyEntity apiKeyEntity = new APIKeyEntity(category, apiKey);
        APIKeyEntity apiKeyEntityForTest = apiKeyRepository.save(apiKeyEntity);

        //when
        String apiKeyByCategory = apiKeyController.getAPIKeyByCategory(apiKeyEntityForTest.getCategory());

        //then
        assertThat(apiKeyByCategory).isEqualTo(apiKeyEntityForTest.getApiKey());
    }
}
