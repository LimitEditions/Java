// Представьте, что у вас есть класс для управления библиотекой. В этом классе будет приватное свойство для хранения списка книг, а также методы для добавления книги, удаления книги и получения информации о наличии книги.

// Класс должен содержать приватное свойство #books, которое инициализируется пустым массивом и представляет собой список книг в библиотеке.

// Реализуйте геттер allBooks, который возвращает текущий список книг.

// Реализуйте метод addBook(title), который позволяет добавлять книгу в список. Если книга с таким названием уже существует в списке, выбросьте ошибку с соответствующим сообщением.

// Реализуйте метод removeBook(title), который позволит удалять книгу из списка по названию. Если книги с таким названием нет в списке, выбросьте ошибку с соответствующим сообщением.

// Реализуйте метод hasBook(title), который будет проверять наличие книги в библиотеке и возвращать true или false в зависимости от того, есть ли такая книга в списке или нет.

// Реализуйте конструктор, который принимает начальный список книг (массив) в качестве аргумента.

class Library {
    #books = [];
    constructor(...title) {
        this.#books.push(...title);
    }

    get allBook() {
        return [...this.#books];
    }

    addBook(title) {
        if (this.#books.includes(title)) {
            throw new Error('Такая книга уже существует');
        }
        this.#books.push(title);
        return this.#books;
    }

    removeBook(title) {
        const indexSplise = this.#books.indexOf(title);
        if (indexSplise === -1) {
            throw new Error('Такой книги не существует');
        }
        else {
            this.#books.splice(indexSplise, 1);
            return this.#books;
        }
    }

    hasBook(title) {
        return this.#books.includes(title);
    }
}

const library = new Library("War and peace", "Once upon the time");

try {
    library.addBook("Master and Margarita");
    library.addBook("War and peace");
} catch (error) {
    console.error(error.message);
}

try {
    library.removeBook("Once upon the time");
    library.removeBook("Alice in wonderland");
} catch (error) {
    console.error(error.message);
}

try {
    console.log(library.hasBook("Once upon the time"));
    console.log(library.hasBook("Master and Margarita"));
} catch (error) {
    console.error(error.message);
}

console.log(library.allBook);