<%@include file="/WEB-INF/jspf/header.jspf" %>
<link rel="stylesheet" type="text/css" href="style/style.css">
<body>
<section class="vh-100">
  <div class="container-fluid h-custom">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-md-9 col-lg-6 col-xl-5">
        <img src="img/acc.png"
             class="img-fluid" alt="Sample image">
      </div>
      <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
        <form method="post" action="LoginEtudiant">
          <!-- Email input -->
          <div class="form-outline mb-4">
            <input type="email" name="txtEmail" class="form-control form-control-lg"
                   placeholder="Enter a valid email address" />
            <label class="form-label" >Email address</label>
          </div>
          <!-- Password input -->
          <div class="form-outline mb-3">
            <input type="password" name="txtpass" class="form-control form-control-lg"
                   placeholder="Enter password" />
            <label class="form-label" >Password</label>
          </div>

          <div class="d-flex justify-content-between align-items-center">
            <!-- Checkbox -->
            <div class="form-check mb-0">
              <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3" />

            </div>

          </div>

          <div class="text-center text-lg-start mt-4 pt-2">
            <button type="submit" class="btn btn-primary btn-lg"
                    style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
            <p class="small fw-bold mt-2 pt-1 mb-0"><a href="LoginAdmin.jsp"
                                                                              class="link-danger">Espace admin</a></p>
          </div>

        </form>
      </div>
    </div>
  </div>
  <div
          class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
    <!-- Copyright -->
    <div class="text-white mb-3 mb-md-0">
      Copyright © 2020. All rights reserved .
      <a href="http://tech-nova.site"> developed by Technova </a>
    </div>
    <!-- Copyright -->

    <!-- Right -->
    <div>
      <a href="#!" class="text-white me-4">
        <i class="fab fa-facebook-f"></i>
      </a>
      <a href="#!" class="text-white me-4">
        <i class="fab fa-twitter"></i>
      </a>
      <a href="#!" class="text-white me-4">
        <i class="fab fa-google"></i>
      </a>
      <a href="#!" class="text-white">
        <i class="fab fa-linkedin-in"></i>
      </a>
    </div>
    <!-- Right -->
  </div>
</section>





</body>
<script
        src="https://code.jquery.com/jquery-3.7.1.js"
        integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
</html>