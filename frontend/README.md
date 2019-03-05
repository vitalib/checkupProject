# MVP0

## Docker

Создание докер образа и запуск докер контейнера, со страницей, доступной через порт localhost:8080:

- `docker build -t checkup-frontend:dev .` - создание образа checkup-frontend:dev

- `docker run --name checkUp -d -p 8080:80 checkup-frontend:dev` - запуск контейнера с именем checkUp, доступном на localhost:8080

## Yarn

Если yarn не установлен необходимо установить yarn (`sudo npm install yarn -g`).  
Чтобы локально сбилдить проект в папке frontend нужно ввести в терминале:

- `yarn`

- `yarn build` - после этого файл `index.html` будет находиться в папке папке `dist`.

Для разработки нужно вместо команды `yarn build` ввести `yarn dev` - и после этого вы можете менять код, и страница `index.html` из папки `dist`, которую вы открыли в браузере, тоже будет меняться.
