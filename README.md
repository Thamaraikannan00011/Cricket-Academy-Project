
🏏 Cricket Academy Project -- Dockerized Full‑Stack Application
==============================================================

The Cricket Academy Project is a fully containerized full‑stack web application that helps manage day‑to‑day operations of a cricket academy.\
It is designed to be easy to run on any machine that has Docker and Docker Compose installed.

📦 Tech Stack
-------------

-   Backend: Spring Boot (REST API, business logic)

-   Frontend: Python Flask (server‑rendered UI)

-   Database: PostgreSQL

-   Infrastructure: Docker & Docker Compose

* * * * *

🧱 Architecture & Workflow
--------------------------

The project is split into three main services, all orchestrated by Docker Compose.

1. Flask Frontend (UI Layer)
-----------------------------

-   Exposes the web interface on port 5000 (e.g. `http://localhost:5000`)

-   Renders Jinja2 templates from the `templates/` folder and serves CSS/JS from `static/`

-   Provides pages such as:

    -   Players list / create / edit

    -   Coaches list / create / edit

    -   Batches and schedules

Inside Docker, the hostname `backend` resolves to the Spring Boot container.

* * * * *

2\. Spring Boot Backend (API & Business Logic)
----------------------------------------------

-   Exposes REST endpoints on port 8080 inside the Docker network (mapped to the host as needed)

-   Implements the core business logic:

    -   Validates input from the frontend

    -   Applies rules for batches, schedules, and fees

    -   Manages CRUD operations for players, coaches, and other entities

-   Uses JPA/Hibernate to talk to PostgreSQL

Example environment configuration in Compose:

text

`environment:  DATABASE_URL: jdbc:postgresql://db:5432/cricket_academy DATABASE_USERNAME: postgres DATABASE_PASSWORD: admin HIBERNATE_DDL_AUTO: update SHOW_SQL: "true" `

All backend access to the database uses the internal hostname `db`, not `localhost`.

* * * * *

3\. PostgreSQL Database (Persistence Layer)
-------------------------------------------

-   Runs as a dedicated container (e.g. `postgres:16-alpine`)

-   Listens on port 5432 inside the Docker network

-   Stores persistent data for:

    -   Player records

    -   Coach information

    -   Batches and schedules

A Docker volume (e.g. `db-data`) is mounted at `/var/lib/postgresql/data` so data survives container restarts.

* * * * *

🔗 Service Communication
------------------------

All services share a common Docker network created by Docker Compose:

-   Frontend → Backend: HTTP calls using `http://backend:8080/api/...`

-   Backend → Database: JDBC URL `jdbc:postgresql://db:5432/cricket_academy`

-   Host → Services:

    -   Frontend: `http://localhost:5000`

    -   Backend (optional direct access): `http://localhost:8080`

    -   Database (optional, via mapped port): `localhost:<host_port>` (e.g. 5433 → 5432 in container)

Because everything is in containers, there is no need to install Java, Python, or PostgreSQL directly on the host.

* * * * *

🚀 Getting Started
------------------

1\. Prerequisites
-----------------

-   Docker

-   Docker Compose

-   Git (to clone the repository)

2\. Clone the Repository
------------------------

bash

`git clone https://github.com/Thamaraikannan00011/Cricket-Academy-Project.git cd Cricket-Academy-Project `

3\. Start the Stack
-------------------

Run all services in the background:

bash

`docker compose up -d `

Docker Compose will:

-   Start the PostgreSQL database

-   Wait until the DB is healthy

-   Start the Spring Boot backend

-   Start the Flask frontend

Check status:

bash

`docker compose ps  `

You should see the `db`, `backend`, and `frontend` containers in `Up` state.

4. Access the Application
--------------------------

-   Open the UI: `http://localhost:12345`

* * * * *

🔧 Common Commands
------------------

-   remove all containers:

    bash

    `docker compose down `

-   remove all containers with :

    bash

    `docker compose down -v`

-   View logs for a specific service:

    bash

    `docker compose logs -f backend (or) docker compose logs -f frontend (or) docker compose logs -f db `