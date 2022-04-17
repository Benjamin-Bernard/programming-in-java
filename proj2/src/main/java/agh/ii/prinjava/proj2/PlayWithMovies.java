package agh.ii.prinjava.proj2;

import agh.ii.prinjava.proj2.dal.ImdbTop250;
import agh.ii.prinjava.proj2.model.Movie;
import agh.ii.prinjava.proj2.utils.Utils;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

interface PlayWithMovies {

     Optional<List<Movie>> movies = ImdbTop250.movies();
    /**
     * Returns the movies (only titles) directed (or co-directed) by a given director
     */
    static Set<String> ex01(String director) {

        return  movies.orElseThrow().stream()
                .filter(m -> m.directors().contains(director))
                .map(Movie::title)
                .collect(Collectors.toSet());
    }

    /**
     * Returns the movies (only titles) in which an actor played
     */
    static Set<String> ex02(String actor) {
        final Set<String> moviesActors = movies.orElseThrow().stream()
                .filter(m -> m.actors().contains(actor))
                .map(m -> "" + m.title())
                .collect(Collectors.toSet());
        return moviesActors;
    }

    /**
     * Returns the number of movies per director (as a map)
     */
    static Map<String, Long> ex03() {
          final Map<String, Long> nbMoviesPerDirector = movies.orElseThrow().stream()
                  .map(Utils::oneToManyByDirector)
                  .flatMap(Collection::stream)
                  .collect(
                          Collectors.groupingBy(m -> m.directors().get(0),
                                  Collectors.counting()
                          )
                  )
                  ;
          return nbMoviesPerDirector;

    }


    /**
     * Returns the 10 directors with the most films on the list
     */
    static Map<String, Long> ex04() {
        final Map<String,Long> tenMostFreqDirectors = ex03().entrySet().stream()
                .sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                .limit(10)
                        .collect(
                                Collectors.toMap(e -> e.getKey(),e -> e.getValue())
                        );
        return tenMostFreqDirectors;
    }

    /**
     * Returns the movies (only titles) made by each of the 10 directors found in {@link PlayWithMovies#ex04 ex04}
     */
    static Map<String, Set<String>> ex05() {
        final Map<String, Set<String>> moviesPerDirector = ex04().entrySet().stream()

                .collect(
                        Collectors.toMap(e -> e.getKey(),e -> ex01(e.getKey()))
                );
        return moviesPerDirector;
    }

    /**
     * Returns the number of movies per actor (as a map)
     */
    static Map<String, Long> ex06() {
        final Map<String, Long> nbMoviesPerActor = movies.orElseThrow().stream()
                .map(Utils::oneToManyByActor)
                .flatMap(Collection::stream)
                .collect(
                        Collectors.groupingBy(m -> m.actors().get(0),
                                Collectors.counting()
                        )
                )
                ;

        return nbMoviesPerActor;
    }

    /**
     * Returns the 9 actors with the most films on the list
     */
    static Map<String, Long> ex07() {
        final Map<String,Long> nineMostFreqActors = ex06().entrySet().stream()
                .sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                .limit(9)
                .collect(
                        Collectors.toMap(e -> e.getKey(),e -> e.getValue())
                );
        return nineMostFreqActors;
    }

    /**
     * Returns the movies (only titles) of each of the 9 actors from {@link PlayWithMovies#ex07 ex07}
     */
    static Map<String, Set<String>> ex08() {
        final Map<String, Set<String>> moviesPerActors = ex07().entrySet().stream()

                .collect(
                        Collectors.toMap(e -> e.getKey(),e -> ex02(e.getKey()))
                );
        return moviesPerActors;
    }

    /**
     * Returns the 5 most frequent actor partnerships (i.e., appearing together most often)
     */
    static Map<String, Long> ex09() {
        final Map<String, Long> nbMoviesPerActorDuos = movies.orElseThrow().stream()
                .map(Utils::oneToManyByActorDuo)
                .flatMap(Collection::stream)
                .collect(
                        Collectors.groupingBy(m -> m.actors().get(0),
                                Collectors.counting()
                        )
                )
                ;
        final Map<String,Long> fiveMostFreqActorDuos = nbMoviesPerActorDuos.entrySet().stream()
                .sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                .limit(5)
                .collect(
                        Collectors.toMap(e -> e.getKey(),e -> e.getValue())
                );
        return fiveMostFreqActorDuos;
    }

    /**
     * Returns the movies (only titles) of each of the 5 most frequent actor partnerships
     */
    static Map<String, Set<String>> ex10() {
        final  Set<String> ActorDuos = ex09().keySet();
        final Map<String, List<Movie> >  l= movies.orElseThrow().stream()
                .map(Utils::oneToManyByActorDuo)
                .flatMap(Collection::stream)
                .filter(m -> ActorDuos.contains(m.actors().get(0)))
                .collect(
                        Collectors.groupingBy(m -> m.actors().get(0))
                );

        final Map<String, Set<String>> moviesPerActorDuo =l.entrySet().stream()
                .collect(
                        Collectors.toMap(Map.Entry::getKey, m->m.getValue().stream()
                                .map(f->f.title())
                                .collect(Collectors.toSet()))

                );
        return moviesPerActorDuo;
    }
}

