/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa.taller4.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActividad;

    private String titulo;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaTerminacion;  //LocalDate ayuda a definir fecha sin hora especifica
    private String tipoActividad;
    private Long idQuehacer;  //Los Long son usados porque se recomiendan para almacenar valores altos en bases de datos sin desbordarse
    private Long idTutor;
    private Long idHijo;
}
