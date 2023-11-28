const btn = document.querySelector(".add-btn");

btn.addEventListener('click', () => {
    const nameProduct = document.querySelector(".name-product").value;
    const comment = document.querySelector(".add-comment").value;
    localStorage.setItem(nameProduct, comment);
    location.reload();
});

