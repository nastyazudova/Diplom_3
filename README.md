Diplom_3

запуск в яндексе по команде ниже (вместо "128.0.6613.137" впишите версию из файла versions.json, самую близкую вашей версии браузера яндекс; вместо "C:\Users\user\AppData\Local\Yandex\YandexBrowser\Application\browser.exe" впишите путь на вашем компе до файла запуска браузера)

mvn clean test -Dbrowser=yandex '-Ddriver.version=128.0.6613.137' '-Dwebdriver.yandex.bin=C:\Users\user\AppData\Local\Yandex\YandexBrowser\Application\browser.exe'

Проверка перехода в личный кабинет включена в SignInTest 