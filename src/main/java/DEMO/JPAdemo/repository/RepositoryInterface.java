package DEMO.JPAdemo.repository;


import DEMO.JPAdemo.domain.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryInterface extends JpaRepository<BoardEntity, Integer> {
    BoardEntity findById(int id);

}
