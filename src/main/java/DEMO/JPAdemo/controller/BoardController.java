package DEMO.JPAdemo.controller;

import DEMO.JPAdemo.domain.BoardDTO;
import DEMO.JPAdemo.domain.BoardEntity;
import DEMO.JPAdemo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")  //게시물 리스트
    public String boardList(Model model) {
        List<BoardEntity> boardEntityList = boardService.getAllContent();
        model.addAttribute("contents", boardEntityList);
        return "boardList";
    }

    @GetMapping("/{id}")  //게시물 조회
    public String readContent(@PathVariable("id") int id, Model model) {
        BoardEntity boardEntity = boardService.findById(id).get();

        model.addAttribute("content", boardEntity.getContent());
        model.addAttribute("author", boardEntity.getAuthor());
        model.addAttribute("title", boardEntity.getTitle());
        return "readContent";
    }

    @GetMapping("/post")  //게시물 작성 폼으로 이동
    public String movePostForm() {
        return "postForm";
    }

    @PostMapping("/post")  //게시물 작성 메서드
    public String postContent(BoardEntity boardEntity) {
        boardService.save(boardEntity);
        return "redirect:/boards/list";
    }

    @GetMapping("/update/{id}")  // 게시물 수정 폼으로 이동
    public String updateContent(Model model, @PathVariable("id") int id) {
        BoardEntity boardEntity = boardService.findById(id).get();
        model.addAttribute("boards", boardEntity);
        return "updateForm";
    }

    @PostMapping("/update/{id}")  // 게시물 수정 메서드
    public String updateContentById(@PathVariable("id") int id, BoardEntity boardEntity) {
        boardService.save(boardEntity);
        return "redirect:/boards/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteContetById(@PathVariable("id") int id) {
        boardService.delete(id);
        return "redirect:/boards/list";
    }
}
