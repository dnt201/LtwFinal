<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>

<div class="wrap-form-center">
    <form id="form" action="<c:url value='/admin/brand'/>" class="formCenter shadow p-3 mb-5 bg-body rounded">
        <div class="form-header">
            <h1>Brand Insert or Update</h1>
            <ul class="list-inline text-sm">
                <li class="list-inline-item"><button class=" btn btn-outline-warning"><i class="fas fa-copy me-2">
                </i>Copy</button></li>
                <li class="list-inline-item"><button class=" btn btn-outline-info"><i class="fas fa-download me-2">
                </i>Import</button></li>
            </ul>
            <h6><i class="text-danger">${messageResponse}</i></h6>
        </div>
        <section>
            <div>
                <div class="">
                    <div class="">
                        <div class="card-header">
                            <div class="card-heading">
                                <h5>Form brand</h5>
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="row gy-3">
                                <div class="col-12">
                                    <h6 class="form-label fw-bold">Brand name <i
                                            class="fa fa-file-signature"></i></h6>
                                    <input name="brand_name" class="form-control"
                                           value="${BrandModel.brand_name}">
                                </div>
                            </div>
                            <div style="margin-top: 10px" class="form-text" id="notification"></div>
                            <c:if test="${empty BrandModel}">
                                <input type="hidden" name="action" value="add"/>
                                <button style="margin-top: 10px"
                                        class="btn btn-outline-primary mb-4">Add brand</button>
                            </c:if>
                            <c:if test="${not empty BrandModel}">
                                <input type="hidden" value=${BrandModel.brand_id} id="brand_id" name="brand_id">
                                <input type="hidden" name="action" value="update"/>
                                <button  style="margin-top: 10px"
                                        class="btn btn-outline-danger mb-4">Update</button>
                                <button  style="margin-top: 10px"
                                        class="btn btn-outline-success mb-4">Save</button>
                            </c:if>

                        </div>
                    </div>
                </div>

            </div>
        </section>
    </form>
</div>