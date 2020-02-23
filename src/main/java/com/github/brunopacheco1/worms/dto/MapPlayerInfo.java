package com.github.brunopacheco1.worms.dto;

import java.util.List;
import lombok.Data;
import com.github.brunopacheco1.worms.domain.Direction;
import com.github.brunopacheco1.worms.domain.PlayerStatus;

@Data
  public class MapPlayerInfo {
  private Long id;
  private PlayerStatus status;
  private int wormLength;
  private Direction direction;
  private List<Point> position;
}

