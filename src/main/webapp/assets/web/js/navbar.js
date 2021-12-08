function toggleNav() {
    let x = document.getElementById("top-nav")
    if (x.className === "nav") {
        x.className+= " active"
    }
    else {
        x.className = "nav";
    }
}

function validatePassWorkConfirm() {
    let x = document.forms["register-form"]["password"].value;
    let y = document.forms["register-form"]["confPassword"].value;
    if (x != y) {
        document.getElementById("mess_error_register").innerHTML = "Password not match! Please try again!";
        return false;
    }
    else document.getElementById("mess_error_register").innerHTML = "";

}