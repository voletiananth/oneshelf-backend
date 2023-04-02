package edu.bu.oneshelf.pantry.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PantryResponse {
    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;
    private String address;
    private String phone;
    private String email;
}
