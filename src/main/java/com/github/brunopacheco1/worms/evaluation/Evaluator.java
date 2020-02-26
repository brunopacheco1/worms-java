package com.github.brunopacheco1.worms.evaluation;

import java.util.Optional;
import com.github.brunopacheco1.worms.dto.MapInfo;

public abstract class Evaluator {

  private Optional<Evaluator> next = Optional.empty();

  public void link(Evaluator next) {
    this.next = Optional.of(next);
  }

  public void evaluate(MapInfo lastMap, MapInfo currentMap) {
    doEvaluation(lastMap, currentMap);
    next.ifPresent(n -> n.evaluate(lastMap, currentMap));
  }

  abstract void doEvaluation(MapInfo lastMap, MapInfo currentMap);
}
