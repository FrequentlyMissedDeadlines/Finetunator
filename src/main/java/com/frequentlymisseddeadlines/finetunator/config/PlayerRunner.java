package com.frequentlymisseddeadlines.finetunator.config;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode
public class PlayerRunner {
    @Getter @Setter
    private String id;
    @Getter @Setter
    private String command;
}
