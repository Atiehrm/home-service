package util.filter;

import lombok.Builder;
import lombok.Data;
import model.enumeration.UserRole;

import java.util.Calendar;

/**
 * @author arm
 */
@Data
@Builder
public class ExpertFilter {
    private UserRole userRole;
    private String firstName;
    private String lastName;
    private Calendar registerDate;
    private String email;
    private String service;
    private String subService;
}
