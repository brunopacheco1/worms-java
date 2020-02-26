package com.github.brunopacheco1.worms.evaluation;

import java.util.stream.Collectors;

import com.github.brunopacheco1.worms.domain.*;
import com.github.brunopacheco1.worms.dto.*;

public class GhostOpponentEvaluator extends Evaluator {

  @Override
  void doEvaluation(MapInfo lastMap, MapInfo currentMap) {
    currentMap.getPlayers().stream()
      .filter(p -> p.getStatus() == PlayerStatus.PLAYING)
      .forEach(player -> {
        var lastPoint = player.getPosition().get(player.getPosition().size() - 1);
        var allOtherPoints = player.getPosition().subList(0, player.getPosition().size() - 1);
        if (allOtherPoints.contains(lastPoint)) {
          player.setStatus(PlayerStatus.DEAD);
        }
      });
  }
}

