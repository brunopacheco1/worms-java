package com.github.brunopacheco1.worms.mappers;

import com.github.brunopacheco1.worms.domain.Player;
import com.github.brunopacheco1.worms.domain.MatchPlayer;
import com.github.brunopacheco1.worms.dto.PlayerToAdd;
import com.github.brunopacheco1.worms.dto.PlayerInfo;

public class PlayerMapper {
  
  public static Player from(PlayerToAdd playerToAdd) {
    return Player.builder()
      .nickname(playerToAdd.getNickname())
      .build();
  }

  public static PlayerInfo to(Player player) {
    return PlayerInfo.builder()
      .id(player.getId())
      .nickname(player.getNickname())
      .build();
  }

  public static PlayerInfo to(MatchPlayer player) {
    return to(player.getPlayer());
  }
}

