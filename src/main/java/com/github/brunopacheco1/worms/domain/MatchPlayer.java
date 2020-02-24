package com.github.brunopacheco1.worms.domain;

import lombok.Builder;
import lombok.Data;
import javax.persistence.*;

@Data
@Builder
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

  @Builder.Default
  @Column(name = "worm_length")
  private int wormLength = 2;

  @Column(name = "status")
  @Builder.Default
  @Enumerated(EnumType.STRING)
  private PlayerStatus status = PlayerStatus.PLAYING;
}
