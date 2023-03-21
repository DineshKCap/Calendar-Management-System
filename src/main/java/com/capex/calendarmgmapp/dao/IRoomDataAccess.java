package com.capex.calendarmgmapp.dao;

import com.capex.calendarmgmapp.model.Room;
import org.springframework.http.ResponseEntity;

public interface IRoomDataAccess {

    void addRoom(String roomName,String roomLocation,int roomCapacity);

    Room getRoomDetails(int roomId);

    boolean deleteRoom(int roomId);

    boolean enableRoom(int roomId);
}
