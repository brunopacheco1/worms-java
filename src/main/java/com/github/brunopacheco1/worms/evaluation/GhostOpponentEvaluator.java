package com.github.brunopacheco1.worms.evaluation;

import java.util.stream.Collectors;

import com.github.brunopacheco1.worms.domain.*;
import com.github.brunopacheco1.worms.dto.*;

public class GhostOpponentEvaluator extends Evaluator {

  @Override
  void doEvaluation(MapInfo lastMap, MapInfo currentMap) {
    currentMap.getStillPlaying().forEach(player -> {
      var lastIndex = player.getPosition().size() - 1;
      var lastPoint = player.getPosition().get(lastIndex);
      var allOtherPoints = player.getPosition().subList(0, lastIndex);
      if (allOtherPoints.contains(lastPoint)) {
        player.setStatus(PlayerStatus.DEAD);
      }
    });
  }
}

