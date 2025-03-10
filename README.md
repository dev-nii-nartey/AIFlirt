# AIFlirt Backend

AIFlirt is a next-generation dating application that leverages AI technology to create engaging and authentic user profiles, making online dating more personalized and genuine. This Spring Boot application provides the backend services needed to power the AIFlirt platform.

## 📋 Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Setup and Installation](#setup-and-installation)
  - [Docker Deployment (Recommended)](#docker-deployment)
  - [Manual Setup](#manual-setup)
- [Development](#development)
- [Contributing](#contributing)
- [License](#license)

## ✨ Features

- **Smart Profile Crafting**: AI-generated detailed profiles highlighting personalities and interests
- **Tailored Matches**: AI-suggested compatible matches based on shared interests
- **Live Profile Updates**: Real-time profile updates to maintain accuracy
- **Icebreaker Bots**: AI-powered chatbots that help initiate conversations
- **Enhanced Safety**: AI algorithms to detect and block suspicious activities

## 🛠️ Tech Stack

- Java 21
- Spring Boot 3.4.0
- Spring AI
- MongoDB
- Docker
- Ollama (for running DeepSeek AI models)
- OpenAPI/Swagger for API documentation

## 📝 Prerequisites

- Docker and Docker Compose (for recommended deployment method)
- Java 21 or higher (for manual setup)
- Maven 3.8+ (for manual setup)
- Git

## 🚀 Setup and Installation

### 🐳 Docker Deployment (Recommended)

The simplest way to run AIFlirt is using Docker Compose, which will automatically set up all required services including the application, MongoDB, and Ollama with the correct configuration:

1. **Clone the repository**:

```bash
git clone https://github.com/dev-nii-nartey/aiflirt.git
cd aiflirt
```

2. **Deploy using docker-compose**:

```bash
docker-compose up -d
```

3. **Pull the DeepSeek model**:

After the services are up and running, pull the DeepSeek model:

```bash
docker exec -it ollama ollama pull deepseek-coder:6.7b
```

4. **Access the application**:

Once running, the application will be available at the configured port (default: 3000).

### Manual Setup

If you prefer to run components separately:

1. **Clone the repository**:

```bash
git clone https://github.com/dev-nii-nartey/aiflirt.git
cd aiflirt
```

2. **Configure application properties**:

Edit `src/main/resources/application-dev.properties` to set up MongoDB connection and other properties according to your environment.

3. **Build and run the application**:

```bash
mvn clean package
java -jar target/AIFlirt-0.0.1-SNAPSHOT.jar
```

Or with Maven:

```bash
mvn spring-boot:run
```

## 💻 Development

To set up the development environment:

```bash
# Clone the repository
git clone https://github.com/dev-nii-nartey/aiflirt.git
cd aiflirt

# Open with your preferred IDE (IntelliJ IDEA recommended)
# Install dependencies
mvn clean install
```

## 👥 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.