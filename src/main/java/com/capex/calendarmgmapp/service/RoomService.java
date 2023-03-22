package com.capex.calendarmgmapp.service;

import com.capex.calendarmgmapp.dao.IRoomDataAccess;
import com.capex.calendarmgmapp.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private final IRoomDataAccess roomDataAccess;

    @Autowired
    public RoomService(IRoomDataAccess roomDataAccess) {
        this.roomDataAccess = roomDataAccess;
    }

    public void addRoom(String roomName,String roomLocation,int roomCapacity){
        roomDataAccess.addRoom(roomName, roomLocation, roomCapacity);
    }

    public Room getRoomDetails(int roomId){
        return roomDataAccess.getRoomDetails(roomId);
    }

    public boolean deleteRoom(int roomId){
        return deleteRoom(roomId);
    }

    public boolean enableRoom(int roomId){
        return roomDataAccess.enableRoom(roomId);
    }
}
