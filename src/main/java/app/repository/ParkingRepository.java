package app.repository;

import app.model.Fee;
import app.model.Floor;
import app.model.Parking;
import app.model.projection.ParkingProjection;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
    @NotNull Optional<Parking> findById(@NotNull Long parkingId);

    Optional<Parking> findByAddress(String address);

    @Query("SELECT p FROM Parking p WHERE p.active = true")
    List<ParkingProjection> findAllParkings();

    @Query("SELECT p.fees from Parking p WHERE p.id = ?1")
    List<Fee> findAllFees(Long parkingId);

    @Query("SELECT p.floors FROM Parking p WHERE p.id = ?1")
    List<Floor> findAllFloors(Long parkingId);

    @Query("SELECT p FROM Parking p WHERE p.employee.dni = ?1")
    List<ParkingProjection> findAllParkingsByEmployee(String employeeDni);

    @Query("SELECT p.id from Parking p WHERE p.employee.dni = ?1")
    Long findParkingOfEmployeeByDni(String dni);
}
