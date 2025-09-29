/**
 * 
 */

window.onload=function(){
	
	// 조회 버튼 클릭시	
	var search_btn = document.querySelector("#selectbtn");
		search_btn.onclick = s_search;	
	
	// 초기화 버튼 클릭시
	var reset_btn = document.querySelector("#resetbtn");
		reset_btn.onclick = s_reset;	
};

function s_reset(){
		// 모든 테이블 행을 가져옴
	    var rows = document.querySelectorAll("tr");

	    // 각 행의 배경색을 초기화
	    rows.forEach((row) => {
	        row.style.backgroundColor = ""; // 원래 색으로 복원
	    });

	    // 입력창의 값을 초기화
	    document.getElementById("salaryInput").value = "";
	    
	    // div영역의 결과도 초기화
	    document.getElementById("s_list").innerHTML = "";
};

function s_search(){
	// 사용자가 입력창에 입력한 급여 값을 가져옴 
	    var inputSalary = document.getElementById("salaryInput").value;
	    // 테이블의 모든 행을 가져옴
	    var rows = document.querySelectorAll("tr");
	    
	    // 기존의 결과를 비우고 새로운 테이블을 만들기 위해 초기화
	    var selectedListDiv = document.getElementById("s_list");
	    selectedListDiv.innerHTML = "";		// 이전 검색 결과 초기화
	    
	    // 조건에 맞는 행을 담을 새로운 테이블 요소 생성
	    var newTable = document.createElement("table");
	    newTable.border = "1";
	    newTable.style.width = "100%";

	    // 모든 행을 순회, 급여 확인
	    rows.forEach((row, index) => {
	        // 행에서 급여가 포함된 셀을 찾음
	        var salaryCell = row.querySelector(".salary");

	        if (salaryCell) {
	            // 셀의 텍스트 내용을 숫자로 변환
	            var salary = parseFloat(salaryCell.textContent);

	            // 입력된 급여 이상인 경우 배경색을 변경
	            if (salary >= parseFloat(inputSalary)) {
	                row.style.backgroundColor = "#FFF3B0"; 
		           
	                // 조건을 만족하는 행만 복사해서 새로운 테이블에 추가
	                var cloneRow = row.cloneNode(true);	// true : 자식 노드까지 복제
	                newTable.appendChild(cloneRow);		// 새로운 테이블에 추가
	                
	            } else {
	                row.style.backgroundColor = "#B0E0FF";  
	            }
	        }
	    });
	    // 조건을 만족하는 데이터가 있을때만 div에 삽입
	    if(newTable.rows.length > 0){
	    	selectedListDiv.innerHTML ="<h2>조회 결과 직원 정보</h2><br>";
	    	selectedListDiv.appendChild(newTable);
	    }else{
	    	selectedListDiv.innerHTML ="<p>해당 조건의 직원이 없습니다.</p>";
	    };
};
	
	





