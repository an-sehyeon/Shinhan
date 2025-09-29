package com.shinhan.sbroject.entity2;

import java.util.Set;

import com.shinhan.sbroject.entity.MemberRole;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder@Data
@Entity@Table(name = "tbl_enum")
public class EnumTypeEntity {
	@Id
	private String mid;
	private String mpassword;
	private String mname;
	
	//@CollectionTable이 생략되면 테이블이름은 enum_type_entity_mrole
	@ElementCollection(targetClass = MemberRole.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "tbl_enum_mroles", joinColumns = @JoinColumn(name = "mid")) // tbl_enum_mroles테이블의 조인칼럼
	private Set<MemberRole> mrole;
}




