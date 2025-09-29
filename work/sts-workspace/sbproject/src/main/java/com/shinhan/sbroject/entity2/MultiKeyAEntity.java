package com.shinhan.sbroject.entity2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter@Setter
@ToString
@Entity
@Table(name = "t_childA")
@IdClass(MultiKeyA.class)
public class MultiKeyAEntity {

	@Id
	Integer id1;
	@Id
	Integer id2;
	String name;
}
