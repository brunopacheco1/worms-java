package com.github.brunopacheco1.worms.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerInfo {
  private Long id;
  private String nickname;
}

