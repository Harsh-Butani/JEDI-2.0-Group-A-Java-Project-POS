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
}
