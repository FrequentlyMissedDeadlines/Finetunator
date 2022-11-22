package com.frequentlymisseddeadlines.finetunator.config;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode
public class FinetunatorConfig {
    @Getter @Setter
    private List<PlayerRunner> players;
    @Getter @Setter
    private List<Integer> seeds;
    @Getter @Setter
    private Integer numberOfGames;

    public static final FinetunatorConfig ExampleConfig = new FinetunatorConfig(Arrays.asList(new PlayerRunner("java1", "java Player"), new PlayerRunner("python1", "python player.py")), new ArrayList<>(), 100);


}
