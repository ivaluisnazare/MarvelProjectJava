package com.projectmarvel.projectmarvelDio.controller;

import com.projectmarvel.projectmarvelDio.document.Heroes;
import com.projectmarvel.projectmarvelDio.repository.HeroesRepository;
import com.projectmarvel.projectmarvelDio.service.HeroesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static com.projectmarvel.projectmarvelDio.constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@RestController
@Slf4j
public class HeroesController {
    HeroesService heroesService;
    HeroesRepository heroesRepository;

    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(HeroesController.class);

    public HeroesController(HeroesService heroesService, HeroesRepository heroesRepository) {
        this.heroesService = heroesService;
        this.heroesRepository = heroesRepository;
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Heroes> getAllItems() {
        log.info("requesting the list off all heroes");
        return heroesService.findAll();
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<Heroes>> findByIdHero(@PathVariable String id) {
        log.info("Requesting the hero with id {}", id);
        return heroesService.findByIdHero(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Heroes> createHero(@RequestBody Heroes heroes) {
        log.info("A new Hero was Created");
        return heroesService.save(heroes);
    }

    @DeleteMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    public Mono<HttpStatus> deletebyIDHero(@PathVariable String id) {
        try {
            heroesService.deletebyIDHero(id);
            log.info("Deleting the hero with id {}", id);
            return Mono.just(HttpStatus.OK);
        } catch (Exception e) {
            return  Mono.just(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(HEROES_ENDPOINT_LOCAL)
    public Mono<HttpStatus> deleteAll() {
            heroesService.deleteAll();
            log.info("Deleting all heroes");
            return Mono.just(HttpStatus.OK);
    }
}
