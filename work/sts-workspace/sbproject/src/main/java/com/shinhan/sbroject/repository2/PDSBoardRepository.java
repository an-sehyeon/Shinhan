package com.shinhan.sbroject.repository2;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shinhan.sbroject.entity2.PDSBoardEntity;

import jakarta.transaction.Transactional;

public interface PDSBoardRepository extends JpaRepository<PDSBoardEntity, Long>{
	
	
	//JPQL작성 : board별 File의 count
	//nativeQuery에서 count(*)의 의미는 null포함한 개수
	//nativeQuery에서 count(칼럼이름)의 의미는 null 제외한 개수
	
	@Query("select board.pid, count(file.fno) "
		+ " from #{#entityName} board left outer join board.files2 file "
		+ " group by board.pid")
	List<Object[]> getFileCount();
	
	
	@Query(value = "select board.pid, count(file.pdsno) "
			+ " from t_pdsboard board left outer join t_pdsfile file on(board.pid = file.pdsno) "
			+ " group by board.pid", nativeQuery = true)
	List<Object[]> getFileCount2();
	
	
	// @Query이용해서 DML 사용
	// fno, fname을 받아서 update하고 한다.
	@Modifying
	@Transactional
	@Query("update PDSFileEntity set pdsfilename = :fname where fno = :fno")
	int updatePdsFile(@Param("fname") String newFileName, @Param("fno") Long fno);
	

	// 1) N+1문제 해결
	@EntityGraph(attributePaths = "files2")
	List<PDSBoardEntity> findAll();
	
	// 2) N+1문제 해결(fatch join이용)
	@Query("select board from #{#entityName} board join fetch board.files2")
	List<PDSBoardEntity> findAll2();
}
