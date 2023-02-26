package DEMO.JPAdemo.service;


import DEMO.JPAdemo.domain.BoardDTO;
import DEMO.JPAdemo.domain.BoardEntity;
import DEMO.JPAdemo.repository.RepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final RepositoryInterface repository;

    public BoardDTO save(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setTitle(boardDTO.getTitle());
        boardEntity.setAuthor(boardDTO.getAuthor());
        boardEntity.setContent(boardDTO.getContent());
        repository.save(boardEntity);
        return boardDTO;
    }

    public BoardDTO update(BoardDTO boardDTO , int id) {
        BoardEntity boardEntity = repository.findById(id);
        boardEntity.setTitle(boardDTO.getTitle());
        boardEntity.setAuthor(boardDTO.getAuthor());
        boardEntity.setContent(boardDTO.getContent());
        repository.save(boardEntity);
        return boardDTO;
    }

    public Optional<BoardEntity> findById(int id) {
        return Optional.ofNullable(repository.findById(id));
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<BoardEntity> getAllContent(){
        return repository.findAll();
    }


}
