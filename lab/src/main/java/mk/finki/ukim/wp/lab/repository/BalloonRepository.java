package mk.finki.ukim.wp.lab.repository;

import mk.finki.ukim.wp.lab.model.Balloon;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BalloonRepository {

    List<Balloon> balloon = new ArrayList<>(10);

    public List<Balloon> findAllBalloons() {
        return balloon;
    }

    public List<Balloon> findAllByNameOrDescription(String text) {
        return balloon.stream().filter(r->r.getName().contains(text) || r.getDescription().contains(text)).collect(Collectors.toList());
    }

}
