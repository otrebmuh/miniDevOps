package mx.uam.tsis.ejemplobackend.negocio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.Mockito.when;

import mx.uam.tsis.ejemplobackend.datos.AlumnoRepository;
import mx.uam.tsis.ejemplobackend.negocio.modelo.Alumno;

import java.util.Optional;

@ExtendWith(MockitoExtension.class) // Uso de Mockito
public class AlumnoServiceTest {
	
	private static final Logger log = LoggerFactory.getLogger(AlumnoServiceTest.class);
	
	@Mock
	private AlumnoRepository alumnoRepositoryMock; // Mock generado por Mockito
	
	@InjectMocks
	private AlumnoService alumnoService; // La unidad a probar
	
	@Test
	public void testSuccessfulCreate() {
		
		Alumno alumno = new Alumno();
		alumno.setCarrera("Computación");
		alumno.setMatricula(12345678);
		alumno.setNombre("Pruebin");
		
		// Simula lo que haría el alumnoRepository real cuando le pasan una matricula de alumno
		// que no ha sido guardado
		when(alumnoRepositoryMock.findById(12345678)).thenReturn(Optional.ofNullable(null));
		
		when(alumnoRepositoryMock.save(alumno)).thenReturn(alumno);
		
		// Aqui ejecuto a la unidad que quiero probar
		alumno = alumnoService.create(alumno);
		
		// Aqui compruebo el resultado
		assertNotNull(alumno); // Probar que la referencia a alumno no es nula
			
		
	}
	
	@Test
	public void testUnsuccesfulCreate() {
		
		Alumno alumno = new Alumno();
		alumno.setCarrera("Computación");
		alumno.setMatricula(12345678);
		alumno.setNombre("Pruebin");
		
		// Simula lo que haría el alumnoRepository real cuando le pasan una matricula de alumno
		// que ya ha sido guardado
		when(alumnoRepositoryMock.findById(12345678)).thenReturn(Optional.ofNullable(alumno));
		
		// Aqui ejecuto a la unidad que quiero probar
		alumno = alumnoService.create(alumno);
		
		// Aqui compruebo el resultado
		assertNull(alumno); // Probar que la referencia a alumno es nula por que el alumno ya existía
			
		
	}
	
	@Test
	public void testSuccessfulUpdate() {

		Alumno alumno = new Alumno();
		alumno.setCarrera("Computación");
		alumno.setMatricula(12345678);
		alumno.setNombre("Pruebin");

		
		Alumno alumnoActualizado = new Alumno();
		alumnoActualizado.setCarrera("Electrónica");
		alumnoActualizado.setMatricula(12345678);
		alumnoActualizado.setNombre("PruebinActualizado");

		// Simula lo que haría el alumnoRepository real cuando le pasan una matricula de alumno
		// que ya ha sido guardado
		when(alumnoRepositoryMock.findById(12345678)).thenReturn(Optional.ofNullable(alumno));

		when(alumnoRepositoryMock.save(alumno)).thenReturn(alumno);
		
		/*
		when(alumnoRepositoryMock.save(alumno)).thenAnswer(new Answer <Alumno> () {

			@Override
			public Alumno answer(InvocationOnMock invocation) throws Throwable {

				// Lo siguiente nos permite acceder al parametro que se le pasa a Save
				Object[] args = invocation.getArguments();
				Alumno alumnoRecibidoComoParametro = (Alumno) args [0];
				
				// Corroboramos que el alumno que es pasado al save tiene sus atributos
				// actualizados
				assertEquals(alumnoActualizado.getCarrera(),alumnoRecibidoComoParametro.getCarrera());
				assertEquals(alumnoActualizado.getNombre(),alumnoRecibidoComoParametro.getNombre());
				
				
				return alumnoRecibidoComoParametro;
			}});*/
	
		boolean result = alumnoService.update(alumnoActualizado);
		
		assertTrue(result);
	
	}
	

}
