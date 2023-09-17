package com.flipkart.constants;

public class SQLConstants {
    public static final String APPROVE_GYM_OWNER_QUERY = "update GymOwner set ApprovalStatus = 1 where ApprovalStatus = 0 and GymOwnerID = (?)";
    public static final String APPROVE_ALL_PENDING_GYM_OWNER_QUERY = "update GymOwner set ApprovalStatus = 1 where ApprovalStatus = 0";
    public static final String VIEW_ALL_PENDING_GYM_OWNER_REQUEST_QUERY = "select GymOwnerID, name, Address from GymOwner where ApprovalStatus = 0";
    public static final String APPROVE_GYM_REGISTRATION_QUERY = "update Gym set ApprovalStatus = 1 where GymID = ?";
    public static final String APPROVE_ALL_PENDING_GYM_REGISTRATION_QUERY = "update Gym set ApprovalStatus = 1 where ApprovalStatus = 0";
    public static final String VIEW_ALL_PENDING_GYM_REGISTRATION_REQUEST_QUERY = "select GymID, GymOwnerID, gymName, gymAddress from Gym where ApprovalStatus = 0";
    public static final String VIEW_GYMS_QUERY = "select GymID, GymName, GymAddress from gym";
    public static final String REGISTER_USER_QUERY = "insert into User (email,password,role) values(?,?,?)";
    public static final String UPDATE_USER_PASSWORD_QUERY = "update User set password=(?) where email=(?) and password=(?) and role=(?)";
    public static final String QUERY_USER_DB_FOR_EMAIL_PASSWORD_ROLE = "SELECT * FROM User where email = (?) and password = (?) and role = (?)";
    public static final String QUERY_USER_DB_FOR_EMAIL_ROLE = "SELECT * FROM User where email = (?) and role = (?)";
    public static final String VIEW_CUSTOMER_BOOKING_LIST_DB_QUERY = "select UserID, slotNumber from BookingList where UserID = (?) and slotNumber = (?)";
    public static final String VIEW_AVAILABLE_SEATS_FROM_SLOT_FOR_DECREASE = "select availableSeats from slot where gymID = (?) and slotNumber = (?)";
    public static final String DECREASE_AVAILABLE_SEATS_FROM_SLOT = "update slot set availableSeats = (?) where gymID = (?) and slotNumber =(?)";
    public static final String ADD_BOOKING_TO_CUSTOMER_BOOKINGLIST = "insert into bookingList values ( ?,?,? )";
    public static final String VIEW_AVAILABLE_SEATS_FROM_SLOT_FOR_INCREASE = "select availableSeats from slot where gymID = (?) and slotNumber = (?)";
    public static final String INCREASE_AVAILABLE_SEATS_FROM_SLOT = "update slot set availableSeats = (?) where gymID = (?) and slotNumber =(?)";
    public static final String DELETE_BOOKING_FROM_BOOKINGLIST = "delete from bookingList where userID = (?) and slotNumber = (?)";
    public static final String VIEW_ALL_BOOKINGS_OF_A_USER = "select * from bookingList where userID =(?)";
    public static final String VIEW_INFO_OF_A_PARTICULAR_GYM = "select * from gym where gymID = (?)";
    public static final String VIEW_ALL_AVAILABLE_SLOTS_OF_A_PARTICULAR_GYM = "select slotNumber, availableSeats from slot where gymID = (?) and availableSeats > 0";
    public static final String VIEW_BOOKING_OF_A_USER_FOR_CANCELLATION = "select UserID, slotNumber from BookingList where UserID = (?) and slotNumber = (?) and gymID = (?)";
    public static final String CHECK_SEATS_AVAILABLE_FOR_GIVEN_GYM_AND_SLOT = "select availableSeats from Slot where gymID = (?) and slotNumber = (?) and availableSeats > 0";
    public static final String INSERT_APPROVED_GYM_OWNERS_TO_USER_DB = "insert into user (email,password,role) values (?,?,?)";
    public static final String FETCH_GYM_OWNER_DETAILS_JUST_APPROVED = "select emailID, password from GymOwner where GymOwnerID = (?)";
    public static final String FETCH_PENDING_GYM_OWNERS_FOR_USER_DB_INSERTION = "select emailID, password from GymOwner where ApprovalStatus = 0";
    public static final String INSERT_INTO_GYM_OWNER_DB = "insert into GymOwner (name, Address, IDProof, ApprovalStatus, emailID, password) values (?,?,?,?,?,?)";
    public static final String INSERT_INTO_GYM_DB = "insert into Gym (GymOwnerID, ApprovalStatus, gymName, gymAddress) values (?,?,?,?)";
    public static final String QUERY_GYM_DB_FOR_GYMID = "select gymID from gym where GymOwnerID = (?) and gymName = (?) and gymAddress = (?)";
    public static final String INSERT_INTO_SLOT_DB = "insert into slot (gymID, slotNumber, availableSeats, approvedStatus) values (?,?,?,?)";
    public static final String QUERY_GYM_DB_FOR_GYMOWNER = "select * from gym where GymOwnerID = (?)";
}
