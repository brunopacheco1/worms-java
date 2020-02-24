package com.github.brunopacheco1.worms.dto;

import lombok.Data;
import com.github.brunopacheco1.worms.domain.*;

@Data
public class MatchToAdd {
  private Wall wall;
  private OpponentBody opponentBody;
  private Difficulty difficulty;
  private PlayMode playMode;
  private int numberOfPlayers;
  private int mapSize;
}

