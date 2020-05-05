package com.EmployeeManagement.employeemanagement.dto;

public class TimeSheetAndUserBody {

    private TimeSheetDTO timeSheetBody;
    private UserDTO user;

    public TimeSheetDTO getTimeSheetBody() {
        return timeSheetBody;
    }

    public void setTimeSheetBody(TimeSheetDTO timeSheetBody) {
        this.timeSheetBody = timeSheetBody;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
