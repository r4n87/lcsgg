package dev.saariselka.lcsgg.repository;

import dev.saariselka.lcsgg.entity.Ban;
import dev.saariselka.lcsgg.entity.Objective;
import dev.saariselka.lcsgg.entity.Objectives;
import dev.saariselka.lcsgg.entity.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TeamRepositoryTest {
    @Autowired
    TeamRepository teamRepository;

    @Test
    void test() {
        // given
//        Team team = createTeam();
//        List<Ban> banList = createBanList(team);
//
//        // when
//        teamRepository.save(team);
//
//        // then
//        assertThat(teamRepository.findByTeamId(100)).isPresent();
//
//        Team findTeam = teamRepository.findByTeamId(100).get();
//
//        assertThat(findTeam.getTeamId()).isEqualTo(team.getTeamId());
//        assertThat(findTeam.getBans().size()).isEqualTo(banList.size());
//        assertThat(findTeam.getBans().get(0).getChampionId()).isEqualTo(banList.get(0).getChampionId());
//        assertThat(findTeam.getBans().get(0).getPickTurn()).isEqualTo(banList.get(0).getPickTurn());
//        assertThat(findTeam.getBans().get(1).getChampionId()).isEqualTo(banList.get(1).getChampionId());
//        assertThat(findTeam.getBans().get(1).getPickTurn()).isEqualTo(banList.get(1).getPickTurn());
//        assertThat(findTeam.getBans().get(2).getChampionId()).isEqualTo(banList.get(2).getChampionId());
//        assertThat(findTeam.getBans().get(2).getPickTurn()).isEqualTo(banList.get(2).getPickTurn());
    }

    Team createTeam(){
        return Team.builder()
                .win(true)
                .teamId(100)
                .objectives(Objectives.builder()
                        .baron(Objective.builder().first(true).kills(1).build())
                        .champion(Objective.builder().first(true).kills(2).build())
                        .dragon(Objective.builder().first(true).kills(3).build())
                        .inhibitor(Objective.builder().first(true).kills(4).build())
                        .riftHerald(Objective.builder().first(true).kills(5).build())
                        .tower(Objective.builder().first(true).kills(6).build())
                        .build())
                .build();
    }

    List<Ban> createBanList(Team team) {
        List<Ban> banList = new ArrayList<>();
        Ban firstBan = Ban.builder().championId(1000).pickTurn(1).team(team).build();
        Ban secondBan = Ban.builder().championId(2000).pickTurn(2).team(team).build();
        Ban thirdBan = Ban.builder().championId(3000).pickTurn(3).team(team).build();
        banList.add(firstBan);
        banList.add(secondBan);
        banList.add(thirdBan);
        return banList;
    }


}