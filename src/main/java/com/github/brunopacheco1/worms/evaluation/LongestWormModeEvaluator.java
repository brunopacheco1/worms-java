package com.github.brunopacheco1.worms.evaluation;

import java.util.Comparator;
import java.util.stream.Collectors;

import com.github.brunopacheco1.worms.domain.*;
import com.github.brunopacheco1.worms.dto.*;

public class LongestWormModeEvaluator extends Evaluator {
  
  @Override
  void doEvaluation(MapInfo lastMap, MapInfo currentMap) {
    if (currentMap.getStatus() == MatchStatus.FINISHED) {
      var player = currentMap.getPlayers().stream()
        .collect(Collectors
            .maxBy(Comparator.comparing(MapPlayerInfo::getWormLength)));

      player.ifPresent(p -> p.setStatus(PlayerStatus.WINNER));
    }
  }
}

