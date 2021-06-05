package controller;

import model.ColorBet;
import model.NumberBet;
import model.Roulette;
import model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.ColorBetRepository;
import repositories.NumberBetRepository;
import repositories.RouletteRepository;
import repositories.UserRepository;
import request.ColorBetRequest;
import request.NumberBetRequest;

import java.util.*;

@RestController
public class RouletteController {
    private final RouletteRepository rouletteRepository;
    private final UserRepository userRepository;
    private final ColorBetRepository colorBetRepository;
    private final NumberBetRepository numberBetRepository;

    public RouletteController(RouletteRepository rouletteRepository, UserRepository userRepository, ColorBetRepository colorBetRepository, NumberBetRepository numberBetRepository) {
        this.rouletteRepository = rouletteRepository;
        this.userRepository = userRepository;
        this.colorBetRepository = colorBetRepository;
        this.numberBetRepository = numberBetRepository;
    }

    @PostMapping(path = "/roulette/create")
    public ResponseEntity<Integer> addRoulette(){
        Roulette roulette = new Roulette();
        roulette.setOn(false);
        roulette.setColorBets(null);
        roulette.setNumberBets(null);
        Roulette saved = this.rouletteRepository.save(roulette);
        int id = saved.getId();
        return ResponseEntity.ok(id);
    }

    @PutMapping(path = "/roulette/open/{id}")
    public ResponseEntity<Void> openRoulette(@PathVariable Integer id){
        Roulette optionalRoulette = this.rouletteRepository.findById(id);
        if(optionalRoulette == null){
            return ResponseEntity.badRequest().body(null);
        }
        optionalRoulette.setOn(true);
        Roulette saved = this.rouletteRepository.save(optionalRoulette);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "roulette/number/bet/{id}")
    public ResponseEntity<Void> createNumberBet(@PathVariable Integer id, @RequestBody NumberBetRequest numberBetRequest){
        User user = userRepository.findById(id);
        if(user == null || user.getMoney() < numberBetRequest.getMoney()){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Roulette roulette = rouletteRepository.findById(numberBetRequest.getRouletteId());
        NumberBet numberBet = new NumberBet();
        numberBet.setNumber(numberBetRequest.getNumber());
        numberBet.setRoulette(roulette);
        numberBet.setMoney(numberBetRequest.getMoney());
        numberBet.setUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PostMapping(path = "roulette/color/bet/{id}")
    public ResponseEntity<Void> createColorBet(@PathVariable Integer id, @RequestBody ColorBetRequest colorBetRequest){
        User user = userRepository.findById(id);
        if(user == null || user.getMoney() < colorBetRequest.getMoney()){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Roulette roulette = rouletteRepository.findById(colorBetRequest.getRouletteId());
        ColorBet colorBet = new ColorBet();
        colorBet.setColor(colorBetRequest.getColor());
        colorBet.setRoulette(roulette);
        colorBet.setMoney(colorBetRequest.getMoney());
        colorBet.setUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping(path = "roulette/close/{id}")
    public ResponseEntity<List<String>> closeRoulette(@PathVariable Integer id){
        List<String> resultados =  new ArrayList<>();
        Roulette roulette = rouletteRepository.findById(id);
        roulette.setOn(false);
        Roulette saved = rouletteRepository.save(roulette);
        List<NumberBet> numberBets = numberBetRepository.findByRouletteId(id);
        for(NumberBet nb : numberBets){
            User user = userRepository.findById(nb.getUser().getId());
            if(nb.bet()){
                user.setMoney(user.getMoney() + nb.getMoney()*5);
                resultados.add("win: " + nb.getMoney()*5 + ", id number bet: " + nb.getId());
            }else{
                user.setMoney(user.getMoney() - nb.getMoney());
                resultados.add("lose: " + nb.getMoney() + ", id number bet: " + nb.getId());
            }
        }
        List<ColorBet> colorBets = colorBetRepository.findByRouletteId(id);
        for(ColorBet cb : colorBets){
            User user = userRepository.findById(cb.getId());
            if(cb.bet()){
                user.setMoney(user.getMoney() + cb.getMoney()*1.8);
                resultados.add("win: " + cb.getMoney()*1.8 + ", id color bet: " + cb.getId());
            }else{
                user.setMoney(user.getMoney() - cb.getMoney());
                resultados.add("lose: " + cb.getMoney() + ", id number bet: " + cb.getId());
            }
        }
        return ResponseEntity.ok().body(resultados);
    }

    @GetMapping(path = "roulette/all")
    public ResponseEntity<List<Roulette>> getRoulettes(){
        Map<String, Roulette> hashRoulettes = rouletteRepository.findAll();
        List<Roulette> roulettes = (List<Roulette>) hashRoulettes.values();
        return ResponseEntity.ok().body(roulettes);
    }

}
