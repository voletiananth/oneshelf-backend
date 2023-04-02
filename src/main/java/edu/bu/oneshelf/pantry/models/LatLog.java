package edu.bu.oneshelf.pantry.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LatLog implements java.io.Serializable{
    private Double lat;
    private Double lng;
}
