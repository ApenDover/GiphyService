# Giphy Service
Создать сервис, который обращается к сервису курсов валют, и отдает gif в ответ:<br>
Если курс по отношению к рублю за сегодня стал выше вчерашнего, то отдаем рандомную отсюда https://giphy.com/search/rich <br>
Если ниже - отсюда https://giphy.com/search/broke <br>
<br>Ссылки<br>
REST API курсов валют: https://docs.openexchangerates.org/ <br>
REST API гифок: https://developers.giphy.com/docs/api#quick-start-guide
<br><br>
Must Have
<br>
Сервис на Spring Boot 2 + Java / Kotlin. Запросы приходят на HTTP endpoint, туда передается код валюты.
Для взаимодействия с внешними сервисами используется Feign. Все параметры (валюта по отношению к которой смотрится курс, адреса внешних сервисов и т.д.) вынесены в настройки.
<br>
На сервис написаны тесты (для мока внешних сервисов можно использовать @mockbean или WireMock). Для сборки должен использоваться Gradle. Результатом выполнения должен быть репо на GitHub с инструкцией по запуску.
<br><br>Nice to Have<br>
Сборка и запуск Docker контейнера с этим сервисом.

# Настройки

Для конфигурации отредактируйте файл application.properties

# Инструкция по запуску

С использованием Gradle:<br>
1. Убедитесь, что установлен Gradle, если нет - установите: https://gradle.org/install/
2. Откройте CMD / Terminal, перейдите в папку проекта.
3. выполните команду "gradle bootRun"

После старта приложения открываем в браузере страницу по адресу http://localhost:8080/
