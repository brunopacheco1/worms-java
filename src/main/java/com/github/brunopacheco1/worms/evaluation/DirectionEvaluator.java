package com.github.brunopacheco1.worms.evaluation;

import com.github.brunopacheco1.worms.domain.*;
import com.github.brunopacheco1.worms.dto.*;

public class DirectionEvaluator extends Evaluator {

  @Override
  void doEvaluation(MapInfo lastMap, MapInfo currentMap) {
    currentMap.getStillPlayingPlayers()
      .forEach(player -> {
        var newDirection = getNewDirection(player);
        if(!newDirection.isOpposite(player.getDirection())) {
          player.setDirection(newDirection);
        }
      });
  }

  private Direction getNewDirection(MapPlayerInfo player) {
    // TODO Implement a way to get the user's action
    //return MatchPool.getDirection(player.getId())) ?: player.getDirection();
    return player.getDirection();
  }
}

