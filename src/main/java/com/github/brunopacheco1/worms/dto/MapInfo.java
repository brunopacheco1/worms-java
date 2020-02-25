package com.github.brunopacheco1.worms.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import com.github.brunopacheco1.worms.domain.*;

@Data
@Builder
public class MapInfo {
  private Long id;
  private MatchStatus status;
  private Wall wall;
  private OpponentBody opponentBody;
  private Difficulty difficulty;
  private PlayMode playMode;
  private int mapSize;
  private int roundCounter;
  private List<MapPlayerInfo> players;
  private Point foodPosition;
}

