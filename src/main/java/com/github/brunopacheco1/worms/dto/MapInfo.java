package com.github.brunopacheco1.worms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.stream.Stream;

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

  @JsonIgnore
  public Stream<MapPlayerInfo> getStillPlaying() {
    return players.stream().filter(p -> p.getStatus().equals(PlayerStatus.PLAYING));
  }
}

