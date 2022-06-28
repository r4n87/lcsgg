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
    @DisplayName("APIKeyEntity Save Test")
    public void saveAPIKeyEntity() {
        //given
        Long id = 5L;
        String category = "Category1";
        String key = "RGAPI-523619a3-42fc-468c-8c38-e376e2d3fa6f";

        //when
        APIKeyEntity apiKeyEntity = new APIKeyEntity(id, category, key);
        APIKeyEntity apiKeyEntityForTest = apiKeyRepository.save(apiKeyEntity);

        //then
        assertThat(apiKeyEntity.getId()).isEqualTo(apiKeyEntityForTest.getId());
        assertThat(apiKeyEntity.getCategory()).isEqualTo(apiKeyEntityForTest.getCategory());
        assertThat(apiKeyEntity.getKey()).isEqualTo(apiKeyEntityForTest.getKey());
    }

    @Test
    @DisplayName("APIKeyEntity FindById Test")
    public void findById() {

    }

    @Test
    @DisplayName("APIKeyEntity FindByCategory Test")
    public void findByCategory() {

    }
}
