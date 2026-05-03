/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pa.taller4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pa.taller4.Modelo.Actividad;

/**
 * Repositorio para la entidad {@link Actividad}.
 * Proporciona operaciones CRUD sobre la base de datos
 * mediante Spring Data JPA.
 *
 * @version 1.0
 */
@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {
    
}
