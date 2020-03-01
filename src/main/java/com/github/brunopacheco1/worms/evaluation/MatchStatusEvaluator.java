package com.github.brunopacheco1.worms.evaluation;

import com.github.brunopacheco1.worms.domain.*;
import com.github.brunopacheco1.worms.dto.*;

public class MatchStatusEvaluator extends Evaluator {

  @Override
  void doEvaluation(MapInfo lastMap, MapInfo currentMap) {
    if (currentMap.getStillPlayingPlayers().count() == 0) {
      currentMap.setStatus(MatchStatus.FINISHED);
    }
  }
}
