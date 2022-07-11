package dev.saariselka.inlol.repository;

import dev.saariselka.inlol.entity.APIKeyEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class APIKeyRepositoryTest {

    @Autowired
    private APIKeyRepository apiKeyRepository;

    @Test
    @DisplayName("Save Entity")
    public void saveAPIKeyEntity() {
        //given
        String category = "categoryA";
        String apiKey = "apiKeyA";

        //when
        APIKeyEntity apiKeyEntity = new APIKeyEntity(category, apiKey);
        APIKeyEntity apiKeyEntityForTest = apiKeyRepository.save(apiKeyEntity);

        //then
        assertThat(apiKeyEntityForTest.getId()).isEqualTo(apiKeyEntity.getId());
        assertThat(apiKeyEntityForTest.getCategory()).isEqualTo(apiKeyEntity.getCategory());
        assertThat(apiKeyEntityForTest.getApiKey()).isEqualTo(apiKeyEntity.getApiKey());

    }

    @Test
    @DisplayName("Find Entity By Category, ApiKey")
    public void findById() {
        //given
        String categoryA = "categoryA";
        String apiKeyA = "apiKeyA";

        String categoryB = "categoryB";
        String apiKeyB = "apiKeyB";

        APIKeyEntity apiKeyEntityA = new APIKeyEntity(categoryA, apiKeyA);
        APIKeyEntity apiKeyEntityB = new APIKeyEntity(categoryB, apiKeyB);
        APIKeyEntity apiKeyEntityAForTest = apiKeyRepository.save(apiKeyEntityA);
        APIKeyEntity apiKeyEntityBForTest = apiKeyRepository.save(apiKeyEntityB);

        //when
        APIKeyEntity apiKeyEntityAFindById = apiKeyRepository.findById(apiKeyEntityAForTest.getId()).get();
        APIKeyEntity apiKeyEntityBFindById = apiKeyRepository.findById(apiKeyEntityBForTest.getId()).get();

        //then
        assertThat(apiKeyEntityAFindById.getId()).isEqualTo(apiKeyEntityAForTest.getId());
        assertThat(apiKeyEntityAFindById.getCategory()).isEqualTo(apiKeyEntityAForTest.getCategory());
        assertThat(apiKeyEntityAFindById.getApiKey()).isEqualTo(apiKeyEntityAForTest.getApiKey());

        assertThat(apiKeyEntityBFindById.getId()).isEqualTo(apiKeyEntityBForTest.getId());
        assertThat(apiKeyEntityBFindById.getCategory()).isEqualTo(apiKeyEntityBForTest.getCategory());
        assertThat(apiKeyEntityBFindById.getApiKey()).isEqualTo(apiKeyEntityBForTest.getApiKey());

    }

    @Test
    @DisplayName("Find Entity By Category")
    public void findByCategory() {
        //given
        String categoryA = "categoryA";
        String apiKeyA = "apiKeyA";

        String categoryB = "categoryB";
        String apiKeyB = "apiKeyB";

        APIKeyEntity apiKeyEntityA = new APIKeyEntity(categoryA, apiKeyA);
        APIKeyEntity apiKeyEntityB = new APIKeyEntity(categoryB, apiKeyB);
        APIKeyEntity apiKeyEntityAForTest = apiKeyRepository.save(apiKeyEntityA);
        APIKeyEntity apiKeyEntityBForTest = apiKeyRepository.save(apiKeyEntityB);

        //when
        APIKeyEntity apiKeyEntityAFindByCategory = apiKeyRepository.findByCategory(apiKeyEntityAForTest.getCategory()).get(0);
        APIKeyEntity apiKeyEntityBFindByCategory = apiKeyRepository.findByCategory(apiKeyEntityBForTest.getCategory()).get(0);

        //then
        assertThat(apiKeyEntityAFindByCategory.getId()).isEqualTo(apiKeyEntityAForTest.getId());
        assertThat(apiKeyEntityAFindByCategory.getCategory()).isEqualTo(apiKeyEntityAForTest.getCategory());
        assertThat(apiKeyEntityAFindByCategory.getApiKey()).isEqualTo(apiKeyEntityAForTest.getApiKey());

        assertThat(apiKeyEntityBFindByCategory.getId()).isEqualTo(apiKeyEntityBForTest.getId());
        assertThat(apiKeyEntityBFindByCategory.getCategory()).isEqualTo(apiKeyEntityBForTest.getCategory());
        assertThat(apiKeyEntityBFindByCategory.getApiKey()).isEqualTo(apiKeyEntityBForTest.getApiKey());
    }
}
