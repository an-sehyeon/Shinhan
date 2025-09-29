package com.shinhan.SimpleBoard;

import com.shinhan.utils.InsertUtil;

public class DeleteController implements CommonControllerInterface {
	SimpleBoardService simpleBoardService = new SimpleBoardService();
	@Override
	public void execute() {
		delete();
	}

	private void delete() {
		CommonView.display(simpleBoardService.selectAll(), "전체");
		int num = InsertUtil.check_Integer_Input("삭제할 글 번호 입력 > ");
		CommonView.display(simpleBoardService.deleteByNum(num), "삭제");
	}
}
