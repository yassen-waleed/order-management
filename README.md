# order-management

I create my resources for the customer, order, product, stock, and product order, then make the relationship between them. I've added a controller,DTO, models, repository, and services to each one. I use the JWT token to ensure that the user is authorized.

My Resourses APIs 

![Http method 1](https://user-images.githubusercontent.com/81925932/172474038-a8ba978c-fb02-4027-a33f-5e989d67e5bb.PNG)

![image](https://user-images.githubusercontent.com/81925932/172473931-ac98ef08-adcb-4593-a2fa-73de1f35f1bf.png)

To show postman testing JSON File:  

https://github.com/yassen-waleed/order-management/blob/master/Assignment_2(Order%20Managment).postman_collection


### Build docker image
```bash
docker build -t order_management_app .

OR using docker-compose to start the app and MySQL DB together

docker-compose down  # if the service already up

docker-compose up
```

----------------------------my docker Hub repository -------------------------------------

https://hub.docker.com/repository/docker/1182089/order_management_app






