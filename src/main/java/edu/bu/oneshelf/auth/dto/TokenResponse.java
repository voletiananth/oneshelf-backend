package edu.bu.oneshelf.auth.dto;


import edu.bu.oneshelf.auth.models.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenResponse {
    public String accessToken;
    public Role role;
}
