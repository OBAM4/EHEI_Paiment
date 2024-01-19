<%@include file="/WEB-INF/jspf/header.jspf" %>
<link rel="stylesheet" type="text/css" href="style/style.css">
<section class="vh-100">
  <div class="container-fluid h-custom">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-md-9 col-lg-6 col-xl-5">
        <img src="img/acc.png"
             class="img-fluid" alt="Sample image">
      </div>
      <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
        <form method="POST" action="LoginEtudiant">
          <!-- Email input -->
          <div class="form-outline mb-4">
            <input type="email" name="txtEmail" class="form-control form-control-lg"
                   placeholder="Entrer une adresse email valide" />
          </div>
          <!-- Password input -->
          <div class="form-outline mb-3">
            <input type="password" name="txtpass" class="form-control form-control-lg"
                   placeholder="Entrer votre mot de passe" />
          </div>

          <div class="text-center text-lg-start mt-4 pt-2">
            <button type="submit" class="btn btn-primary btn-lg"
                    style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
            <p class="small fw-bold mt-2 pt-1 mb-0"><a href="LoginAdmin"
                 class="link-danger">Espace admin</a></p>
          </div>

        </form>
      </div>
    </div>
  </div>
  </section>