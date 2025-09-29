package com.shinhan.SimpleBoard;

import com.shinhan.utils.InsertUtil;

public class ListController implements CommonControllerInterface {
	SimpleBoardService simpleBoardService = new SimpleBoardService();

	@Override
	public void execute() {
		int select;
		boolean is_end = false;
		while (!is_end) {
			CommonView.ListmanuDisplay();
			select = InsertUtil.check_Integer_Input("번호 입력 > ");
			switch (select) {
			case 1 -> selectAll();
			case 2 -> selectByWriter();
			case 3 -> selectByTitle();
			case 4 -> selectByContents();
			case 5 -> selectByTitleAndContents();
			case 6 -> {
				is_end = true;
				CommonView.goodBye("조회");
			}
			default -> CommonView.display_ready();
			}
		}
	}

	private void selectByTitleAndContents() {
		String title = InsertUtil.check_String_Input("제목 > ");
		String contents = InsertUtil.check_String_Input("내용 > ");
		CommonView.display(simpleBoardService.selectByTitleAndContents(title, contents), "내용 조회");
	}

	private void selectByContents() {
		String contents = InsertUtil.check_String_Input("내용 > ");
		CommonView.display(simpleBoardService.selectByContents(contents), "내용 조회");
	}
	
	private void selectByTitle() {
		String title = InsertUtil.check_String_Input("제목 > ");
		CommonView.display(simpleBoardService.selectByTitle(title), "제목 조회");
	}

	private void selectByWriter() {
		String writer = InsertUtil.check_String_Input("작성자 > ");
		CommonView.display(simpleBoardService.selectByWriter(writer), "작성자 조회");
	}

	private void selectAll() {
		CommonView.display(simpleBoardService.selectAll(), "게시판");
	}

}
