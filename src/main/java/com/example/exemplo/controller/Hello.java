package com.example.exemplo.controller;

import com.example.exemplo.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController //indica que está classe é um controller Rest
@RequestMapping("/user") // indica que o "/user" é usado para acionar este controller -- endpoint
public class Hello {

       /* @GetMapping("/ola") //Este método é acionado por uma requisição GET -> agora eu acesso pelo localhost:8080/user/ola, pq tem RequestMapping p user e p meu get p o ola
        public String digtaHello(){
            return "Olá!";
        }*/


    @GetMapping("/ola/{nome}")
    public String digtaHello(@PathVariable String nome) { //estou dizendo que o nome vai vir no corpo da url -> localhost:8080/user/ola/bianca
        return "Olá!" + nome;
    }

   /* @GetMapping("/ola/{nome}{id}")
    public String digtaHello(@PathVariable String nome, @PathVariable Int id) { //estou dizendo que o nome vai vir no corpo da url -> localhost:8080/user/ola/bianca/1
        return "Olá!" + nome + " " + id;
    }*/


    @GetMapping("/ola")
    public String digtaHello2(@RequestParam String nome) { //estou dizendo que o nome vai vir no corpo da url, mas de forma diferente do PathVariable -> o RequestParam fica assim localhost:8080/user/ola?nome=bianca
        return "Olá!" + nome;
    }

     /* @GetMapping("/ola")
    public String digtaHello(@RequestParam String nome,@RequestParam int id) { //estou dizendo que o nome vai vir no corpo da url, mas de forma diferente do PathVariable -> o RequestParam fica assim localhost:8080/user/ola?nome=bianca&id=123
        return "Olá!" + nome + " " + id;
    }*/

    @PostMapping
    public ResponseEntity<UserDto> getUser(@RequestBody User user){ //o ResponseEntity é uma classe do spring, ele recebe um generics, então estou dizendo
        if(user.getId() == 123){
            UserDto userDto = new UserDto(user); //gerei um userDto que recebe um user e vai retornar um userDto, no caso exeplo ele só vai retornar o nome, pq o ID não está no DTO
            return new ResponseEntity(userDto, HttpStatus.OK); //se estiver tudo  certo, ele me retorna um 200

        }  return new ResponseEntity(null, HttpStatus.BAD_REQUEST); //se eu informar algo errado, ele me retorna o 400 e não devolve nada


    }


}
