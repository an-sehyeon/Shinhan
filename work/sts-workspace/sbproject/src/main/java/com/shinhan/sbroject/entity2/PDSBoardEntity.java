package com.shinhan.sbroject.entity2;

import java.util.List;

import com.shinhan.sbroject.entity.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter 
@ToString
@Entity
@Table(name = "t_pdsboard")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PDSBoardEntity extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	Long pid;
	String pname;
	String pwriter;
	
	// fetch default값은 LAZY
	@OneToMany(cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER,
			orphanRemoval = true)
	@JoinColumn(name = "pdsno")		// t_pdsfile테이블에 pdsno칼럼이 생성	
	List<PDSFileEntity> files2;

}
