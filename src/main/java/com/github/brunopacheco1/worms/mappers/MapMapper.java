package com.github.brunopacheco1.worms.mappers;

import java.util.stream.Collectors;

import com.github.brunopacheco1.worms.domain.Match;
import com.github.brunopacheco1.worms.domain.MatchPlayer;
import com.github.brunopacheco1.worms.domain.Player;
import com.github.brunopacheco1.worms.dto.MapInfo;
import com.github.brunopacheco1.worms.dto.MapPlayerInfo;

public class MapMapper {

  public static MapInfo from(Match match) {
    return MapInfo.builder()
      .id(match.getId())
      .wall(match.getWall())
      .opponentBody(match.getOpponentBody())
      .difficulty(match.getDifficulty())
      .playMode(match.getPlayMode())
      .mapSize(match.getMapSize())
      .players(match.getPlayers().stream().map(MapMapper::from).collect(Collectors.toList()))
      .build();
  }

  public static MapPlayerInfo from(MatchPlayer matchPlayer) {
    Player player = matchPlayer.getPlayer();
    return MapPlayerInfo.builder()
      .id(player.getId())
      .build();
  }
}
