package ir.maktab.util.filter;

import lombok.Builder;
import lombok.Data;
import ir.maktab.model.enumeration.UserRole;

import java.util.Calendar;

/**
 * @author arm
 */
@Data
@Builder
public class UserFilter {
    private UserRole userRole;
    private String firstName;
    private String lastName;
    private Calendar registerDate;
    private String email;
}
