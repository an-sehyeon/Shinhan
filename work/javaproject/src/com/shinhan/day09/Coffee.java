package com.shinhan.day09;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(of = {"menuName", "price"})
@ToString(exclude = "price")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Coffee {
	String menuName;
	int price;
	
	@Override
	public String toString() {
		return "Coffee정보 [menuName=" + menuName + ", price=" + price + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coffee other = (Coffee) obj;
		return Objects.equals(menuName, other.menuName) && price == other.price;
	}

	
	

}
