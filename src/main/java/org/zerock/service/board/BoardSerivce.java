package org.zerock.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.board.BoardDto;
import org.zerock.domain.board.PageInfo;
import org.zerock.mapper.board.BoardMapper;

@Service
public class BoardSerivce {

	@Autowired
	private BoardMapper mapper;
	
	public int register(BoardDto board) {
		return mapper.insert(board);
	}

	public List<BoardDto> listBoard(int page, PageInfo pageInfo) {
		int records = 10;
		int offset = (page - 1) * records;
		
		int countAll = mapper.countAll(); // SELECT Count(*) FROM Board
		int lastPage = (countAll - 1) / records + 1;
		
		int leftPageNumber = mapper.countAll(); // SELECT COUNT(*) FROM BOARD
		int rightPage = (countAll - 1) / records + 1;

		pageInfo.setCurrentPageNumber(page);
		pageInfo.setLeftPageNumber(lastPage);
		pageInfo.setRightPageNumber(lastPage);
		pageInfo.setLastPageNumber(lastPage);
		
		return mapper.list(offset, records);
	}

	public BoardDto get(int id) {
		// TODO Auto-generated method stub
		return mapper.select(id);
	}

	public int update(BoardDto board) {
		
		return mapper.update(board);	
	}

	public int remove(int id) {
		return mapper.delete(id);
	}
	
}





