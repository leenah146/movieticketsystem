package com.example.movieticketsystem.Entites;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(10) check (tickettype='VIP' or tickettype='Regular') ")
    private String tickettype;
    @Column(columnDefinition = "varchar(50) default 'none'")
    private String meal;
    private Integer userid;
    private String moviename;
    private Integer numofseats;
    private Integer totalprice;



}
