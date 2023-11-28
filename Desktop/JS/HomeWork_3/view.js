const list = document.querySelector(".list");

for (let key in localStorage) {
    if (!localStorage.hasOwnProperty(key)) {
        continue;
    }
    const divElement = document.createElement('div');
    const nameElement = document.createElement('h3');
    nameElement.textContent = key;
    nameElement.className = "key";
    list.appendChild(divElement);
    divElement.appendChild(nameElement);
    let rewievAdd = false;

    nameElement.addEventListener('click', () => {
        if(!rewievAdd){
        const divItem = document.createElement('div');
        divItem.className = "boxItem";
        const text = document.createElement('p');
        text.textContent = localStorage.getItem(key);
        text.className = "text";
        const delBtn = document.createElement('button');
        delBtn.textContent = "Удалить отзыв";
        delBtn.className = "delBtn";
        divElement.appendChild(divItem);
        if (text.textContent !== "") {
            divItem.appendChild(text);
            divItem.appendChild(delBtn);
        }
      
        delBtn.addEventListener('click', () => {
            localStorage.removeItem(key);
            divElement.removeChild(divItem);
        });

        rewievAdd = true;
    }
    });
}


