/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa.taller4.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@Table(name="actividades")
@NoArgsConstructor
@AllArgsConstructor
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActividad;
    
    @Column(name = "titulo", nullable = false, unique = false, length = 50)
    private String titulo;
    @Column(name="descripcion", nullable = false, unique = false, length = 50)
    private String descripcion;
    @Column(name="fecha_inicio", nullable = false, unique = false)
    private LocalDate fechaInicio;
    @Column(name="fecha_terminacion", nullable = false, unique = false)
    private LocalDate fechaTerminacion;  //LocalDate ayuda a definir fecha sin hora especifica
    @Column(name="tipo_actividad", nullable = false, unique = false, length = 50)
    private String tipoActividad;
    @Column(name="id_quehacer", nullable = false, unique = false)
    private Long idQuehacer;  //Los Long son usados porque se recomiendan para almacenar valores altos en bases de datos sin desbordarse
    @Column(name="id_tutor", nullable = false, unique = false)
    private Long idTutor;
    @Column(name="id_hijo", nullable = false, unique = false)
    private Long idHijo;
}
