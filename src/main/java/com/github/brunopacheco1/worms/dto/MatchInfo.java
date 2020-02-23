package com.github.brunopacheco1.worms.dto;

import java.util.Set;
import lombok.Data;
import com.github.brunopacheco1.worms.domain.*;

@Data
public class MatchInfo {
  private Long id;
  private MatchStatus status;
  private Wall wall;
  private OpponentBody opponentBody;
  private Difficulty difficulty;
  private PlayMode playMode;
  private int numberOfPlayers;
  private int mapSize;
  private Set<PlayerInfo> players;
}

