package com.shinhan.SimpleBoard;

import com.shinhan.utils.InsertUtil;
import com.shinhan.utils.ScannerUtil;

public class UpdateController implements CommonControllerInterface {
	SimpleBoardService simpleBoardService = new SimpleBoardService();

	public void execute() {
		update();
	}

	private void update() {
		CommonView.display(simpleBoardService.selectAll(), "전체");
		String writer = InsertUtil.check_String_Input("이름 > ");
		int bno = InsertUtil.check_Integer_Input("수정하고 싶은 게시글 번호 > ");
		String title = InsertUtil.check_String_Input("수정하고 싶은 게시글의 제목 > ");

//		// 이름, 게시글, 제목 검증
		SimpleBoardDTO chack = simpleBoardService.selectBoard(writer, bno, title);
		if (chack != null) {
			CommonView.display(writer + "님이 작성하신 게시글이 존재합니다. 수정할 정보를 입력하세요. > ");
			SimpleBoardDTO board = makeBoard();
			board.setBno(chack.getBno());

			int result = simpleBoardService.boardUpdate(board);
			CommonView.display(result, "수정");
		} else {
			CommonView.display("해당 게시글이 존재하지 않습니다.");
		}

	}

	private SimpleBoardDTO makeBoard() {
		String writer = InsertUtil.check_String_Input("이름 > ");
		String title = InsertUtil.check_String_Input("제목 > ");
		String contents = InsertUtil.check_String_Input("내용 > ");

		SimpleBoardDTO board = SimpleBoardDTO.builder().writer(writer).writedate(null).title(title).contents(contents)
				.build();

		return board;
	}

}
