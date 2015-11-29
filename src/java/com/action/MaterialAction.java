package com.action;

import java.io.IOException;
import java.util.List;
import com.dao.DaoMaterial;
import com.model.Material;
import com.opensymphony.xwork2.Action;

public class MaterialAction  {
	
	private DaoMaterial dao = new DaoMaterial();
	private List<Material> records;
	private String result;
	private String message;
	private Material record;

	private int codigo;	
	private String articulo;
	private String u_medidasd;
	private String marca;
       
	public String list() {
		try {
			// Fetch Data from Material Table
			records = dao.getAllMateriales();
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;	
	}

	public String create() throws IOException {
		record = new Material();
		
		//record.setCodigo(codigo);
		record.setArticulo(articulo);
                record.setU_medida(u_medidasd);
		record.setMarca(marca);
                try {
			// Create new record
			dao.addMateriales(record);
			result = "OK";

		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;	
	}

	public String update() throws IOException {
		Material material = new Material();
		
		material.setCodigo(codigo);
		material.setArticulo(articulo);
		material.setU_medida(u_medidasd);
		material.setMarca(marca);
		
		try {
			// Update existing record
			dao.updateMateriales(material);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}

	public String delete() throws IOException {
		// Delete record
		try {
			dao.deleteMateriales(this.codigo);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}
        
        
      private int codigoMaterial;
      
      public  String  buscaMatPorCodigo() throws IOException {
      try {
                       
             System.out.println("recurso de la jsp:  " + codigoMaterial);
             record = dao.buscaMatPorCodigo(codigoMaterial);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}     
          System.out.println("articulo:  " + record.getArticulo());
          System.out.println("codigo:  " + record.getCodigo());
          System.out.println("marca:  " + record.getMarca());
          System.out.println("medida:  " + record.getU_medida());
		return Action.SUCCESS;
      }

    /// getters  and settters

    public int getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(int codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

 
  
    public DaoMaterial getDao() {
        return dao;
    }

    public void setDao(DaoMaterial dao) {
        this.dao = dao;
    }

    public List<Material> getRecords() {
        return records;
    }

    public void setRecords(List<Material> records) {
        this.records = records;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Material getRecord() {
        return record;
    }

    public void setRecord(Material record) {
        this.record = record;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getU_medida() {
        return u_medidasd;
    }

    public void setU_medida(String u_medidasd) {
        this.u_medidasd = u_medidasd;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
        
}
