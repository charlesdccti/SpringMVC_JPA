package br.com.devmedia.curso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.devmedia.curso.domain.Usuario;

@Transactional
@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Usuario usuario) {
		entityManager.persist(usuario);
	}

	@Override
	public void editar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario getId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Usuario> getTodos() {
		//Faz um select * from Usuario com jpql do JPA
		String jpql = "from Usuario u";
		TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
		return query.getResultList();
	}


	
   
}