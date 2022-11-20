
 /* @param String name
 * @return String
 */
/*function getParameterByName(name) {
	name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
		results = regex.exec(location.search);
	return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

var prodId = getParameterByName('codigo');
console.log(prodId);*/

function getCharacters(done) {
	const results = fetch("http://localhost:8091/servicio/producto");
	results.then(response => response.json()).then(data => {
		done(data)
	});
}

getCharacters(data => {
	console.log(data);

	for (p of data) {

		if (p.nombreArchivo == null) {
			p.nombreArchivo = "default.jpg";
			
		}

		const article = document.createRange().createContextualFragment(/*html*/`
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
                               

    `

		);



		const container = document.querySelector("#rm-card");
		container.append(article);



	}


});




/*const buscar=(nombre)=>{
    for(x of productoA){
        if(nombre==x.nombreProd){
            return x;
        }
    }
};*/




