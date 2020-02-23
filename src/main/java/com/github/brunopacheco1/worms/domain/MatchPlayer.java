package com.github.brunopacheco1.worms.domain;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "MATCH_PLAYER")
public class MatchPlayer {
 
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JoinColumn(name = "player_id")
  @ManyToOne
  private Player player;

  @JoinColumn(name = "match_id")
  @ManyToOne
  private Match match;

  @Column(name = "worm_length")
  private int wormLength = 2;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private PlayerStatus status = PlayerStatus.PLAYING;
}
