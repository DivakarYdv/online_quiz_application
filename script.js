// Login Form Validation
document.getElementById('loginForm').addEventListener('submit', function (event) {
    event.preventDefault();
    const email = document.getElementById('email');
    const password = document.getElementById('password');

    let valid = true;

    if (!email.value.includes('@')) {
        email.classList.add('is-invalid');
        valid = false;
    } else {
        email.classList.remove('is-invalid');
    }

    if (password.value.trim() === '') {
        password.classList.add('is-invalid');
        valid = false;
    } else {
        password.classList.remove('is-invalid');
    }

    if (valid) alert('Login Successful!');
});

// Registration Form Validation
document.getElementById('registerForm').addEventListener('submit', function (event) {
    event.preventDefault();
    const regEmail = document.getElementById('regEmail');
    const regPassword = document.getElementById('regPassword');
    const confirmPassword = document.getElementById('confirmPassword');

    let valid = true;

    if (!regEmail.value.includes('@')) {
        regEmail.classList.add('is-invalid');
        valid = false;
    } else {
        regEmail.classList.remove('is-invalid');
    }

    if (regPassword.value.length < 8) {
        regPassword.classList.add('is-invalid');
        valid = false;
    } else {
        regPassword.classList.remove('is-invalid');
    }

    if (regPassword.value !== confirmPassword.value) {
        confirmPassword.classList.add('is-invalid');
        valid = false;
    } else {
        confirmPassword.classList.remove('is-invalid');
    }

    if (valid) alert('Registration Successful!');
});
