/**
 * @param String name
 * @return String
 */
function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
    results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

var prodId = getParameterByName('codigo');
console.log(prodId);

function getCharacters(done){
  const results=fetch("http://localhost:8091/mia/buscar?codigo="+prodId);
  results.then(response=> response.json()).then(data=>{
    done(data)
  });
}

getCharacters(data=>{
  console.log(data.nombreProd
);

const article=document.createRange().createContextualFragment(/*html*/`
   <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="https://dummyimage.com/600x700/dee2e6/6c757d.jpg" alt="..." /></div>
                    <div class="col-md-6">
                        <div class="small mb-1">SKU: BST-498</div>
                        <h1 class="display-5 fw-bolder" id="idNom">${data.nombreProd}</h1>
                        <div class="fs-5 mb-5">
                            <span class="text-decoration-line-through">s/${data.precioU}</span>
                            <span>s/${data.precioU}</span>
                        </div>
                        <p class="lead">Lorem ipsum dolor sit amet consectetur adipisicing elit. Praesentium at dolorem quidem modi. Nam sequi consequatur obcaecati excepturi alias magni, accusamus eius blanditiis delectus ipsam minima ea iste laborum vero?</p>
                        <div class="d-flex">
                            <input class="form-control text-center me-3" id="inputQuantity" type="num" value="1" style="max-width: 3rem" />
                            <button class="btn btn-outline-dark flex-shrink-0" type="button">
                                <i class="bi-cart-fill me-1"></i>
                                Add to cart
                            </button>
                        </div>
                    </div>
                </div>
            </div>

    `      
      
    );
    const container=document.querySelector("#rm-card");
     container.append(article);
  
    

  
  
});





