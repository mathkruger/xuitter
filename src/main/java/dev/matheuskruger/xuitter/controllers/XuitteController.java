package dev.matheuskruger.xuitter.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.matheuskruger.xuitter.domain.Xuitte;
import dev.matheuskruger.xuitter.services.XuitteService;

@RestController
public class XuitteController {
    @Autowired
    private XuitteService service;

    @GetMapping("/xuitte")
    public List<Xuitte> list() {
        return service.listAll();
    }

    @GetMapping("/xuitte/{id}")
    public ResponseEntity<Xuitte> get(@PathVariable Integer id) {
        var xuitte = service.get(id);
        return new ResponseEntity<>(xuitte, xuitte == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @PostMapping("/xuitte")
    public ResponseEntity<Xuitte> create(@RequestBody Xuitte xuitte) {
        Xuitte newXuitte = service.save(xuitte);
        return new ResponseEntity<>(newXuitte, HttpStatus.OK);
    }

    @DeleteMapping("/xuitte/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
