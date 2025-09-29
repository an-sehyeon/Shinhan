package com.shinhan.sbroject.servicefinal;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;
import com.shinhan.sbroject.entityfinal.WebBoardDTO;
import com.shinhan.sbroject.entityfinal.WebBoardEntity;
import com.shinhan.sbroject.entityfinal.WebReplyEntity;
import com.shinhan.sbroject.paging.PageRequestDTO;
import com.shinhan.sbroject.paging.PageResultDTO;
import com.shinhan.sbroject.repository.BoardRepository;
import com.shinhan.sbroject.repositoryfinal.WebBoardRepository;
import com.shinhan.sbroject.repositoryfinal.WebReplyRepository;

import jakarta.transaction.Transactional;

@Service
public class WebBoardServiceImpl implements WebBoardService{

    private final BoardRepository boardRepository;
	
	@Autowired
	WebBoardRepository boardRepo;
	
	@Autowired
	WebReplyRepository replyRepo;

    WebBoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    @Override
    public List<WebBoardDTO> getList() {
        List<WebBoardEntity> boardList = boardRepo.findAll();
        ModelMapper mapper = new ModelMapper();

        return boardList.stream()
                .map(entity -> {
                    WebBoardDTO dto = mapper.map(entity, WebBoardDTO.class);

                    List<WebReplyEntity> replyList = entity.getReplies();
                    if (replyList == null) replyList = Collections.emptyList();

                    dto.setReplyList(replyList);
                    dto.setReplyCount((long) replyList.size());
                    return dto;
                })
                .collect(Collectors.toList());
    }
	
	@Override
	public PageResultDTO<WebBoardDTO, WebBoardEntity> getList(PageRequestDTO pageDTO) {
		Sort sort = Sort.by(Direction.ASC, "bno");
		Pageable pageable = pageDTO.getPageable(sort);
		Predicate predicate = boardRepo.makePredicate(pageDTO.getType(), pageDTO.getKeyword());
		Page<WebBoardEntity> result = boardRepo.findAll(predicate, pageable);
		ModelMapper mapper = new ModelMapper();
		Function<WebBoardEntity, WebBoardDTO> fn = entity -> {
			WebBoardDTO dto = mapper.map(entity, WebBoardDTO.class);
			return dto;
		};
		PageResultDTO<WebBoardDTO, WebBoardEntity>
		     responseResult = new PageResultDTO<>(result, fn);
		
		return responseResult;
	}

	@Override
	public WebBoardDTO selectById(Long bno) {
		WebBoardEntity entity = boardRepo.findById(bno).orElse(null);
		if(entity == null)return null;
		
		ModelMapper mapper = new ModelMapper();
		WebBoardDTO dto = mapper.map(entity, WebBoardDTO.class);
		
		WebBoardEntity board = WebBoardEntity.builder().bno(bno).build();
		List<WebReplyEntity> replies = replyRepo.findByBoard(board);
		dto.setReplyCount(Long.valueOf(replies.size()));
		return dto;
	}

	@Override
	public int register(WebBoardDTO board) {
		return f_save(board);
	}

	private int f_save(WebBoardDTO board) {
		// 수정시 bno, title, content만 들어온 상황 DTO->Entity 전환하면서 writer가 null
		// 저장시 null로 변경하는 문제발샐
		ModelMapper mapper = new ModelMapper();
		WebBoardEntity entity = mapper.map(board, WebBoardEntity.class);
		WebBoardEntity newEntity = boardRepo.save(entity);
		
		return newEntity.getBno().intValue();
	}

	@Override
	public int modify(WebBoardDTO board) {
		WebBoardEntity entity = boardRepo.findById(board.getBno()).orElse(null);
		if(entity == null) return 0;
		entity.setContent(board.getContent());
		entity.setTitle(board.getTitle());
		WebBoardEntity newEntity = boardRepo.save(entity);
		return newEntity.getBno().intValue();
	}

	@Override
	public int delete(Long bno) {
		boardRepo.deleteById(bno);
		
		WebBoardEntity entity = boardRepo.findById(bno).orElse(null);
		if(entity == null) return 0;
		return 1;
	}


}
