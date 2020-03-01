package com.github.brunopacheco1.worms.evaluation;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.maxBy;

import com.github.brunopacheco1.worms.domain.*;
import com.github.brunopacheco1.worms.dto.*;

public class LongestWormModeEvaluator extends Evaluator {
  
  @Override
  void doEvaluation(MapInfo lastMap, MapInfo currentMap) {
    if (currentMap.getStatus().equals(MatchStatus.FINISHED)) {
      var player = currentMap.getPlayers().stream()
        .collect(maxBy(comparing(MapPlayerInfo::getWormLength)));
      player.ifPresent(p -> p.setStatus(PlayerStatus.WINNER));
    }
  }
}

