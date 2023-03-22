package com.capex.calendarmgmapp.controller;

import com.capex.calendarmgmapp.model.Room;
import com.capex.calendarmgmapp.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/room")
@RestController
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/add")
    public void addRoom(@RequestParam("roomName") String roomName, @RequestParam("roomLocation") String roomLocation, @RequestParam("roomCapacity") int roomCapacity)
    {
        roomService.addRoom(roomName,roomLocation,roomCapacity);
    }
    @GetMapping("/getDetails")
    public ResponseEntity<Room> getDetails(@RequestParam("roomId") int roomId)
    {
        return new ResponseEntity<>(roomService.getRoomDetails(roomId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteRoom")
    public ResponseEntity<Object> removeMeetingRoom(@RequestParam("roomId") int roomId)
    {
        boolean flag=roomService.deleteRoom(roomId);

        if(flag==true)
            return new ResponseEntity<>(new String("Successfully deleted "), HttpStatus.OK);
        else
            return new ResponseEntity<>(new String("Does not exist in Database"),HttpStatus.OK);
    }


    @PutMapping("/enable")
    public ResponseEntity<String> enableRoom(@RequestParam("roomId") int roomId)
    {
        boolean flag=roomService.enableRoom(roomId);
        if(flag==true)
        {
            return new ResponseEntity<String>("Room has been enabled",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<String>("Room with room Id"+roomId+"does not exist",HttpStatus.OK);
        }
    }



}
