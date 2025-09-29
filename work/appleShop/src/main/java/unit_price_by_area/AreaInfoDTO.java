package unit_price_by_area;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AreaInfoDTO {
	private int housing_area;
	private String down_payment;
	private String interim_payment;
	private String balace_payment;
	private String total_price;

}
