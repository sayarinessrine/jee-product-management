<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet">
</head>
<body id="page-top">
<section class="page-section" id="contact">
    <div class="container">
        <div class="text-center">
            <h3 class="section-heading text-uppercase">Enter the information</h3>
            <h3 class="section-subheading text-uppercase">Enter the information</h3>
        </div>

        <form action="login" method="POST" id="contactForm" data-sb-form-api-token="API_TOKEN">
            <div class="row align-items-stretch mb-5">
                <div class="col-md-6">

                    <div class="form-group">
                        <!-- Email address input-->
                        <input class="form-control" name="email" type="email" placeholder="Your Email " data-sb-validations="required,email" data-sb-can-submit="no">
                        <div class="invalid-feedback" data-sb-feedback="email:required">An email is required.</div>

                    </div>
                    <div class="form-group mb-md-0">
                        <!-- password input-->
                        <input class="form-control" name="password" type="password" placeholder="Your password " data-sb-validations="required" data-sb-can-submit="no">
                        <div class="invalid-feedback" data-sb-feedback="password:required">A password is required.</div>
                    </div>
                </div></div>
            <div class="text-center"> <button type="submit" class="btn btn-primary">Submit</button></div>

        </form>
    </div>
</section>
<footer class="footer py-4">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-4 text-lg-start">© 2024-2025 </div>
        </div>
    </div>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>