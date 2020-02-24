package com.github.brunopacheco1.worms.domain;

import java.util.Set;
import lombok.Builder;
import lombok.Data;
import javax.persistence.*;

@Data
@Builder
@Entity(name = "MATCH")
public class Match {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "wall")
  @Enumerated(EnumType.STRING)
  private Wall wall;

  @Column(name = "opponent_body")
  @Enumerated(EnumType.STRING)
  private OpponentBody opponentBody;

  @Column(name = "difficulty")
  @Enumerated(EnumType.STRING)
  private Difficulty difficulty;
  
  @Column(name = "play_mode")
  @Enumerated(EnumType.STRING)
  private PlayMode playMode;
  
  @Column(name = "number_of_players")
  private int numberOfPlayers;
  
  @Column(name = "map_size")
  private int mapSize;

  @Builder.Default
  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private MatchStatus status = MatchStatus.WAITING_PLAYERS;

  @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<MatchPlayer> players;
}

