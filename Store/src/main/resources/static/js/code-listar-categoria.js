function getCharacters(done) {
	const results = fetch("http://localhost:8091/servicio/producto");
	results.then(response => response.json()).then(data => {
		done(data)
	});
}

var productoA=[];
getCharacters(data=>{
	productoA=data;
} );
 


 
const buscador=()=>{
	var nombreCategoria=document.getElementById("nom-categoria").textContent;
	
    for(p of productoA){
	

        if(p.idCategoria.nombreCategoria==nombreCategoria){
	
		if (p.nombreArchivo == null) {
			p.nombreArchivo = "default.jpg";
			
		}
		
	    const article=document.createRange().createContextualFragment(`
	      <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                            <!-- Product image-->
                            <img class="card-img-top" src="/datosIMG/${p.nombreArchivo}" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder"><a href="/servicio/${p.nombreProd}">${p.nombreProd}</a></h5>
                                    <span class="">${p.unidadM}</span>
                                    <!-- Product reviews-->
                                    <div class="d-flex justify-content-center small text-warning mb-2">
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                    </div>
                                    <!-- Product price-->
                                    <span class="text-muted text-decoration-line-through">s/${p.precioU}</span>
                                    s/${p.precioU} UN
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
                            </div>
                        </div>
                        
                        
                    </div>
	    
	    `);
	     const container = document.querySelector("#rm-categoria");
		container.append(article);
	    
	    console.log(p);
        }
        
        
        
        
    }
}
 
setTimeout(buscador,500);

 

