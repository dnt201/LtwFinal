<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="ListProductPage">
    <img class="background" src="<c:url value='/assets/web/images/backgroundProduct.png'/>" alt="background"/>
    <div class="list-product-container">
        <div class="left-sidebar">
            <h2 class="header-left-sidebar"> Bộ lọc sản phẩm</h2>
            <div class="filter-wrap">
                <div class="filter-header">Hãng sản xuất</div>
                <div class="filter-body">
                    <div class="find-filter-wrap">
                        <c:forEach var="item" items="${brand.listResult}">
                            <div class="filter-item mg-b-8px">
                                <input type="radio" class="option-input radio" name="brand"
                                       value=${item.brand_name}
                                />
                                <span>${item.brand_name}</span>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="filter-wrap m-t-16px">
                <div class="filter-header">Mức giá</div>
                <div class="filter-wrap-price">
                    <div class="price-filter active"> All
                    </div>
                    <div class="price-filter"> Dưới 10tr
                    </div>
                    <div class="price-filter"> 10Tr - 15Tr
                    </div>
                    <div class="price-filter"> 15Tr - 20Tr
                    </div>
                    <div class="price-filter"> 20Tr - 30Tr</div>
                    <div class="price-filter"> 30Tr - 40Tr</div>
                    <div class="price-filter"> Trên 40tr</div>

                    <div class="price-filter-input-wrap">
                        <div class="m-b-8px">Hoặc nhập giá trị dưới đây</div>
                        <div class="filter-input-price">
                            <input class="form-input tu"
                                   placeholder="Từ"
                            />
                            <input class="form-input"
                                   placeholder="Đến"
                            />
                        </div>
                    </div>
                    <button class="btn-apply-price" onclick="">Áp dụng</button>
                </div>
            </div>
        </div>
        <div class="product-list">
            <div class="list-header">
                <div class="header-name-list">
                    <h2 class="mg-r-8px">Loại sản phẩm: </h2>
                    <h2><c:out value="${model.totalItem}"/> </h2>
                </div>
                <div class="header-sort-list">
                    <span class="mg-r-8px">Sắp xếp theo</span>
                    <select>
                        <option>
                            Mới nhất
                        </option>
                        <option>
                            Giá (thấp - cao)
                        </option>
                        <option>
                            Giá (cao - thấp)
                        </option>
                        <option>
                            Tên (A - Z)
                        </option>
                        <option>
                            Tên (Z - A)
                        </option>
                    </select>
                </div>
            </div>
            <div class="product-list list">
                <c:forEach var="item" items="${model.listResult}">
                    <div class="item-product">
                        <div class="stick-percent"><p>Giảm ${item.discount.discountPercent}%</p></div>
                        <img class="img-product" src="<c:url value='${item.image}'/>" alt="product images"/>
                        <h4 class="name"><b>${item.productName}</b></h4>
                        <div class="box-price">
                            <div class="sale-product">
                                <span class="price-sale"><fmt:formatNumber type = "number" value = "${item.price - item.price*item.discount.discountPercent/100}" /> đ</span>
                                <span class="price-old"><fmt:formatNumber type = "number" value = "${item.price}" /> đ</span>
                            </div>
                            <c:if test="${User.getRoleModel().getRoleName() !='admin'}">
                                <a class="add-to-card" href="<c:url value='/cart?action=add&&product_id=${item.product_id}'/> ">
                                    <i class="fas fa-cart-plus add-to-card-icon"></i>
                                </a>
                            </c:if>
                        </div>
                        <table>
                            <tbody>
                            <tr>
                                <td>
                                    <div class="detail">
                                        <img
                                                src="<c:url value='/assets/web/images/cpu.png'/>" data-ll-status="loaded"
                                                alt=""/>
                                        <b>${item.sCpu}</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img
                                                src="<c:url value='/assets/web/images/gpu.png'/>" alt=""/>
                                        <b>${item.sVga}</b>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="detail">
                                        <img src="<c:url value='/assets/web/images/ram.png'/>" data-ll-status="loaded"
                                             alt=""/>
                                        <b>${item.sRam}</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img src="<c:url value='/assets/web/images/storage.png'/>" alt=""/>
                                        <div class="flex_column_start">
                                            <b>SSD: ${item.sSsd}</b>
                                            <b>HDD: ${item.sSsd}</b>
                                        </div>
                                    </div>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <div class="detail">
                                        <img src="<c:url value='/assets/web/images/weight.png'/>" data-ll-status="loaded"
                                             alt=""/>
                                        <b>${item.sWeight}</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img
                                                src="<c:url value='/assets/web/images/size.png'/>" alt=""/>
                                        <div class="flex_column_start">
                                            <div>
                                                <b>${item.sSize}</b>
                                                <b>${item.sResolution}</b>
                                            </div>
                                            <b>${item.sHz}</b>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <a href="<c:url value='/product/detail?product_id=${item.product_id}'/>" class="btn-details">Details</a>
                    </div>
                </c:forEach>
            </div>


        </div>
    </div>
</div>