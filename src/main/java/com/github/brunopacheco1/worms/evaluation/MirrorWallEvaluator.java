package com.github.brunopacheco1.worms.evaluation;

import java.util.List;
import java.util.stream.Collectors;

import com.github.brunopacheco1.worms.domain.*;
import com.github.brunopacheco1.worms.dto.*;

public class MirrorWallEvaluator extends Evaluator {

  @Override
  void doEvaluation(MapInfo lastMap, MapInfo currentMap) {
    currentMap.getStillPlaying().forEach(player -> {
        var mapSize = currentMap.getMapSize();
        var lastIndex = player.getPosition().size() - 1;
        var lastPoint = player.getPosition().get(lastIndex);

        if (lastPoint.getX() < 0) {
          setNewPosition(player, new Point(mapSize - 1, lastPoint.getY()));
        } else if (lastPoint.getX() >= mapSize) {
          setNewPosition(player, new Point(0, lastPoint.getY()));
        } else if (lastPoint.getY() < 0) {
          setNewPosition(player, new Point(lastPoint.getX(), mapSize - 1));
        } else if (lastPoint.getY() >= mapSize) {
          setNewPosition(player, new Point(lastPoint.getX(), 0));
        }
      });
  }

  private void setNewPosition(MapPlayerInfo player, Point newLastPoint) {
    var lastIndex = player.getPosition().size() - 1;
    var newPosition = player.getPosition().subList(0, lastIndex);
    newPosition.add(newLastPoint);
    player.setPosition(newPosition);
  }
}

