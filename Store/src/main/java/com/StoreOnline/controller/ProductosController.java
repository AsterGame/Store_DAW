package com.StoreOnline.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.StoreOnline.entity.Categoria;
import com.StoreOnline.entity.Producto;
import com.StoreOnline.entity.Proveedor;
import com.StoreOnline.service.CategoriaService;
import com.StoreOnline.service.ProductoService;
import com.StoreOnline.service.ProveedorService;
import com.StoreOnline.utils.Libreria;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;



@Controller
@RequestMapping ("/tables")
public class ProductosController {

	//Productos
	@Autowired 
	private ProductoService servicioProuctos;
	
	//Proveedores
	@Autowired 
	private ProveedorService servicioProveedores;
	
	//Categorias
	@Autowired
	private CategoriaService servicioCategorias;
	

	@RequestMapping("menu")
	public String menuPrincipal() {
		return "index";
		
	}
	
	
	
	
	@RequestMapping(value="listar")
	public String lis( Model model ) {
		model.addAttribute("super",servicioProuctos.lisProductos());
		model.addAttribute("prove",servicioProveedores.lisProveedores());
		model.addAttribute("categ",servicioCategorias.lisCategorias());
		
		return "tables";
		
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Producto buscar(@RequestParam("idProducto") Integer cod)
	{
		return servicioProuctos.buscarPorID(cod);
	}
	
	
	@RequestMapping("/grabar")
	public String actualizar (@RequestParam ("nombre_pro")String nombrePro,
			@RequestParam ("tipo_pro")int codtipoPro,@RequestParam ("tipo_cat")int tipoCate, @RequestParam ("unidad")String unidad,
			@RequestParam ("precio")double precio,@RequestParam ("stock_prod")int unidaddeExistencia, RedirectAttributes redirect) 
	{
		try {

			//Productos
			Producto p= new Producto();
			//p.setIdProducto(cod);
			p.setNombreProd(nombrePro);
			p.setUnidadM(unidad);
			p.setPrecioU(precio);
			p.setUnidadEx(unidaddeExistencia);
			
			
			//Proveedores aa
			Proveedor pr= new Proveedor();
			pr.setIdProv(codtipoPro);
			//Envio de objeto a productos
			p.setIdProveedor(pr);
			
			//Categorias
			Categoria c =new Categoria();
			c.setIdcate(tipoCate);
			//Envio de objeto a productos
			p.setIdCategoria(c);
			
			servicioProuctos.grabar(p);
		
			if(p.getIdProducto() ==0)
				redirect.addFlashAttribute("MENSAJE","Producto Registrado");
			
			else
			 redirect.addFlashAttribute("Mensaje","Mendicamento actualizado");	
			
			
		}catch(Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Error al grabar");
			e.printStackTrace();
		}
	
	return "redirect:/tables/listar";
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("idProducto")int cod, RedirectAttributes redirect) {
		try {
			servicioProuctos.eliminar(cod);
			redirect.addFlashAttribute("Mensaje","Producto eliminado");
			
		} catch (Exception e) {
			redirect.addFlashAttribute("Mensaje","Error al eliminar un producto");
			e.printStackTrace();
		}
		return "redirect:/tables/listar";
	}
	
	
	
	
	@RequestMapping("/subir-archivo")
	public String subirArchivo(@RequestParam("data") MultipartFile archivo,
			@RequestParam("codigo") Integer cod,
			RedirectAttributes redirect) throws IOException {
		//
		String nomArchivo=archivo.getOriginalFilename();
		//
		byte[] bytes=archivo.getBytes();
		//
		String ruta="C://tienda//datosIMG//";
		//generar archivo
		Files.write(Paths.get(ruta+nomArchivo), bytes);
		
		servicioProuctos.actualizarIMG(bytes, nomArchivo, cod);
		redirect.addFlashAttribute("MENSAJE","Foto actualizada");
		return "redirect:/tables/listar";
	}
	
	@RequestMapping("/consulta")
	@ResponseBody
	public List<Producto>consulta(@RequestParam("codigo")Integer cod){
		return servicioProuctos.listarProductosPorCategoria(cod);
	}
	

	@RequestMapping(value="consulta_producto")
	public String lista_Reporte( Model model ) {
		model.addAttribute("super",servicioProuctos.lisProductos());
		model.addAttribute("prove",servicioProveedores.lisProveedores());
		model.addAttribute("categ",servicioCategorias.lisCategorias());
		
		return "consulta_producto";
		
	}
	
	@RequestMapping("/reporte")
	public void reporte (HttpServletResponse response,@RequestParam("codigo")Integer cod) {
		try {
			List<Producto>data= servicioProuctos.listarProductosPorCategoria(cod);
			File file = ResourceUtils.getFile ("classpath:reporte_producto.jrxml");
			JRBeanCollectionDataSource info = new JRBeanCollectionDataSource(data);
			JasperPrint print = Libreria.generarReporte(file, info);
			response.setContentType("application/pdf");
			OutputStream salida=response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(print, salida);
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
}
