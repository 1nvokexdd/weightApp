Система предназначена для учета питания пользователей, расчета их дневной нормы калорий и формирования отчетов. Проект реализован на Spring Boot с использованием PostgreSQL.

 Функциональность
1. Пользователи
Добавление пользователя
{
  "id": 1,
  "name": "Иван Иванов",
  "email": "ivan@example.com",
  "age": 30,
  "weight": 75.5,
  "height": 180,
  "target": "Похудение"
}
Расчет нормы калорий
Используется формула Харриса-Бенедикта.

2. Блюда
Добавление блюда

{
    "name":"hamburger",
    "calories":"407",
    "proteins":"33.75",
    "fats":"13.72",
    "carbs":"42.58"
}
3. Приемы пищи
Добавление приема пищи
{
 "userId":"8",
   "date":"2025-03-30",
   "mealIds":[1,2]
}
4. Отчеты
Доступные отчеты:
Дневной отчет - сумма калорий и список приемов пищи

Проверка нормы калорий

История питания по дням

🛠 Технологический стек
Backend: Spring Boot 3.x

База данных: PostgreSQL

ORM: Spring Data JPA

Тестирование: JUnit 5, Mockito

Валидация: Bean Validation

✅ Валидация данных
Реализованы проверки:

Вес: 20-500 кг

Рост: 110-250 см

Возраст: 5-100 лет

Email: валидный формат

Названия: не пустые

🧪 Тестирование
Написаны юнит-тесты для:

Логики добавления приемов пищи

Логики добавления приемов пользователя

🚨 Обработка ошибок
Реализованы обработчики для:

Пользователь не найден (404)

Некорректные данные (400)

Внутренние ошибки (500)

📊 Примеры отчета

{
    "date": "2025-03-30",
    "dailyCallories": 2220.0,
    "dailyNorm": 1910.36,
    "dailyAch": false,
    "meals": [
        {
            "id": 1,
            "user": {
                "id": 8,
                "name": "alex",
                "email": "alex@gmail.com",
                "age": 20,
                "weight": 80.0,
                "height": 180.0,
                "target": "Maintenance",
                "calorie_norm": 1910.36
            },
            "date": "2025-03-30",
            "meals": [
                {
                    "id": 1,
                    "name": "sandwich",
                    "calories": 344.0,
                    "proteins": 11.64,
                    "fats": 17.4,
                    "carbs": 35.03
                },
                {
                    "id": 2,
                    "name": "apple",
                    "calories": 100.0,
                    "proteins": 0.0,
                    "fats": 0.5,
                    "carbs": 24.0
                }
            ]
        },
        {
            "id": 2,
            "user": {
                "id": 8,
                "name": "alex",
                "email": "alex@gmail.com",
                "age": 20,
                "weight": 80.0,
                "height": 180.0,
                "target": "Maintenance",
                "calorie_norm": 1910.36
            },
            "date": "2025-03-30",
            "meals": [
                {
                    "id": 1,
                    "name": "sandwich",
                    "calories": 344.0,
                    "proteins": 11.64,
                    "fats": 17.4,
                    "carbs": 35.03
                },
                {
                    "id": 2,
                    "name": "apple",
                    "calories": 100.0,
                    "proteins": 0.0,
                    "fats": 0.5,
                    "carbs": 24.0
                }
            ]
        },
        {
            "id": 4,
            "user": {
                "id": 8,
                "name": "alex",
                "email": "alex@gmail.com",
                "age": 20,
                "weight": 80.0,
                "height": 180.0,
                "target": "Maintenance",
                "calorie_norm": 1910.36
            },
            "date": "2025-03-30",
            "meals": [
                {
                    "id": 1,
                    "name": "sandwich",
                    "calories": 344.0,
                    "proteins": 11.64,
                    "fats": 17.4,
                    "carbs": 35.03
                },
                {
                    "id": 2,
                    "name": "apple",
                    "calories": 100.0,
                    "proteins": 0.0,
                    "fats": 0.5,
                    "carbs": 24.0
                }
            ]
        },
        {
            "id": 5,
            "user": {
                "id": 8,
                "name": "alex",
                "email": "alex@gmail.com",
                "age": 20,
                "weight": 80.0,
                "height": 180.0,
                "target": "Maintenance",
                "calorie_norm": 1910.36
            },
            "date": "2025-03-30",
            "meals": [
                {
                    "id": 1,
                    "name": "sandwich",
                    "calories": 344.0,
                    "proteins": 11.64,
                    "fats": 17.4,
                    "carbs": 35.03
                },
                {
                    "id": 2,
                    "name": "apple",
                    "calories": 100.0,
                    "proteins": 0.0,
                    "fats": 0.5,
                    "carbs": 24.0
                }
            ]
        },
        {
            "id": 6,
            "user": {
                "id": 8,
                "name": "alex",
                "email": "alex@gmail.com",
                "age": 20,
                "weight": 80.0,
                "height": 180.0,
                "target": "Maintenance",
                "calorie_norm": 1910.36
            },
            "date": "2025-03-30",
            "meals": [
                {
                    "id": 1,
                    "name": "sandwich",
                    "calories": 344.0,
                    "proteins": 11.64,
                    "fats": 17.4,
                    "carbs": 35.03
                },
                {
                    "id": 2,
                    "name": "apple",
                    "calories": 100.0,
                    "proteins": 0.0,
                    "fats": 0.5,
                    "carbs": 24.0
                }
            ]
        }
    ]
}
]
