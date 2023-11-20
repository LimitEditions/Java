// Задание 1
// • Используя Symbol.iterator, создайте объект "Музыкальная коллекция", который можно итерировать. Каждая итерация должна возвращать следующий альбом из коллекции.

// • Создайте объект musicCollection, который содержит массив альбомов и имеет свойство-символ Symbol.iterator. Каждый альбом имеет следующую структуру:

// {
// title: "Название альбома",
// artist: "Исполнитель",
// year: "Год выпуска"
// }

// • Реализуйте кастомный итератор для объекта musicCollection. Итератор должен перебирать альбомы по порядку.
// • Используйте цикл for...of для перебора альбомов в музыкальной коллекции и вывода их на консоль в формате: Название альбома - Исполнитель (Год выпуска)

const musicCollection = {
    alboms: [
        {
            title: "80-e",
            artist: "Modern Token",
            year: 1981
        },
        {
            title: "90-e",
            artist: "Dj Groove",
            year: 1992
        },
        {
            title: "2000-e",
            artist: "Taty",
            year: 2008
        }]
};

musicCollection[Symbol.iterator] = function () {
    let index = 0;
    return {
        next: () => {
            if (index < this.alboms.length) {
                return { value: this.alboms[index++], done: false };
            } else {
                return { done: true };
            }
        }
    };
};

for (let albom of musicCollection) {
    console.log(`${albom.title} - ${albom.artist} (${albom.year})`);
}

// Задание 2
// Вы управляете рестораном, в котором работают разные повара, специализирующиеся на определенных блюдах. Клиенты приходят и делают заказы на разные блюда.

// Необходимо создать систему управления этими заказами, которая позволит:

// • Отслеживать, какой повар готовит какое блюдо.
// • Записывать, какие блюда заказал каждый клиент.

// Используйте коллекции Map для хранения блюд и их поваров, а также для хранения заказов каждого клиента. В качестве ключей для клиентов используйте объекты.

// Повара и их специализации:

// Виктор - специализация: Пицца.
// Ольга - специализация: Суши.
// Дмитрий - специализация: Десерты.

// Блюда и их повара:

// Пицца "Маргарита" - повар: Виктор.
// Пицца "Пепперони" - повар: Виктор.
// Суши "Филадельфия" - повар: Ольга.
// Суши "Калифорния" - повар: Ольга.
// Тирамису - повар: Дмитрий.
// Чизкейк - повар: Дмитрий.

// Заказы:

// Клиент Алексей заказал: Пиццу "Пепперони" и Тирамису.
// Клиент Мария заказала: Суши "Калифорния" и Пиццу "Маргарита".
// Клиент Ирина заказала: Чизкейк.

const dishses = new Map();
dishses.set('Пицца "Маргарита"', "Виктор")
    .set('Пицца "Пепперони"', "Виктор")
    .set('Суши "Филадельфия"', "Ольга")
    .set('Суши "Калифорния"', "Ольга")
    .set('Тирамису', "Дмитрий")
    .set('Чизкейк', "Дмитрий");

const orderAlex = { 'Пицца "Пепперони"': 1, 'Тирамису': 1 };
const orderMary = { 'Суши "Калифорния"': 1, 'Пицца "Маргарита"': 1 };
const orderIren = { 'Чизкейк': 1 };
const orders = new Map();
orders.set("Алексей", orderAlex)
    .set("Мария", orderMary)
    .set("Ирина", orderIren);

for (let [klient, order] of orders.entries()) {
    console.log(`Заказ клиента ${klient}: `);
    for (let dish in order) {
        console.log(`${dish}, готовит повар ${dishses.get(dish)}`);
    }
} 


