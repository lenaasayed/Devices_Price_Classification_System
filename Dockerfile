FROM python:3.7.6
# Set a special Python settings for being able to see logs
ENV PYTHONUNBUFFERED=TRUE
# Set the working directory to /app
WORKDIR /app
# Copy the requirements.txt file
COPY requirements.txt requirements.txt
# Install the library in  requirements.txt
RUN pip install --no-cache-dir -r requirements.txt
# Copy the rest of the project files
COPY . .
# Copy the code as well as the model
COPY ["*.py", "device-model.bin", "./"]
# Open the port that web service uses
EXPOSE 9700
# Specify how the service should be started
ENTRYPOINT ["waitress-serve","--host=0.0.0.0", "--port=9700","app:app"]