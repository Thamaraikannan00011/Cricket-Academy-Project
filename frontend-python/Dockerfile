FROM python:3.11-alpine

WORKDIR /app
# to Prevents Python from writing .pyc files to disk and Reduces image size
ENV PYTHONDONTWRITEBYTECODE=1 
# to logs are displayed immediately in the Docker container output
ENV PYTHONUNBUFFERED=1

COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

COPY . .

EXPOSE 5000
CMD ["python", "app.py"]