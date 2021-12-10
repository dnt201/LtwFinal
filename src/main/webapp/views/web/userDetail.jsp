<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/10/2021
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container rounded bg-white mt-2 mb-1">
    <div class="row">
        <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5"
                                                                                         width="150px"
                                                                                         src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span
                    class="font-weight-bold">Edogaru</span><span
                    class="text-black-50">edogaru@mail.com.my</span><span> </span></div>
        </div>
        <div class="col-md-9 border-right">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right">Profile Settings</h4>
                </div>
                <div class="row mt-3">
                    <div class="col-md-12">
                        <label class="labels">Full Name: </label>
                        <input type="text" class="form-control" placeholder="Enter your name..." value=""
                               name="username">
                    </div>
                    <div class="col-md-12">
                        <label class="labels">Email: </label>
                        <input type="text" class="form-control" placeholder="Enter your email..." value=""
                               name="email">
                    </div>
                    <div class="col-md-12">
                        <label class="labels">Address: </label>
                        <input type="text" class="form-control" placeholder="Enter your address..." value=""
                               name="address">
                    </div>
                    <div class="col-md-12">
                        <label class="labels">Phone number: </label>
                        <input type="number" class="form-control" placeholder="Enter your phone number..." value="">
                    </div>
                </div>
                <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="button">Save
                    Profile</button></div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 ">
            <h1>List order</h1>
        </div>
        <!-- Render list order -->
        <div class="col-md-12">
            <span class="col-md-3">order_id</span>
            <span class="col-md-3">usersModel</span>
            <span class="col-md-3">total</span>
            <span class="col-md-3">createAt</span>
        </div>
    </div>


    <!-- End list order-->
</div>
</div>
