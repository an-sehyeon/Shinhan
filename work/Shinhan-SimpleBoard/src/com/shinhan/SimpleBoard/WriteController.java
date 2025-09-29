package com.shinhan.SimpleBoard;

import com.shinhan.utils.InsertUtil;

public class WriteController implements CommonControllerInterface {
	SimpleBoardService simpleBoardService = new SimpleBoardService();

	@Override
	public void execute() {
		insert();
	}

	private void insert() {
		String writer = InsertUtil.check_String_Input("작성자 입력 > ");
		String title = InsertUtil.check_String_Input("제목 입력 > ");
		String contents = InsertUtil.check_String_Input("내용 입력 > ");
		SimpleBoardDTO sb = SimpleBoardDTO.builder().writer(writer).title(title).contents(contents).build();
		CommonView.display(simpleBoardService.insertPost(sb), "등록");
	}
}
