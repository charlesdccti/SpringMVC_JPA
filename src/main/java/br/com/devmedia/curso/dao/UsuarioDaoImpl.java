package br.com.devmedia.curso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.devmedia.curso.domain.TipoSexo;
import br.com.devmedia.curso.domain.Usuario;


@Transactional
@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override 
	public void salvar(Usuario usuario) {
		this.entityManager.persist(usuario);
	}

	
	@Transactional
	@Override
	public void editar(Usuario usuario) {
	 entityManager.merge(usuario);                      
	}

	@Transactional
	@Override
	public void excluir(Long id) {
		this.entityManager.remove(entityManager.getReference(Usuario.class, id));
	}

	@Transactional(readOnly = true) 
	@Override
	public Usuario getId(Long id) {
		// Faz a busca de usuarios por id
		String	jpql = "from Usuario u where u.id = :id";
		TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Usuario> getTodos() {
		//Faz um select * from Usuario com jpql do JPA
		String jpql = "from Usuario u";
		TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
		return query.getResultList();
	}

	/**
	 * @param TipoSexo 
	 * @return Usuarios filtrados por sexo.
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Usuario> getBySexo(TipoSexo sexo) {
		String jpql = "from Usuario u where u.sexo = :sexo";
		TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
		query.setParameter("sexo", sexo);
		return query.getResultList();
	}


	
   
}