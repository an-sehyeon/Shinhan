package com.shinhan.sbroject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.shinhan.sbroject.entity2.PDSBoardEntity;
import com.shinhan.sbroject.entity2.PDSFileEntity;
import com.shinhan.sbroject.repository2.PDSBoardRepository;
import com.shinhan.sbroject.repository2.PDSFileRepository;


@Commit		// Test환경에서도 DML이 commit되도록 한다.
@SpringBootTest
public class OneToManyTest {

		@Autowired
		PDSBoardRepository boardRepo;
		
		@Autowired
		PDSFileRepository fileRepo;
		
		
		@Test
		void f_fileDelete() {
			Long[] arr = {1L,2L,3L,4L,34L};
			
			List<Long> idLIst = Arrays.asList(arr);
			fileRepo.deleteAllById(idLIst);
		}
		
		
		// board 번호 (pid)가 1번의 file LIst 가져오기
		// 회식?? 문자로 시작하는 file을 지우기
		// 추가 2개, board수정(pname, pwriter)
//		@Test
		void f_ByIdFileList() {
			Long fno = 2L;
			boardRepo.findById(fno).ifPresent(board->{
				board.setPname("연남토마");
				board.setPwriter("지민");
				List<PDSFileEntity> flist =  board.getFiles2();
				
				// 연결(참조)가 null이 된다. orphanRemoval(고아가 된 data를 DB에서 삭제하기)
				flist.removeIf(f-> f.getPdsfilename().startsWith("회식"));
				
				PDSFileEntity f1 = PDSFileEntity.builder().pdsfilename("음식5.jpg").build();
				PDSFileEntity f2 = PDSFileEntity.builder().pdsfilename("음식6.jpg").build();
				flist.add(f1);flist.add(f2);
				
				boardRepo.save(board);
			});
		}
		
//		@Test
		void f_fileUpdate() {
			String newFileName = "travel3.png";
			Long fno = 1L;
			int result = boardRepo.updatePdsFile(newFileName, fno);
			System.out.println("update결과 : " + result);
		}
		
		
		// 각각의 board의 첨부파일이 몇개인지 출력
//		@Test
		void f_selectFileCount() {
			boardRepo.findAll().forEach(board->{
				System.out.print("bno : " + board.getPid());
				System.out.println("-- 파일개수 :  " + board.getFiles2().size());
			});
			
			System.out.println("---------------------------------------------------------------------");
			
			boardRepo.getFileCount().forEach(arr->{
				System.out.println(Arrays.toString(arr));
			});
			
			System.out.println("---------------------------------------------------------------------");
			boardRepo.getFileCount2().forEach(arr->{
				System.out.println(Arrays.toString(arr));
			});
		}
		
		// Board insert, 첨부파일 없음
//		@Test
		void f_boardInsert() {
				PDSBoardEntity board = PDSBoardEntity.builder()
						.pname("스프링부트")
						.pwriter("키키키")
						.build();
				boardRepo.save(board);
		}
		
		// 저장된 file를 board가 참조하도록 수정
//		@Test
		void f_update2() {
			PDSFileEntity file = fileRepo.findById(35L).orElse(null);
			if(file == null) return;
			
			boardRepo.findById(8L).ifPresent(board->{
				board.getFiles2().add(file);
				boardRepo.save(board);
			});
		}
		
		
		// file저장, board 참조
//		@Test
		void f_fileInsert() {
			PDSFileEntity file = PDSFileEntity.builder().pdsfilename("travel22.jpg").build();
			fileRepo.save(file);
		}
		
		
		// board 수정, file insert, file update
//		@Test
		void f_update() {
			
			PDSFileEntity file = PDSFileEntity.builder().pdsfilename("coffee.jpg").build();
			
			boardRepo.findById(1L).ifPresent(board->{
				board.setPname("pname변경");
				board.setPwriter("writer변경");
				board.getFiles2().add(file);
				boardRepo.save(board);
			});
		}
		
		
		// board조회
		// 1)  fetch = FetchType.LAZY인데 이 업무에서 연관관계 table도 조회하고자 한다.
//		@Transactional
		// 2) fetch = FetchType.EAGER
		// 3) N+1문제 해결 EntityGraph
		// 3) N+1문제 해결 (fatch join이용)
//		@Test
		void f_select() {
			boardRepo.findAll().forEach(board->{
				System.out.println(board);
			});
			
			System.out.println("-----------------------------------");
			
			boardRepo.findAll2().forEach(board->{
				System.out.println(board);
			});
			
		}
		
		// board를 통해 file 저장
//		@Test
		void f_insert() {
			IntStream.range(1, 5).forEach(i-> {
				PDSBoardEntity board = PDSBoardEntity.builder()
						.pname("월요일"+i)
						.pwriter("작성자"+i)
						.build();
				List<PDSFileEntity> fileList = new ArrayList<>();
				IntStream.range(1, 5).forEach(j-> {
					PDSFileEntity file = PDSFileEntity.builder()
							.pdsfilename("점심"+j+".png")
							.build();
					fileList.add(file);
				});
				board.setFiles2(fileList);
				boardRepo.save(board);
			}); 
		}
}
