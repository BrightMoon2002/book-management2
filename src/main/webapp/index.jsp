<%--
  Created by IntelliJ IDEA.
  User: duynguyen
  Date: 13/11/2021
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Hoàng Duy Mobile</title>
  <link rel="stylesheet" href="css1.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
        integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"/>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css"
        href="https://cdn.jsdelivr.net/gh/kenwheeler/slick@1.8.1/slick/slick-theme.css"/>
  <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>

</head>
<body>
<div>


<div id="header2">
  <a style="float: right" href="">Login</a>
  <a style="float: right" href="">Register</a>
  <div class="warap-navbar2" style="background-color: RED">
    <nav class="navbar2">
      <a style="font-size: larger; border: none" class="nav-link" href="/books">
        HOÀNG DUY MOBILE
      </a>
      <form action="/books" method="get">
        <input style="background-color: white; color: black" type="text" name="search" placeholder="Producer">
        <button type="submit">Search</button>
      </form>

    </nav>

  </div>
  <div id="header">
    <div class="warap-navbar2" style="background-color: orange">
      <nav class="navbar2">
        <a class="nav-link" href="books">
          HD Mobile
        </a>
        <a class="nav-link" href="books">
          #Tin tức
        </a>
        <a class="nav-link" href="books">
          #Sửa chữa - bảo hành
        </a>
      </nav>
    </div>
    <div class="wrap-navbar" style="background-color: #a70d19">
      <nav class="navbar">
        <a class="nav-link" href="#">
          <i class="fas fa-home"></i>
        </a>
        <a href="" class="nav-link"><i class="fas fa-star"></i> Flash Sale</a>
        <a href="" class="nav-link">Apple</a>
        <a href="" class="nav-link">Samsung</a>
        <a href="" class="nav-link">Oppo</a>
        <a href="" class="nav-link">Huawei</a>
        <a href="" class="nav-link">Xiaomi</a>
        <a href="" class="nav-link">Vsmart</a>
        <a href="" class="nav-link">Vivo</a>
        <a href="" class="nav-link">Nokia</a>
        <a href="" class="nav-link">Black Berry</a>
        <a href="" class="nav-link">Phillips</a>
        <a href="" class="nav-link">Itel</a>
        <a href="" class="nav-link">Vertu</a>
        <a href="" class="nav-link">CT khuyến mại</a>
      </nav>
    </div>
  </div>

  <div id="main-section">
    <div class="container-fluid">
      <div class="container">
        <div class="row">
          <div class="col-3">
            <div class="card
" style="width: 100%;">
              <img src="IMAGINE/cat_linh_ha_dong.png" height="290" width="461" class="card-img-top" alt="...">
              <div class="card-body">
                <a href="https://kenh14.vn/nong-18-tre-tu-2-6-thang-tuoi-o-ha-noi-cap-cuu-do-bi-tiem-nham-vaccine-covid-19-20211104205120934.chn">
                  <h5 class="card-title">IPhone 13 Pro Max</h5>
                </a>
                <p class="card-text">Iphone chính hãng (VN/A, SA) màu xanh, vàng, đỏ...</p>
              </div>
            </div>
          </div>
          <div class="col-3">
            <div class="card" style="width: 100%;">
              <img src="IMAGINE/vo_hoia_lam.png" height="290" width="222" class="card-img-top"
                   class="card-img-top" alt="...">
              <div class="card-body">
                <a href="https://kenh14.vn/nong-18-tre-tu-2-6-thang-tuoi-o-ha-noi-cap-cuu-do-bi-tiem-nham-vaccine-covid-19-20211104205120934.chn">
                  <h5 class="card-title">Xiaomi Poco M4 Pro 5G</h5>
                </a>
              </div>
            </div>
          </div>
          <div class="col-3">
            <img src="IMAGINE/Diana.png" height="601" width="295" class="card-img-top" alt="...">
            <div class="card-body">
              <a href="https://kenh14.vn/nong-18-tre-tu-2-6-thang-tuoi-o-ha-noi-cap-cuu-do-bi-tiem-nham-vaccine-covid-19-20211104205120934.chn">
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>

</body>
</html>
