package app;

import app.model.*;
import app.repository.FloorRepository;
import app.repository.UserRepository;
import app.service.ParkingService;
import app.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class
CommandLineAppStartupRunner implements CommandLineRunner {
    final UserRepository userRepository;
    final FloorRepository floorRepository;
    final UserService userService;
    final ParkingService parkingService;

    public CommandLineAppStartupRunner(UserRepository userRepository, FloorRepository floorRepository, UserService userService, ParkingService parkingService) {
        this.userRepository = userRepository;
        this.floorRepository = floorRepository;
        this.userService = userService;
        this.parkingService = parkingService;
    }

    @Override
    public void run(String... args) {
        //user
        User admin = new User("ADMIN", "ADMIN", "ADMIN", "123456");
        admin.setRole(UserRole.ADMIN);
        User owner1 = new User("20000000", "Martin", "Garabal", "123456");
        owner1.setRole(UserRole.OWNER);
        User employee1 = new User("40000000", "Miguel", "Granados", "1234");
        employee1.setRole(UserRole.EMPLOYEE);
        User owner2 = new User("60000000", "Damian", "Szifron", "123456");
        owner2.setRole(UserRole.OWNER);
        User employee2 = new User("80000000", "Javier", "Milei", "1234");
        employee2.setRole(UserRole.EMPLOYEE);
        this.userRepository.save(admin);
        this.userRepository.save(owner1);
        this.userRepository.save(employee1);
        this.userRepository.save(owner2);
        this.userRepository.save(employee2);

        List<Floor> floors = new ArrayList<>(Arrays.asList(new Floor(50), new Floor(100), new Floor(1)));
        List<Fee> fees = new ArrayList<>(Arrays.asList(new Fee("CAR", 200), new Fee("TRUCK", 100), new Fee("MOTORCYCLE", 100)));
        owner1.getParkings().add(new Parking("Antezana 247, CABA", floors, fees));
        this.userRepository.save(owner1);
        List<Floor> floors2 = new ArrayList<>(Arrays.asList(new Floor(10), new Floor(20), new Floor(10)));
        List<Fee> fees2 = new ArrayList<>(Arrays.asList(new Fee("CAR", 200), new Fee("TRUCK", 100), new Fee("FAMILIARES", 0)));
        owner2.getParkings().add(new Parking("Cabildo y Juramento, CABA", floors2, fees2));
        this.userRepository.save(owner2);
    }
}
