package dev.matheuskruger.xuitter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.matheuskruger.xuitter.domain.Xuitte;
import dev.matheuskruger.xuitter.repositories.XuitteRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class XuitteService {
    @Autowired
    private XuitteRepository repo;

    public List<Xuitte> listAll() {
        return repo.findAll();
    }

    public Xuitte save(Xuitte xuitte) {
        return repo.save(xuitte);
    }

    public Xuitte get(Integer id) {
        return repo.getReferenceById(id);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
