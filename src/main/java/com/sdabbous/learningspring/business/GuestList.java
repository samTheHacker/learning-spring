package com.sdabbous.learningspring.business;

public class GuestList {

    private long guestId;
    private String guestFirstName;
    private String guestLastName;
    private String guestEmail;
    private String guestPhoneNumber;

    public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    public String getGuestFirstName() {
        return guestFirstName;
    }

    public void setGuestFirstName(String guestFirstName) {
        this.guestFirstName = guestFirstName;
    }

    public String getGuestLastName() {
        return guestLastName;
    }

    public void setGuestLastName(String guestLastName) {
        this.guestLastName = guestLastName;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }

    public String getGuestPhoneNumber() {
        return guestPhoneNumber;
    }

    public void setGuestPhoneNumber(String guestPhoneNumber) {
        this.guestPhoneNumber = guestPhoneNumber;
    }

    @Override
    public String toString() {
        return "GuestList{" +
                "guestId=" + guestId +
                ", guestFirstName='" + guestFirstName + '\'' +
                ", guestLastName='" + guestLastName + '\'' +
                ", guestEmail='" + guestEmail + '\'' +
                ", guestPhoneNumber='" + guestPhoneNumber + '\'' +
                '}';
    }
}
