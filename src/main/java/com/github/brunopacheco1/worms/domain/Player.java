package com.github.brunopacheco1.worms.domain;

import java.util.Set;
import lombok.Builder;
import lombok.Data;
import javax.persistence.*;

@Data
@Builder
@Entity(name = "PLAYER")
public class Player {
  
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nickname", nullable = false, unique = true)
  private String nickname;

  @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<MatchPlayer> matchPlayers;
}

