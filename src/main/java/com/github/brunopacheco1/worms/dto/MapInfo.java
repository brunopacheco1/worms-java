package com.github.brunopacheco1.worms.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import com.github.brunopacheco1.worms.domain.MatchStatus;

@Data
@Builder
public class MapInfo {
  private Long id;
  private int roundCounter;
  private int mapSize;
  private List<MapPlayerInfo> players;
  private Point foodPosition;
  private MatchStatus status;
}

