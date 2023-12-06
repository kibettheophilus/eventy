package com.theophiluskibet;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class GreetingsDataFetcher {
    private final List<Greeting> greetings = List.of(
            new Greeting("Hello from Bff"),
            new Greeting("Niaje from Bff"),
            new Greeting("Habari from Bff")
    );

    @DgsQuery
    public List<Greeting> greetings(@InputArgument String language) {
        if (language == null) {
            return greetings;
        }
        ;
        return greetings.stream().filter(greeting -> greeting.getGreeting().contains(language)).collect(Collectors.toList());
    }
}
