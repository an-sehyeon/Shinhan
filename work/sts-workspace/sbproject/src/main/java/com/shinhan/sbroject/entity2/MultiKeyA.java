package com.shinhan.sbroject.entity2;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class MultiKeyA {

		Integer id1;
		Integer id2;
}
