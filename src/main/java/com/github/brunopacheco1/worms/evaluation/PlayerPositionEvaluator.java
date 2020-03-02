package com.github.brunopacheco1.worms.evaluation;

import java.util.Objects;

import com.github.brunopacheco1.worms.domain.*;
import com.github.brunopacheco1.worms.dto.*;
import static java.util.stream.Collectors.toList;

public class PlayerPositionEvaluator extends Evaluator {

  @Override
  void doEvaluation(MapInfo lastMap, MapInfo currentMap) {
    //TODO review if it is really required this if lastMap is null checked
    if (Objects.isNull(lastMap)) {
      var stillPlaying = currentMap.getStillPlaying().collect(toList());

      for(int index = 0; index < stillPlaying.size(); index++) {
        var currentState = stillPlaying.get(index);
        var lastState = lastMap.getPlayers().get(index);
        var newPoint = getNewLastPoint(lastPoint(lastState), currentState.getDirection());
        var startIndex = 1;
        if (newPoint.equals(currentMap.getFoodPosition())) {
          startIndex = 0;
        }

        var newPosition = lastState.getPosition().subList(startIndex, lastState.getPosition().size());
        newPosition.add(newPoint);
        currentState.setWormLength(newPosition.size());
      }
    }
  }

  private Point lastPoint(MapPlayerInfo player) {
    var points = player.getPosition();
    return points.get(points.size() - 1);
  }

  private Point getNewLastPoint(Point lastPoint, Direction direction) {
    switch(direction) {
      case UP: return new Point(lastPoint.getX(), lastPoint.getY() + 1);
      case RIGHT: return new Point(lastPoint.getX() + 1, lastPoint.getY());
      case DOWN: return new Point(lastPoint.getX(), lastPoint.getY() - 1);
      case LEFT: return new Point(lastPoint.getX() - 1, lastPoint.getY());
      default: throw new IllegalArgumentException("Not expected direction");
    }
  }
}

