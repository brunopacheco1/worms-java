package com.github.brunopacheco1.worms.evaluation;

import java.util.List;
import java.util.Random;
import static java.util.stream.Collectors.toSet;
import java.util.stream.Stream;

import com.github.brunopacheco1.worms.domain.*;
import com.github.brunopacheco1.worms.dto.*;

public class NewFoodLocationEvaluator extends Evaluator {

  @Override
  void doEvaluation(MapInfo lastMap, MapInfo currentMap) {
    var playersLastPointIsEqualFoodPoint = currentMap.getStillPlaying()
      .map(this::lastPoint)
      .anyMatch(p -> p.equals(currentMap.getFoodPosition()));

    if (playersLastPointIsEqualFoodPoint) {
      defineNewFoodPosition(currentMap);
    }
  }

  private Point lastPoint(MapPlayerInfo player) {
    var points = player.getPosition();
    return points.get(points.size() - 1);
  }
  
  private void defineNewFoodPosition(MapInfo currentMap) {
    var lastMapIndex = currentMap.getMapSize() - 1;
    var allOccupiedPoints = currentMap.getStillPlaying().flatMap(p -> p.getPosition().stream()).collect(toSet());
    var random = new Random();
    Point newFood;
    while (true) {
      newFood = new Point(random.nextInt(lastMapIndex), random.nextInt(lastMapIndex));
      if (!allOccupiedPoints.contains(newFood)) break;
    }
    currentMap.setFoodPosition(newFood);
  }
}
