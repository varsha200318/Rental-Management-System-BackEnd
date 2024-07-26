package org.emp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rental {
    private Long id;
    private Integer rentaldate;
    private Integer returndate;
    private Integer duedate;
    private Integer totalcost;
    private Integer fine;
}
