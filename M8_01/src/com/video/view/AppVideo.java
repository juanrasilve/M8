package com.video.view;

import java.sql.Connection;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.video.conexion.Conexiones;
import com.video.controller.TagController;
import com.video.controller.UsuarioController;
import com.video.controller.VideoController;
import com.video.model.Estats;
import com.video.model.Tag;
import com.video.model.Usuari;
import com.video.model.Video;

public class AppVideo {
	public static void main(String[] args) {
		
		Conexiones conexion = new Conexiones();
		Connection conn = conexion.conexion();
		int idusuari = 0;
		boolean continuar = false;
		
		int resp = JOptionPane.showConfirmDialog(null, "¿Tiene Contraseña?", "Usuario", JOptionPane.YES_NO_OPTION);
		String nombre="";
		String apellido="";
		String contraseña="";
		if (resp !=0) {
			do {
				nombre = JOptionPane.showInputDialog("Escribe tu nombre");
				try {

					validarCampo(nombre);
					continuar=true;
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Debes introducir el nombre", "Error", JOptionPane.ERROR_MESSAGE);
					continuar=false;
				}
			}while(!continuar);
			
			do {
				apellido = JOptionPane.showInputDialog("Escribe tu apellido");
				try {
					validarCampo(apellido);
					continuar=true;
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Debes introducir el apellido", "Error", JOptionPane.ERROR_MESSAGE);
					continuar=false;
				}
			}while(!continuar);
			
			do {
				contraseña = contraseña();
				try {
					validarCampo(contraseña);
					continuar=true;
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Debes introducir la nueva contraseña", "Error", JOptionPane.ERROR_MESSAGE);
					continuar=false;
				}
			}while(!continuar);
			
			
			idusuari = crearusuario(nombre,apellido,contraseña,conn);
			
			introducirVideos(idusuari,conn,continuar);
		}else {
			
			do {
				idusuari = comprobarContraseña(nombre,contraseña,continuar,conn);
				try {
					if (idusuari!=0) {
						continuar=true;
					}
					else{
						throw new Exception();
					}
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null, "El usuario o contraseña es incorrecto. Vuelve a introducirla", "Error", JOptionPane.ERROR_MESSAGE);
					continuar=false;
				}
			}while(!continuar);
				introducirVideos(idusuari,conn,continuar);
		}
		
		visualizarVideos(idusuari,conn);
		
		int visualizarEstados; 
		do{
			visualizarEstados = JOptionPane.showConfirmDialog(null, "¿Desea volver a visualizar los videos para ver su estado?", "Usuario", JOptionPane.YES_NO_OPTION);
			actualizarEstados(idusuari,conn);
			if (visualizarEstados!=0) {
				break;	
			}
			visualizarVideos(idusuari,conn);
		}while(visualizarEstados==0);
	}	
	
	public static void actualizarEstados(int idusuari,Connection conn) {
		
		Video video = new Video();
		video.setIdusuari(idusuari);
		VideoController vid=new VideoController(video,new AppVideo());
		vid.updateVideo(video,conn);
		
	}
	
	public static void visualizarVideos(int idusuari,Connection conn) {
		List<Video> videos = obtenerVideos(idusuari,conn);
		String Mensaje = "Videos:\n";
		
		for (int i=0;i<videos.size();i++) {
			Mensaje +="Titol: " + videos.get(i).getTitol()+ " URL: " + videos.get(i).getTitol() + " Estat: "+videos.get(i).getEstat() + "\n";
			List<Tag> tags = obtenerTags(videos.get(i).getIdvideo(),conn);
			for (int j=0;j<tags.size();j++) {
				Mensaje +="Tag"+j+":" + " NomTag: " + tags.get(j).getNom_tag() + "\n";
			}
			Mensaje += "\n";
		}
		
		JOptionPane.showMessageDialog(null, Mensaje);
	}
	
	public static int comprobarContraseña(String nombre,String contraseña,boolean continuar,Connection conn){
		do {
			nombre = JOptionPane.showInputDialog("Introduce tu nombre de usuario");
			try {
				validarCampo(nombre);
				continuar=true;
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Debes introducir tu nombre de usuario", "Error", JOptionPane.ERROR_MESSAGE);
				continuar=false;
			}
		}while(!continuar);
		
		do {
			contraseña = JOptionPane.showInputDialog("Introduce tu contraseña");
			try {

				validarCampo(contraseña);
				continuar=true;
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Debes introducir tu contraseña", "Error", JOptionPane.ERROR_MESSAGE);
				continuar=false;
			}
		}while(!continuar);
		
		Usuari usuari = new Usuari();
		usuari.setNom(nombre);
		usuari.setPassword(contraseña);
		
		UsuarioController usuario=new UsuarioController(usuari,new AppVideo());
		int idUsuario = usuario.obtenerUsuario(usuari,conn);
		
		return idUsuario;
		
}
	
	public static void introducirVideos(int idusuari,Connection conn, boolean continuar) {
		int x =0;
		int y;
		int idvideo =0;
		int idtag;
		while (x<2) {
			String titol = "";
			String URL = "";
			String nomTag="";
			
			do {
				titol = JOptionPane.showInputDialog("Introduzca el titulo del video");
				try {

					validarCampo(titol);
					continuar=true;
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Debes introducir el titulo del video", "Error", JOptionPane.ERROR_MESSAGE);
					continuar=false;
				}
			}while(!continuar);
		  do {
			URL = JOptionPane.showInputDialog("Introduzca la URL");
			try {

				validarCampo(URL);
				continuar=true;
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Debes introducir la URL del video", "Error", JOptionPane.ERROR_MESSAGE);
				continuar=false;
			}
		}while(!continuar);
			
			idvideo = crearVideo(titol,URL,idusuari,conn);
			x++;
			idtag = 0;
			y=0;
			while (y<2) {
				 do {
					 nomTag = JOptionPane.showInputDialog("Introduzca el tag");
						try {

							validarCampo(nomTag);
							continuar=true;
						}catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Debes introducir un tag para el video", "Error", JOptionPane.ERROR_MESSAGE);
							continuar=false;
						}
					}while(!continuar);
				
				idtag = crearTag(nomTag,idvideo,conn);
				y++;
			}
		}
		
	};
	
	public static void validarCampo(String campo) throws Exception{
			if (campo == null || campo.equals("")) {
			throw new Exception();
			}
	}
	
	public static int crearusuario(String nombre,String apellido,String contraseña,Connection conn) {
		
		Usuari usu = new Usuari();
		usu.setNom(nombre);
		usu.setCognom(apellido);
		usu.setPassword(contraseña);
		
		UsuarioController usuario=new UsuarioController(usu,new AppVideo());
		
		return usuario.createUsuario(usu,conn);
		
	}
	
	public static int crearVideo(String titol,String url,int idusuari,Connection conn) {
		
		Video video = new Video();
		video.setTitol(titol);
		video.setUrl(url);
		video.setIdusuari(idusuari);
		video.setFecha(null);
		video.setEstat(Estats.UPLOADING.toString());
		VideoController vid=new VideoController(video,new AppVideo());
		
		return vid.createVideo(video,conn);
		
	}
	
	public static int crearTag(String nomtag,int idvideo,Connection conn) {
		
		Tag tag = new Tag();
		tag.setNom_tag(nomtag);
		tag.setId_video(idvideo);
		
		TagController t=new TagController(tag,new AppVideo());
		
		return t.createTag(tag,conn);
		
	}
	
	public static List<Video> obtenerVideos(int idusuari,Connection conn) {
		
		Video video = new Video();
		video.setIdusuari(idusuari);
		
		VideoController vid=new VideoController(video,new AppVideo());
		
		return vid.getVideosByUsuari(idusuari,conn);
		
	}
	
	public static List<Tag> obtenerTags(int idvideo,Connection conn) {
		
		Tag tag = new Tag();
		tag.setId_video(idvideo);
		
		TagController t=new TagController(tag,new AppVideo());
		
		return t.getTagByIdVideo(idvideo,conn);
		
	}
	
	
			
	public static String contraseña() {
		
		String pass;
		
		// Creamos el panel que contendrá los componentes Label y Password
	    JPanel panel = new JPanel();
	    JLabel label = new JLabel("Contraseña:");
	    // Definimos el largo de la casilla para la contraseña
	    JPasswordField passwordField = new JPasswordField(15);
	    // Agregamos los componentes al panel
	    panel.add(label);
	    panel.add(passwordField);

	    // Definimos el texto de las opciones para aceptar o cancelar
	    String[] options = new String[]{"Aceptar", "Cancelar"};

	    // Agregamos el panel y las opciones al dialogo
	    int option = JOptionPane.showOptionDialog(null, panel, "Ingreso de Contraseña",
	            JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
	            null, options, options[1]);
	    char password[] = new char[15];
	    if(option == 0) // pressing OK button
	    {
	        password = passwordField.getPassword();
	        System.out.println("Contraseña: " + new String(password));
	    }else {
	        System.out.println("Ingreso de contraseña cancelada");
	    }
	    pass = String.valueOf(password);
	    return pass;
	}
		
}
