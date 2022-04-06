package Entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-04-04T19:14:31.757-0300")
@StaticMetamodel(Usuario.class)
public class Usuario_ {
	public static volatile SingularAttribute<Usuario, Integer> id;
	public static volatile SingularAttribute<Usuario, String> nombre;
	public static volatile SingularAttribute<Usuario, String> apellido;
	public static volatile SingularAttribute<Usuario, String> mail;
	public static volatile SingularAttribute<Usuario, Integer> cedula;
	public static volatile SingularAttribute<Usuario, Integer> telefono;
	public static volatile SingularAttribute<Usuario, String> nomAcc;
	public static volatile SingularAttribute<Usuario, String> contra;
}
