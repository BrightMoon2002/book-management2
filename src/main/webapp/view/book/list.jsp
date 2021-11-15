<%--
  Created by IntelliJ IDEA.
  User: duynguyen
  Date: 14/11/2021
  Time: 09:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of Book</title>
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
<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
<title>Hoàng Duy Book</title>

</head>
<body>

    <div id="header2" style="position: sticky; z-index: 1000">
        <a style="float: right" href="">Login</a>
        <a style="float: right" href="">Register</a>
        <div class="warap-navbar2" style="background-color: RED;">
            <nav class="navbar2">
                <a style="font-size: larger; border: none" class="nav-link" href="/books?">
                    HOÀNG DUY BOOKS
                </a>

            </nav>
        </div>
        <div id="header">
            <div class="warap-navbar2" style="background-color: orange">
                <nav class="navbar2">
                    <a class="nav-link" href="https://kenh14.vn">
                        HD Books
                    </a>
                    <a class="nav-link" href="/books?action=create">
                        #Create new Book
                    </a>
                    <a class="nav-link" href="#">
                        #Sửa chữa - bảo hành
                    </a>
                    <form action="/books" method="get">
                        <input style="background-color: white; color: black" type="text" name="searchP"
                               placeholder="Producer">
                        <button type="submit">Search</button>
                    </form>
                </nav>
            </div>
            <div class="wrap-navbar" style="background-color: #a70d19">
                <nav class="navbar">
                    <a class="nav-link" href="#">
                        <i class="fas fa-home"></i>
                    </a>
                    <a href="" class="nav-link"><i class="fas fa-star"></i> Flash Sale</a>
                    <a href="/books?action=search&searchC=Novel" class="nav-link">Novel</a>
                    <a href="/books?action=search&searchC=Short Novel" class="nav-link">Short Novel</a>
                    <a href="/books?action=search&searchC=Comic" class="nav-link">Comic</a>
                    <a href="/books?action=search&searchC=Romantic" class="nav-link">Romantic</a>
                    <a href="/books?action=search&searchC=IT Program" class="nav-link">IT Program</a>
                    <a href="/books?action=search&searchC=Children" class="nav-link">Children</a>
                    <a href="/books?action=search&searchC=Law" class="nav-link">Law</a>
                    <a href="/books?action=search&searchC=Economic" class="nav-link">Economic</a>
                    <a href="/books?action=search&searchC=History" class="nav-link">History</a>
                    <a href="/books?action=search&searchC=Science" class="nav-link">Science</a>
                    <a href="/books?action=search&searchC=Politics" class="nav-link">Politics</a>
                    <a href="/books?action=search&searchC=Art" class="nav-link">Art</a>
                    <a href="https://shopee.vn/" class="nav-link">CT khuyến mại</a>
                </nav>
            </div>
        </div>
    </div>
        <form>
        <div style="padding-top: 200px" id="main-section">
            <div class="container-fluid">
                <div class="container">
                    <div class="row">
                        <c:forEach items="${list}" var="book">
                            <div class="col-md-3 col-sm-6 mb-5">
                                <div class="card" style="width: 100%;">
                                    <img src="IMAGINE/cat_linh_ha_dong.png" height="290" width="461"
                                         class="card-img-top" alt="...">
                                    <div class="card-body text-center">

                                        <h5 class="card-title text-center"><c:out value="${book.name}"/></h5>
                                        </a>
                                        <p class="card-text">Author: <a
                                                href="books?action=search&searchP=${book.getProducer()}"><c:out
                                                value="${book.producer}"/></a></p>
                                        <p class="card-text">Category: <a
                                                href="books?action=search&searchC=${book.category.name}"><c:out
                                                value="${book.category.name}"/></a></p>
                                        <p class="card-text">Price: <c:out value="${book.price}"/></p>
                                        <a href="/books?action=edit&id=${book.id}">Edit</a>
                                        <a href="/books?action=delete&id=${book.id}">Delete</a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
</form>
<%--                        //phần css của Lộc chỉnh--%>
<%--                                                    <c:forEach var="blog" items="${list}">--%>
<%--                                                        <div class="col-md-3 col-sm-6 mb-5">--%>
<%--                                                            <div class="card" style="width: 100%;">--%>
<%--                                                                <img src="#" class="card-img-top" alt="..." style="height: 200px">--%>
<%--                                                                <div class="card-body text-center">--%>
<%--                                                                    <h5 class="card-title text-center">${blog.name}</h5>--%>
<%--                                                                    <div class="d-flex justify-content-around mt-2 mb-3">--%>
<%--                                                        <span>--%>
<%--                                                            <i class="fas fa-calendar-alt text-primary" style="margin-right: 10px"></i>--%>
<%--                                                                ${blog.price}--%>
<%--                                                        </span> <br>--%>
<%--                                                                        <span>--%>
<%--                                                            <i class="fas fa-keyboard text-primary" style="margin-right: 10px"></i>--%>
<%--                                                                ${blog.category.name}--%>
<%--                                                        </span> <br>--%>
<%--                                                                    </div>--%>
<%--                                                                    <a href="#" class="btn btn-primary">Xem bài viết</a>--%>
<%--                                                                </div>--%>
<%--                                                            </div>--%>
<%--                                                        </div>--%>
<%--                                                    </c:forEach>--%>

<%--                        // bỏ phần sau--%>
                        <%--                    <div class="col-3">--%>
                        <%--                        <div class="card" style="width: 100%;">--%>
                        <%--                            <img src="IMAGINE/vo_hoia_lam.png" height="290" width="222" class="card-img-top"--%>
                        <%--                                 class="card-img-top" alt="...">--%>
                        <%--                            <div class="card-body">--%>
                        <%--                                <a href="https://kenh14.vn/nong-18-tre-tu-2-6-thang-tuoi-o-ha-noi-cap-cuu-do-bi-tiem-nham-vaccine-covid-19-20211104205120934.chn">--%>
                        <%--                                    <h5 class="card-title">Xiaomi Poco M4 Pro 5G</h5>--%>
                        <%--                                </a>--%>
                        <%--                            </div>--%>
                        <%--                        </div>--%>
                        <%--                    </div>--%>
                        <%--                    <div class="col-3">--%>
                        <%--                        <img src="IMAGINE/Diana.png" height="601" width="295" class="card-img-top" alt="...">--%>
                        <%--                        <div class="card-body">--%>
                        <%--                            <a href="https://kenh14.vn/nong-18-tre-tu-2-6-thang-tuoi-o-ha-noi-cap-cuu-do-bi-tiem-nham-vaccine-covid-19-20211104205120934.chn">--%>
                        <%--                            </a>--%>
                        <%--                        </div>--%>
                        <%--                    </div>--%>
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
