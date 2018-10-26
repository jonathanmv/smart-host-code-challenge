package com.smart_host.rooms.api.controller;

import com.smart_host.rooms.api.model.RoomOccupationOptimizationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RoomsControllerTest {

    @Test
    void listRoomOccupancyOptimization() throws Exception {
        RoomsController controller = new RoomsController();
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("economy", "3");
        queryParams.put("premium", "3");
        ResponseEntity<List<RoomOccupationOptimizationResponse>> responseEntity = (ResponseEntity<List<RoomOccupationOptimizationResponse>>) controller.listRoomOccupancyOptimization(queryParams);
        List<RoomOccupationOptimizationResponse> response = responseEntity.getBody();
        assertEquals(2, response.size());
    }
}