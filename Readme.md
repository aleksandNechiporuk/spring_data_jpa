Json for Show all Clients n Table:
GET http://localhost:8080/api/client/all

Json fod add new Client:
 POST http://localhost:8080/api/client
 {
        "name": "Andrey",
        "lastName": "Aleksand",
        "surName": "Novich",
        "email": "and.al.nov@abc.com",
        "creditAmount": 1111.0,
        "amountDebt": 120000.0,
        "plateg": 0.0,
        "plateg_date": null
 }

creditAmount - текущая задолженность, 
обязательный платеж;

amountDebt - задолженность по действующему кредиту
plateg_date - дата платежа, устанавливается после проведения  
платежа и погашения текущей задолженности.

Json for Edit client: 
PUT http://localhost:8080/api/client
{
        "id": 16,
        "name": "Andrey",
        "lastName": "Aleksand",
        "surName": "Novich",
        "email": "and.al.nov@abc.com",
        "creditAmount": 1111.0,
        "amountDebt": 120000.0,
        "plateg": 0.0,
        "plateg_date": null
}

Json for Show all table Plateg:
GET http://localhost:8080/api/client/allplateg

Json for add plateg and upwork plateg Client
POST http://localhost:8080/api/client/plateg

   {
        "clientId": 11,
        "plategClient": 2550.48,
        "datePlateg": "05-07-2021"
    }
    
    after plategUpWorc()
    {
        "id": 35,
        "clientId": 11,
        "plategClient": 2550.48,
        "datePlateg": "05-07-2021",
        "dateUpWork": "05-07-2021"
    }
Json Delete Client:
DELETE http://localhost:8080/api/client/{id}

Json Delete Plateg:
DELETE http://localhost:8080/api/client/plateg/{id}

Json клиентов с обязательным платежом 0.00 
(погасили задолженность)
GET http://localhost:8080/api/client/nocredamunt/0.00

Json для получения списка клиентов с адолженностью по 
обязательному платежу (не оплачен обязательный платеж)
GET http://localhost:8080/api/client//plategamnt/0.01


Все операции ввода, редактирования изменения клиентаили
платежа логируются. 
Настройки логирования:
resources/log4j2.xml  
log-file:
<Property name="LOG_PATH">g:/logs</Property>