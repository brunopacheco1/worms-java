package com.github.brunopacheco1.worms.evaluation;

import com.github.brunopacheco1.worms.domain.*;
import com.github.brunopacheco1.worms.dto.*;

public class MatchStatusEvaluator extends Evaluator {

  @Override
  void doEvaluation(MapInfo lastMap, MapInfo currentMap) {
    if (currentMap.getPlayers().stream().allMatch(p -> p.getStatus() == PlayerStatus.DEAD)) {
      currentMap.setStatus(MatchStatus.FINISHED);
    }
  }
}
