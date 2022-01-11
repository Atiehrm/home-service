package ir.maktab.dto;

import lombok.Data;
import ir.maktab.data.model.enumeration.UserRole;
import ir.maktab.data.model.enumeration.UserState;

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