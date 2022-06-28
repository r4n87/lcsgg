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
