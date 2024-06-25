package CarloPatalano.U5W2D2.Service;

import CarloPatalano.U5W2D2.Entities.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private List<Author> authors = new ArrayList<>();
    private long nextId = 1;

    public List<Author> findAll() {
        return authors;
    }

    public Optional<Author> findById(Long id) {
        return authors.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    public Author save(Author author) {
        if (author.getId() == null) {
            author.setId(nextId++);
            author.setAvatar("https://ui-avatars.com/api/?name=" + author.getName() + "+" + author.getCognome());
        }
        authors.add(author);
        return author;
    }
    public Optional<Author> update(Long id, Author updatedAuthor) {
        return findById(id).map(author -> {
            author.setName(updatedAuthor.getName());
            author.setCognome(updatedAuthor.getCognome());
            author.setEmail(updatedAuthor.getEmail());
            author.setDataDiNascita(updatedAuthor.getDataDiNascita());
            author.setAvatar("https://ui-avatars.com/api/?name=" + updatedAuthor.getName() + "+" + updatedAuthor.getCognome());
            return author;
        });
    }

    public boolean deleteById(Long id) {
        return authors.removeIf(author -> author.getId().equals(id));
    }
}
