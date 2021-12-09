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
    console.log(x,y);
    if (x !== y) {
        console.log("x khác y");
        document.getElementById("mess_error_register").innerHTML = "Password not match! Please try again!";
        return false;
    }
    else document.getElementById("mess_error_register").innerHTML = "";

}
window.onscroll = function() {scrollFunction()};
function topFunction(){
    document.body.scrollTop = 0; // For Safari
    document.documentElement.scrollTop = 0;
}

mybutton = document.getElementById("myBtn-scroll-top");
function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        mybutton.style.display = "block";
    } else {
        mybutton.style.display = "none";
    }
}
