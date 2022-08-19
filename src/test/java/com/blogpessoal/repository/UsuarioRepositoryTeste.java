package com.blogpessoal.repository;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.blogpessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) //conectar uma porta
@TestInstance(TestInstance.Lifecycle.PER_CLASS) //classe de teste
public class UsuarioRepositoryTeste {
	
	 //aqui eu estou configurando para que seja feita a parte de teste
	
	@Autowired
	private UsuarioRepository usuarioRepository; //aqui eu estou trazendo de usuariorepository (objeto)

	@BeforeAll
	void start() { //metodo: start para configurar - vai guardar as informações para fazer teste
		
		usuarioRepository.deleteAll();
		usuarioRepository.save(new Usuario(0L,"teste","teste@teste.com","12345678","url")); //guardar informações
		usuarioRepository.save(new Usuario(0L,"teste2","teste@teste.com2","12345678","url"));
		usuarioRepository.save(new Usuario(0L,"teste3","teste@teste.com3","12345678","url"));
		usuarioRepository.save(new Usuario(0L,"teste4","teste@teste.com4","12345678","url"));
		
		// aqui a ordem das coisas precisa estar na ordem do meu usuariomodel
		// ctrl + alt +setinha p/ baixo
	
	}
	
	@Test
	@DisplayName("Retorna 1 Usuario")
	public void deveretornarUsuario() {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("teste@teste.com");
		assertTrue(usuario.get().getUsuario().equals("teste@teste.com"));
	}
	
}
