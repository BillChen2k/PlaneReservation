package cn.edu.ecnu.planereservation.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatModel {
    enum SeatType{
        F, C, Y;
    }
    protected long seat_id;
    protected SeatType type;
    protected double price;
    protected long available_count;
    protected long flight_id;
}
