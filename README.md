# 🚀 Microcurrency Exchange System
Welcome to the Microcurrency Exchange System, a microservices architecture for currency exchange information retrieval and processing!

## Components
1. **Currency Provider**
   - Regularly updates exchange rates from an API and sends them to a message queue (RabbitMQ).

2. **Currency Persistence Service**
   - Stores the latest rates from the queue in a database.

3. **Exchange API**
   - Provides endpoints for currency information and exchange, implements user authentication, and sends email notifications for exchange events.

4. **Mail Service**
   - Handles the construction and sending of email notifications.

## Running the System
To deploy the entire system, use Docker Compose:
```bash
docker-compose up
```

This will launch all components, including queues and databases, creating a seamless environment for microservices communication.

👉 Note: Ensure that you have Docker and Docker Compose installed on your system before running the above command.

## Getting Started
1. Clone this repository to your local machine.
2. Navigate to the project directory.
3. Run the Docker Compose command.

🌟 Congratulations! Your Microcurrency Exchange System is now up and running.

## Contact
If you have any questions or would like to discuss this project further, feel free to reach out:

📧 Email: adrianks@op.pl
👔 LinkedIn: https://www.linkedin.com/in/adrianksiezak/

I look forward to hearing from you and discussing the exciting possibilities of our Microcurrency Exchange System!

# Examples

![image](https://github.com/adixks/exchange-api/assets/83171399/a6260184-2f52-4a62-8444-9887517d904b)
#

![image](https://github.com/adixks/exchange-api/assets/83171399/d429ec7c-018a-4cff-bb6f-b1e6f35c7a2d)
#

![image](https://github.com/adixks/exchange-api/assets/83171399/2d11de0f-f8c1-4184-b4b9-12432a176645)


