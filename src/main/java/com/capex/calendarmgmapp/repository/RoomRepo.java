package com.capex.calendarmgmapp.repository;

import com.capex.calendarmgmapp.model.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepo extends CrudRepository<Room, Integer> {
    Room findByRoomName(String roomName);
}
