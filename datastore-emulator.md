# Datastore Emulator

## Getting Started
To avoid using the production Datastore database while testing, follow this guide to emulate a Datastore instance locally.

You can return to this walkthrough anytime by running this command:

```bash
teachme ~/spring21-sps-26/datastore-emulator.md
```

Click the **Start** button to begin!

## Run the emulator

1. Open a new cloudshell.
2. Set the Google cloud project id with the following command:

```bash
gcloud config set project spring21-sps-26
```

3. Navigate to the folder of the project. In this case, run:

```bash
cd ~/spring21-sps-26
```

4. Start the emulator with the following command:

```bash
gcloud beta emulators datastore start
```

Your Datastore emulator is already running!

## Link the emulator

1. Open a new cloudshell.
2. Set the Google cloud project id with the following command:

```bash
gcloud config set project spring21-sps-26
```

3. Navigate to the folder of the project. In this case, run:

```bash
cd ~/spring21-sps-26
```

4. In the cloudshell where your emulator is running, look for a message in the output that looks like this:

```
Storage: /tmp/tmp.YOUR_PATH_HERE/emulators/datastore/WEB-INF/appengine-generated/local_db.bin
```

The `YOUR_PATH_HERE` will be a random string of characters.

5. In the cloudshell that is not running the emulator, run the following command replacing `YOUR_PATH_HERE` with the string you got on your second cloudshell:

```bash
$(gcloud beta emulators datastore env-init --data-dir=/tmp/tmp.YOUR_PATH_HERE/emulators/datastore)
```

This command will link your first cloudshell with the emulator - which is running on the second cloudshell.

Your Datastore emulator now linked!

## Run maven

In the cloudshell where you linked the Datastore emulator - not the one that is running the emulator. Execute this command to run the project:

```bash
mvn package exec:java
```

Even when you restart the server, the data will be saved as long as the emulator is running.