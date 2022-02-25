package pe.todotic.mitiendaapi_s3.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.todotic.mitiendaapi_s3.model.Libro;
import pe.todotic.mitiendaapi_s3.repository.LibroRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private LibroRepository libroRepository;

    @GetMapping("/ultimos-libros")
    List<Libro> UltimosLibros() {
        return this.libroRepository.findFirst6ByOrderByFechaCreacionDesc();
    }

    @GetMapping("/libros")
    Page<Libro> index(
            @PageableDefault(size = 10, sort = "titulo", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return libroRepository.findAll(pageable);

    }

    @GetMapping("/libros/{slug}")
    Libro obtener(@PathVariable String slug) {
        return libroRepository
                .findBySlug(slug)
                .orElseThrow(EntityNotFoundException::new);

    }

}
