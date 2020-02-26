package com.github.brunopacheco1.worms.evaluation;

import java.util.Arrays;
import java.util.List;
import com.github.brunopacheco1.worms.domain.*;
import com.github.brunopacheco1.worms.dto.*;

public class InitializerEvaluator extends Evaluator {

  private static final int INITIAL_WORM_LENGTH = 2;

  @Override
  void doEvaluation(MapInfo lastMap, MapInfo currentMap) {
    // TODO Transfer intialization of the currentMap when creating the currentMap object by copying the lastMap attributes
    if (lastMap == null) {
      var mapSize = lastMap.getMapSize();
      currentMap.setFoodPosition(new Point(mapSize / 2, mapSize / 2));
      currentMap.setRoundCounter(1);
      for(int index = 0; index < currentMap.getPlayers().size(); index++) {
        var player = currentMap.getPlayers().get(index);
        player.setDirection(calculateInitialDirection(index, currentMap.getPlayers().size()));
        player.setPosition(calculateInitialPosition(player.getDirection(), mapSize));
        player.setWormLength(INITIAL_WORM_LENGTH);
      }
    }
  }

  private Direction calculateInitialDirection(int index, int playersSize) {
    return Direction.values()[index % playersSize];
  }

  private List<Point> calculateInitialPosition(Direction dir, int mapSize) {
    switch (dir) {
      case UP: return Arrays.asList(new Point(0, 0), new Point(0, 1));
      case RIGHT: return Arrays.asList(new Point(0, mapSize - 1), new Point(1, mapSize - 1));
      case DOWN: return Arrays.asList(new Point(mapSize - 1, mapSize - 1), new Point(mapSize - 1, mapSize - 2));
      case LEFT: return Arrays.asList(new Point(mapSize - 1, 0), new Point(mapSize - 2, 0));
      default: throw new IllegalArgumentException("Not expected direction");
    }
  }
}

