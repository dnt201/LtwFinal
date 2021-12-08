<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="ListProductPage">
    <img class="background" src="" alt="background"/>
    <div class="container">
        <div class="left-sidebar">
            <h2 class="header-left-sidebar"> Bộ lọc sản phẩm</h2>
            <div class="filter-wrap">
                <div class="filter-header">Hãng sản xuất</div>
                <div class="filter-body">
                    <div class="find-filter-wrap">
                        <div class="filter-item mg-b-8px">
                            <input type="radio" class="option-input radio" name="brand"
                                   value=Acer
                            />
                            <span>MSI</span>
                        </div>
                        <div class="filter-item mg-b-8px">
                            <input type="radio" class="option-input radio" name="brand"
                                   value=MSI
                            />
                            <span>MSI</span>
                        </div>
                        <div class="filter-item mg-b-8px">
                            <input type="radio" class="option-input radio" name="brand"
                                   value={0}
                            />
                            <span>All</span>
                        </div>
                        {/*End render hãng*/}
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
                    {listPrice.map((item) => (

                    <div class="price-filter-input-wrap">
                        <div class="m-b-8px">Hoặc nhập giá trị dưới đây</div>
                        <div class="filter-input-price m-b-8px">
                            <input placeholder="Từ"/>
                            <input placeholder="Đến"/>
                        </div>
                    </div>
                    <button class="btn-apply-price" onclick="">Áp dụng</button>
                </div>
            </div>
        </div>

        <div class="product-list">
            <div class="list-header">
                <div class="header-name-list">
                    <h2 class="mg-r-8px">Loại sản phẩm</h2>
                    <span>Số lượng sản phẩm</span>
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
            <div class="product-list">
                <div>Product 1</div>
                <div>Product 1</div>
                <div>Product 1</div>
            </div>
        </div>
    </div>
</div>