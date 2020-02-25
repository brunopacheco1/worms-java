package com.github.brunopacheco1.worms.mappers;

import static java.util.stream.Collectors.toSet;

import com.github.brunopacheco1.worms.domain.Match;
import com.github.brunopacheco1.worms.dto.MatchInfo;
import com.github.brunopacheco1.worms.dto.MatchToAdd;

public class MatchMapper {

  public static Match from(MatchToAdd matchToAdd) {
    return Match.builder()
      .wall(matchToAdd.getWall())
      .opponentBody(matchToAdd.getOpponentBody())
      .difficulty(matchToAdd.getDifficulty())
      .playMode(matchToAdd.getPlayMode())
      .numberOfPlayers(matchToAdd.getNumberOfPlayers())
      .mapSize(matchToAdd.getMapSize())
      .build();
  }

  public static MatchInfo from(Match match) {
    return MatchInfo.builder()
      .id(match.getId())
      .status(match.getStatus())
      .wall(match.getWall())
      .opponentBody(match.getOpponentBody())
      .difficulty(match.getDifficulty())
      .playMode(match.getPlayMode())
      .numberOfPlayers(match.getNumberOfPlayers())
      .mapSize(match.getMapSize())
      .players(match.getPlayers().stream().map(PlayerMapper::from).collect(toSet()))
      .build();
  }
}

