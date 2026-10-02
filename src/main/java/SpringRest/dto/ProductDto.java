package SpringRest.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDto {
	
	@NotBlank(message = "name is required")
	private String name;
	
	@NotNull(message = "price is required")
	private Double price;
	
	@NotNull(message = "qty is required")
	private Integer qty;
	
	@NotBlank(message = "Category is required")
	private String category;
	
	@NotNull(message = "Mfgdate is required")
    private LocalDate mfgDate;
	
	@NotNull(message = "Expdate is required")
	private LocalDate expDate;

}
