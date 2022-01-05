package dto;

import lombok.Data;
import model.enumeration.UserRole;
import model.enumeration.UserState;

import java.util.Calendar;

/**
 * @author arm
 */
@Data
public class UserDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private Calendar registerDate;
    private UserRole userRole;
    private UserState userState;
}