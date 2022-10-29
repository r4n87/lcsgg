package dev.saariselka.lcsgg.repository;

import dev.saariselka.lcsgg.entity.Spell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpellRepository extends JpaRepository<Spell, Long> {
    Optional<Spell> findBySpellKey(int spellKey);
}
