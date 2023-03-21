package com.capex.calendarmgmapp.dao;

import com.capex.calendarmgmapp.model.Room;
import com.capex.calendarmgmapp.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RoomDAO implements IRoomDataAccess {

    private final RoomRepo roomRepo;
    private Optional<Room> roomOptional;

    @Autowired
    public RoomDAO(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Override
    public void addRoom(String roomName, String roomLocation, int roomCapacity) {
        Room newRoom = new Room(roomName, roomLocation, roomCapacity);
        roomRepo.save(newRoom);
    }

    @Override
    public Room getRoomDetails(int roomId) {

        Optional<Room> roomOptional = roomRepo.findById(roomId);

        Room selectedRoom = null;

        if (!roomOptional.isEmpty())
            selectedRoom = roomOptional.get();

        return selectedRoom;

    }

    @Override
    public boolean deleteRoom(int roomId) {

        boolean status = false;

        if (roomRepo.existsById(roomId)) {
            roomRepo.deleteById(roomId);
            return true;
        }

        return status;
    }

    @Override
    public boolean enableRoom(int roomId) {
        boolean status = false;

        boolean roomCheck = roomRepo.existsById(roomId);

        if (roomCheck) {
            Optional<Room> roomOptional = roomRepo.findById(roomId);

            Room selectedRoom = null;

            if (roomOptional.isPresent()) {
                selectedRoom = roomOptional.get();
                selectedRoom.setOccupied(true);
            }


            roomRepo.save(selectedRoom);

            status = true;
        }

        return status;
    }
}
